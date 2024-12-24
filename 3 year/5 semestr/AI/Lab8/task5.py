import numpy as np
from sklearn import datasets
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.linear_model import Perceptron
from sklearn.datasets import make_classification
import matplotlib.pyplot as plt
from sklearn.metrics import accuracy_score

iris = datasets.load_iris()

X_separable, y_separable = make_classification(n_samples=100, n_features=2, n_informative=2, n_redundant=0, 
                                               n_clusters_per_class=1, n_classes=2, random_state=42)

scaler = StandardScaler()
X_normalized = scaler.fit_transform(iris.data)

X_train, X_temp, y_train, y_temp = train_test_split(X_normalized, iris.target, test_size=0.3, random_state=42)
X_val, X_test, y_val, y_test = train_test_split(X_temp, y_temp, test_size=0.5, random_state=42)

perceptron = Perceptron(max_iter=1000, eta0=0.1, random_state=0)
perceptron.fit(X_train, y_train)

y_val_pred = perceptron.predict(X_val)
accuracy_val = accuracy_score(y_val, y_val_pred)
print(f"Accuracy on validation set (eta0=0.1): {accuracy_val:.4f}")

perceptron = Perceptron(max_iter=1000, eta0=0.01, random_state=0)
perceptron.fit(X_train, y_train)

y_val_pred = perceptron.predict(X_val)
accuracy_val = accuracy_score(y_val, y_val_pred)
print(f"Accuracy on validation set (eta0=0.01): {accuracy_val:.4f}")

y_test_pred = perceptron.predict(X_test)
accuracy_test = accuracy_score(y_test, y_test_pred)
print(f"Accuracy on test set: {accuracy_test:.4f}")

plt.figure(figsize=(8, 6))

plt.scatter(X_separable[y_separable == 0][:, 0], X_separable[y_separable == 0][:, 1], color='red', label='Class 0')
plt.scatter(X_separable[y_separable == 1]
