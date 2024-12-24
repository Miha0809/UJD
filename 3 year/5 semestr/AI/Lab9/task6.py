from sklearn.datasets import load_wine
from sklearn.preprocessing import StandardScaler
import numpy as np
import matplotlib.pyplot as plt
from scipy.spatial.distance import cdist

wine = load_wine()
data = wine.data

scaler = StandardScaler()
data = scaler.fit_transform(data)

num_clusters = 3


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


kohonen_clusters = kohonen_train(data, num_clusters, num_epochs=100, learning_rate=0.1)
kmeans_clusters = kmeans(data, num_clusters)

plt.figure()
plt.scatter(data[:, 0], data[:, 1], c=kohonen_clusters)
plt.title("Kohonen Clustering (Wine Dataset)")
plt.show()

plt.figure()
plt.scatter(data[:, 0], data[:, 1], c=kmeans_clusters)
plt.title("KMeans Clustering (Wine Dataset)")
plt.show()

kohonen_clusters, kmeans_clusters
