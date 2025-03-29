import numpy as np
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cdist
import matplotlib.pyplot as plt
from sklearn.datasets import load_wine
from sklearn.metrics import adjusted_rand_score

wine = load_wine()
data = wine.data
target = wine.target

scaler = StandardScaler()
data = scaler.fit_transform(data)

def kohonen_algorithm(data, num_clusters, num_epochs=100, learning_rate=0.1):
    num_features = data.shape[1]
    weights = np.random.rand(num_clusters, num_features)
    
    for epoch in range(num_epochs):
        distances = np.linalg.norm(data[:, np.newaxis] - weights, axis=2) 
        winner_indices = np.argmin(distances, axis=1)
        
        for i in range(num_clusters):
            weights[i, :] += learning_rate * np.sum(data[winner_indices == i] - weights[i, :], axis=0)
    
    cluster_assignments = np.argmin(np.linalg.norm(data[:, np.newaxis] - weights, axis=2), axis=1)
    return cluster_assignments

def kmeans_algorithm(data, num_clusters, num_iterations=100):
    num_samples, num_features = data.shape
    centroids = data[np.random.choice(num_samples, num_clusters, replace=False)]
    
    for _ in range(num_iterations):
        distances = cdist(data, centroids, 'euclidean')
        labels = np.argmin(distances, axis=1)

        new_centroids = np.array([data[labels == j].mean(axis=0) for j in range(num_clusters)])

        if np.all(centroids == new_centroids):
            break

        centroids = new_centroids

    return labels

def plot_clustering(data, cluster_assignments, title):
    plt.figure()
    plt.scatter(data[:, 0], data[:, 1], c=cluster_assignments)
    plt.title(title)
    plt.show()

num_clusters_list = [2, 3, 4, 5]

for num_clusters in num_clusters_list:
    kohonen_clusters = kohonen_algorithm(data, num_clusters)
    kmeans_clusters = kmeans_algorithm(data, num_clusters)

    kohonen_ari = adjusted_rand_score(target, kohonen_clusters)
    kmeans_ari = adjusted_rand_score(target, kmeans_clusters)

    print(f"Num clusters: {num_clusters}")
    print(f"Kohonen Clustering ARI: {kohonen_ari}")
    print(f"KMeans Clustering ARI: {kmeans_ari}")

    plot_clustering(data, kohonen_clusters, f'Kohonen Clustering (num_clusters={num_clusters})')
    plot_clustering(data, kmeans_clusters, f'KMeans Clustering (num_clusters={num_clusters})')
