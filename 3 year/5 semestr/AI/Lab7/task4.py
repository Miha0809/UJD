import numpy as np
import matplotlib.pyplot as plt
import time
from sklearn.preprocessing import StandardScaler

np.random.seed(1)


def pocket_algorithm(X_train, Y, learningRate=0.01, max_iterations=7000):
    weights = np.random.rand(X_train.shape[1], 1)
    misClassifications = 1
    minMisclassifications = 10000
    iteration = 0
    while misClassifications != 0 and iteration < max_iterations:
        iteration += 1
        misClassifications = 0
        for i in range(0, len(X_train)):
            currentX = X_train[i].reshape(-1, X_train.shape[1])
            currentY = Y[i]
            wTx = np.dot(currentX, weights)[0][0]
            if currentY == 1 and wTx < 0:
                misClassifications += 1
                weights = weights + learningRate * np.transpose(currentX)
            elif currentY == -1 and wTx > 0:
                misClassifications += 1
                weights = weights - learningRate * np.transpose(currentX)
    return minMisclassifications


data_sizes = [100, 1000, 10000]
times = []

for size in data_sizes:
    data = np.random.rand(size, 5)  # 5 cech
    Y = np.random.choice([-1, 1], size=size)
    X_train = data[:, :-1]

    scaler = StandardScaler()
    X_train = scaler.fit_transform(X_train)

    oneVector = np.ones((X_train.shape[0], 1))
    X_train = np.concatenate((oneVector, X_train), axis=1)

    start_time = time.time()
    pocket_algorithm(X_train, Y, learningRate=0.01)
    end_time = time.time()

    elapsed_time = end_time - start_time
    times.append(elapsed_time)
    print(f"Rozmiar danych: {size}, Czas wykonania: {elapsed_time:.4f} sekund")

plt.plot(data_sizes, times, marker="o")
plt.xlabel("Rozmiar danych")
plt.ylabel("Czas wykonania (sekundy)")
plt.title("Czas wykonania algorytmu kieszonkowego dla różnych rozmiarów danych")
plt.show()
