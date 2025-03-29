import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.preprocessing import LabelEncoder, StandardScaler

data = pd.read_csv('wine-dataset.txt', header=None, sep='\t')

y_wine = data.iloc[:, 0].values
X_wine = data.iloc[:, 1:].values

label_encoder = LabelEncoder()
y_wine = label_encoder.fit_transform(y_wine)

scaler = StandardScaler()
X_wine = scaler.fit_transform(X_wine)

X_train, X_temp, y_train, y_temp = train_test_split(X_wine, y_wine, test_size=0.4, random_state=42)
X_val, X_test, y_val, y_test = train_test_split(X_temp, y_temp, test_size=0.5, random_state=42)

perceptron = MLPClassifier(hidden_layer_sizes=(10,), max_iter=2000, random_state=42)
perceptron.fit(X_train, y_train)

train_accuracy = perceptron.score(X_train, y_train)
val_accuracy = perceptron.score(X_val, y_val)
test_accuracy = perceptron.score(X_test, y_test)

print("Training accuracy:", train_accuracy)
print("Validation accuracy:", val_accuracy)
print("Test accuracy:", test_accuracy)
