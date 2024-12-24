import numpy as np
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cdist
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
from sklearn.metrics import adjusted_rand_score

iris = load_iris()
data = iris.data
true_labels = iris.target

scaler = StandardScaler()
data = scaler.fit_transform(data)


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

    cluster_assignments = np.argmin(
        np.linalg.norm(weights[None, :, :] - data[:, None, :], axis=2), axis=1
    )
    return cluster_assignments


def kmeans(data, num_clusters, num_iterations=100, tol=1e-4):
    num_samples, num_features = data.shape
    centroids = data[np.random.choice(num_samples, 1)]
    for _ in range(num_clusters - 1):
        dist_to_centroids = cdist(data, centroids, "euclidean")
        prob = np.min(dist_to_centroids, axis=1)
        prob = prob / np.sum(prob)
        next_centroid = data[np.random.choice(num_samples, 1, p=prob)]
        centroids = np.vstack([centroids, next_centroid])

    for _ in range(num_iterations):
        distances = cdist(data, centroids, "euclidean")
        labels = np.argmin(distances, axis=1)

        new_centroids = np.array(
            [data[labels == j].mean(axis=0) for j in range(num_clusters)]
        )

        if np.all(np.abs(centroids - new_centroids) < tol):
            break

        centroids = new_centroids

    return labels


num_clusters = 3
kohonen_clusters = kohonen_train(data, num_clusters, num_epochs=100, learning_rate=0.1)
kmeans_clusters = kmeans(data, num_clusters)

kohonen_ari = adjusted_rand_score(true_labels, kohonen_clusters)
kmeans_ari = adjusted_rand_score(true_labels, kmeans_clusters)

print(f"ARI dla Kohonena: {kohonen_ari}")
print(f"ARI dla KMeans: {kmeans_ari}")

plt.figure()
plt.scatter(data[:, 0], data[:, 1], c=kohonen_clusters)
plt.title("Kohonen Clustering")
plt.show()

plt.figure()
plt.scatter(data[:, 0], data[:, 1], c=kmeans_clusters)
plt.title("KMeans Clustering (Custom Implementation)")
plt.show()
