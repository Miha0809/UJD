import numpy as np
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cdist
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris
from sklearn.metrics import adjusted_rand_score, silhouette_score
from sklearn.metrics import pairwise_distances_argmin_min

iris = load_iris()
data = iris.data
true_labels = iris.target

scaler = StandardScaler()
data = scaler.fit_transform(data)


def kohonen_train(data, num_clusters, num_epochs, learning_rate):
    weights = np.random.rand(num_clusters, data.shape[1])

    for epoch in range(num_epochs):
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


def evaluate_clustering(true_labels, cluster_assignments):
    ari = adjusted_rand_score(true_labels, cluster_assignments)
    silhouette = silhouette_score(data, cluster_assignments)
    return ari, silhouette


cluster_range = range(2, 11)
ari_kohonen = []
silhouette_kohonen = []
ari_kmeans = []
silhouette_kmeans = []

for num_clusters in cluster_range:
    kohonen_clusters = kohonen_train(
        data, num_clusters, num_epochs=100, learning_rate=0.1
    )
    ari_kohonen_val, silhouette_kohonen_val = evaluate_clustering(
        true_labels, kohonen_clusters
    )
    ari_kohonen.append(ari_kohonen_val)
    silhouette_kohonen.append(silhouette_kohonen_val)
    kmeans_clusters = kmeans(data, num_clusters)
    ari_kmeans_val, silhouette_kmeans_val = evaluate_clustering(
        true_labels, kmeans_clusters
    )
    ari_kmeans.append(ari_kmeans_val)
    silhouette_kmeans.append(silhouette_kmeans_val)

plt.figure(figsize=(12, 6))
plt.subplot(2, 2, 1)
plt.plot(cluster_range, ari_kohonen, marker="o", label="Kohonen")
plt.title("Adjusted Rand Index for Kohonen")
plt.xlabel("Number of Clusters")
plt.ylabel("ARI")
plt.subplot(2, 2, 2)
plt.plot(cluster_range, ari_kmeans, marker="o", label="KMeans")
plt.title("Adjusted Rand Index for KMeans")
plt.xlabel("Number of Clusters")
plt.ylabel("ARI")

plt.subplot(2, 2, 3)
plt.plot(cluster_range, silhouette_kohonen, marker="o", label="Kohonen")
plt.title("Silhouette Score for Kohonen")
plt.xlabel("Number of Clusters")
plt.ylabel("Silhouette Score")
plt.subplot(2, 2, 4)
plt.plot(cluster_range, silhouette_kmeans, marker="o", label="KMeans")
plt.title("Silhouette Score for KMeans")
plt.xlabel("Number of Clusters")
plt.ylabel("Silhouette Score")

plt.tight_layout()
plt.show()
