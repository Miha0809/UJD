import numpy as np
from sklearn.datasets import make_classification
import matplotlib.pyplot as plt

X_separable, y_separable = make_classification(
    n_samples=100,
    n_features=2,
    n_informative=2,
    n_redundant=0,
    n_clusters_per_class=1,
    n_classes=2,
    random_state=42,
)

plt.figure(figsize=(8, 6))

plt.scatter(
    X_separable[y_separable == 0][:, 0],
    X_separable[y_separable == 0][:, 1],
    color="red",
    label="Class 0",
)
plt.scatter(
    X_separable[y_separable == 1][:, 0],
    X_separable[y_separable == 1][:, 1],
    color="blue",
    label="Class 1",
)

plt.xlabel("Feature 1")
plt.ylabel("Feature 2")
plt.title("Linearly separable data")
plt.legend()
plt.grid(True)
plt.show()
