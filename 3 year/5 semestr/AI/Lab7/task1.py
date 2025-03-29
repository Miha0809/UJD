import numpy as np
import matplotlib.pyplot as plt

np.random.seed(1)
data = np.genfromtxt("input.txt", delimiter=",")

learningRate = 0.01
data = np.delete(data, [3], axis=1)
Y = data[:, -1]
X_train = np.delete(data, [3], axis=1)
oneVector = np.ones((X_train.shape[0], 1))
X_train = np.concatenate((oneVector, X_train), axis=1)

plotData = []
weights = np.random.rand(4, 1)
misClassifications = 1
minMisclassifications = 10000

iteration = 0
noChangeCounter = 0
maxNoChangeIterations = 500

while (
    misClassifications != 0
    and iteration < 7000
    and noChangeCounter < maxNoChangeIterations
):
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
        noChangeCounter = 0
    else:
        noChangeCounter += 1

    print(f"Iteracja {iteration}, Błędne klasyfikacje {misClassifications}")

print(f"Błędnych klasyfikacji: {minMisclassifications}")
print(weights.transpose())
print(
    f"Najlepsza dokładność algorytmu uczenia kieszonkowego wynosi: {(((X_train.shape[0]-minMisclassifications)/X_train.shape[0])*100)}%"
)

plt.plot(np.arange(0, iteration), plotData)
plt.xlabel("Liczba iteracji")
plt.ylabel("Liczba błędnych klasyfikacji")
plt.show()
