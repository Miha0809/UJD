import numpy as np
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cdist
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
from sklearn.metrics import accuracy_score, adjusted_rand_score
from scipy.stats import mode

iris = load_iris()
data = iris.data
true_labels = iris.target

scaler = StandardScaler()
data = scaler.fit_transform(data)

num_clusters = 3
num_epochs = 100
learning_rate = 0.1


def kohonen_train(data, num_clusters, num_epochs, learning_rate):
    weights = np.random.rand(num_clusters, data.shape[1])

    for _ in range(num_epochs):
        for i in range(data.shape[0]):
            input_vector = data[i, :]
            distances = np.linalg.norm(weights - input_vector, axis=1)
            winner_index = np.argmin(distances)
            weights[winner_index, :] += learning_rate * (
                input_vector - weights[winner_index, :]
            )

    cluster_assignments = np.zeros(data.shape[0], dtype=int)
    for i in range(data.shape[0]):
        input_vector = data[i, :]
        distances = np.linalg.norm(weights - input_vector, axis=1)
        cluster_assignments[i] = np.argmin(distances)

    return cluster_assignments


def kmeans(data, num_clusters, num_iterations=100):
    num_samples, num_features = data.shape
    centroids = data[np.random.choice(num_samples, num_clusters, replace=False)]

    for _ in range(num_iterations):
        distances = cdist(data, centroids, "euclidean")
        labels = np.argmin(distances, axis=1)

        new_centroids = np.array(
            [data[labels == j].mean(axis=0) for j in range(num_clusters)]
        )

        if np.all(centroids == new_centroids):
            break

        centroids = new_centroids

    return labels


kohonen_clusters = kohonen_train(data, num_clusters, num_epochs, learning_rate)
kmeans_clusters = kmeans(data, num_clusters)


def map_clusters_to_labels(clusters, true_labels):
    mapped_labels = np.zeros_like(clusters)
    for i in range(len(np.unique(clusters))):
        cluster_indices = np.where(clusters == i)[0]
        most_common_label = mode(true_labels[cluster_indices])[0][0]
        mapped_labels[cluster_indices] = most_common_label
    return mapped_labels


kohonen_mapped_labels = map_clusters_to_labels(kohonen_clusters, true_labels)
kmeans_mapped_labels = map_clusters_to_labels(kmeans_clusters, true_labels)
kohonen_accuracy = accuracy_score(true_labels, kohonen_mapped_labels)
kmeans_accuracy = accuracy_score(true_labels, kmeans_mapped_labels)
kohonen_ari = adjusted_rand_score(true_labels, kohonen_mapped_labels)
kmeans_ari = adjusted_rand_score(true_labels, kmeans_mapped_labels)

print(f"Kohonen Accuracy: {kohonen_accuracy:.4f}")
print(f"KMeans Accuracy: {kmeans_accuracy:.4f}")
print(f"Kohonen ARI: {kohonen_ari:.4f}")
print(f"KMeans ARI: {kmeans_ari:.4f}")

plt.figure(figsize=(12, 8))
plt.subplot(2, 2, 1)
plt.scatter(data[:, 0], data[:, 1], c=kohonen_mapped_labels)
plt.title("Kohonen Clustering")

plt.subplot(2, 2, 2)
plt.scatter(data[:, 0], data[:, 1], c=kmeans_mapped_labels)
plt.title("KMeans Clustering")

plt.subplot(2, 2, 3)
plt.scatter(data[:, 0], data[:, 1], c=true_labels)
plt.title("True Labels (Ground Truth)")

plt.tight_layout()
plt.show()
