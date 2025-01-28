import numpy as np
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cdist
import matplotlib.pyplot as plt
from sklearn.datasets import load_iris

iris = load_iris()
data = iris.data

scaler = StandardScaler()
data = scaler.fit_transform(data)

num_clusters = 3
learning_rate = 0.1

num_features = data.shape[1]
weights = np.random.rand(num_clusters, num_features)

def kohonen_network(data, num_clusters, num_epochs, learning_rate):
    num_features = data.shape[1]
    weights = np.random.rand(num_clusters, num_features)
    
    for epoch in range(num_epochs):
        for i in range(data.shape[0]):
            input_vector = data[i, :]
            distances = np.linalg.norm(weights - input_vector, axis=1)
            winner_index = np.argmin(distances)
            weights[winner_index, :] += learning_rate * (input_vector - weights[winner_index, :])
    
    cluster_assignments = np.zeros(data.shape[0], dtype=int)
    for i in range(data.shape[0]):
        input_vector = data[i, :]
        distances = np.linalg.norm(weights - input_vector, axis=1)
        cluster_assignments[i] = np.argmin(distances)
    
    return cluster_assignments, weights

epochs_list = [10, 50, 100, 200]
for num_epochs in epochs_list:
    cluster_assignments, weights = kohonen_network(data, num_clusters, num_epochs, learning_rate)
    
    plt.figure()
    plt.scatter(data[:, 0], data[:, 1], c=cluster_assignments)
    plt.title(f'Kohonen Clustering with {num_epochs} Epochs')
    plt.show()

def kmeans(data, num_clusters, num_iterations=100):
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

kmeans_clusters = kmeans(data, num_clusters)

plt.figure()
plt.scatter(data[:, 0], data[:, 1], c=kmeans_clusters)
plt.title('KMeans Clustering (Custom Implementation)')
plt.show()
