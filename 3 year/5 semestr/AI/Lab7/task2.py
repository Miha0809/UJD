import numpy as np
import matplotlib.pyplot as plt

np.random.seed(1)
data = np.genfromtxt("input.txt", delimiter=",")

data = np.delete(data, [3], axis=1)
Y = data[:, -1]
X_train = np.delete(data, [3], axis=1)
oneVector = np.ones((X_train.shape[0], 1))
X_train = np.concatenate((oneVector, X_train), axis=1)


def pocket_algorithm(learningRate):
    plotData = []
    weights = np.random.rand(4, 1)
    misClassifications = 1
    minMisclassifications = 10000

    iteration = 0
    while misClassifications != 0 and iteration < 7000:
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
        plotData.append(misClassifications)
        if misClassifications < minMisclassifications:
            minMisclassifications = misClassifications

        print(
            f"Learning Rate: {learningRate} | Iteracja {iteration}, Błędne klasyfikacje {misClassifications}"
        )

    print(
        f"Learning Rate: {learningRate} | Błędnych klasyfikacji: {minMisclassifications}"
    )
    print(
        f"Learning Rate: {learningRate} | Najlepsza dokładność: {(((X_train.shape[0]-minMisclassifications)/X_train.shape[0])*100)}%"
    )
    return plotData


learningRates = [0.001, 0.05, 0.1]
plotDataAll = {}

for lr in learningRates:
    plotDataAll[lr] = pocket_algorithm(lr)

for lr in learningRates:
    plt.plot(np.arange(0, 7000), plotDataAll[lr], label=f"LR = {lr}")

plt.xlabel("Liczba iteracji")
plt.ylabel("Liczba błędnych klasyfikacji")
plt.legend()
plt.show()