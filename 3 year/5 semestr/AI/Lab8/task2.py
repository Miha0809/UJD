import pandas as pd
from sklearn.model_selection import train_test_split

data = pd.read_csv('wine-dataset.txt', header=None, sep='\t')

y_wine = data.iloc[:, 0].values
X_wine = data.iloc[:, 1:].values

X_train, X_temp, y_train, y_temp = train_test_split(X_wine, y_wine, test_size=0.4, random_state=42)
X_val, X_test, y_val, y_test = train_test_split(X_temp, y_temp, test_size=0.5, random_state=42)

print("Shape of X_train:", X_train.shape)
print("Shape of y_train:", y_train.shape)
print("Shape of X_val:", X_val.shape)
print("Shape of y_val:", y_val.shape)
print("Shape of X_test:", X_test.shape)
print("Shape of y_test:", y_test.shape)
