import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.metrics import accuracy_score

data = pd.read_csv('wine-dataset.txt', header=None, sep='\t')

y_wine = data.iloc[:, 0].values
X_wine = data.iloc[:, 1:].values

label_encoder = LabelEncoder()
y_wine = label_encoder.fit_transform(y_wine)

X_train, X_temp, y_train, y_temp = train_test_split(X_wine, y_wine, test_size=0.4, random_state=42)
X_val, X_test, y_val, y_test = train_test_split(X_temp, y_temp, test_size=0.5, random_state=42)

scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_val = scaler.transform(X_val)
X_test = scaler.transform(X_test)

perceptron = MLPClassifier(hidden_layer_sizes=(50,), max_iter=5000, random_state=42, learning_rate_init=0.001)
perceptron.fit(X_train, y_train)

y_val_pred = perceptron.predict(X_val)

print("Validation accuracy:", accuracy_score(y_val, y_val_pred))

perceptron = MLPClassifier(hidden_layer_sizes=(50,), max_iter=5000, random_state=42, learning_rate_init=0.0001)
perceptron.fit(X_train, y_train)

y_val_pred = perceptron.predict(X_val)

print("Validation accuracy with adjusted learning rate:", accuracy_score(y_val, y_val_pred))
