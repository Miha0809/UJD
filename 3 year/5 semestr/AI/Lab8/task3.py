import numpy as np
from sklearn import datasets
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.linear_model import Perceptron
from sklearn.datasets import make_classification
import matplotlib.pyplot as plt

iris = datasets.load_iris()

X_separable, y_separable = make_classification(
    n_samples=100,
    n_features=2,
    n_informative=2,
    n_redundant=0,
    n_clusters_per_class=1,
    n_classes=2,
    random_state=42,
)

scaler = StandardScaler()
X_normalized = scaler.fit_transform(iris.data)

X_train, X_temp, y_train, y_temp = train_test_split(
    X_normalized, iris.target, test_size=0.3, random_state=42
)

perceptron = Perceptron(max_iter=1000, eta0=0.1, random_state=0)
perceptron.fit(X_train, y_train)

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

x_values = np.linspace(X_separable[:, 0].min(), X_separable[:, 0].max(), 100)
y_values = (
    -(perceptron.coef_[0][0] * x_values + perceptron.intercept_[0])
    / perceptron.coef_[0][1]
)
plt.plot(x_values, y_values, color="black", linestyle="--", label="Decision Boundary")

plt.xlabel("Feature 1")
plt.ylabel("Feature 2")
plt.title("Linearly separable data and the decision boundary of the perceptron")
plt.legend()
plt.grid(True)
plt.show()
