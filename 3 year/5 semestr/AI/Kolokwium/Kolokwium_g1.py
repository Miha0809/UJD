import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder, StandardScaler
from sklearn.linear_model import Perceptron
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt
import numpy as np

# Zadanie 1
file_path = 'data.csv'
df = pd.read_csv(file_path)

print("Pierwsze 5 wierszy:")
print(df.head())

print("\nNazwy kolumn:")
print(df.columns)

print(f"\nLiczba wierszy (próbek): {df.shape[0]}")
print(f"Liczba kolumn (cech): {df.shape[1]}")

print("\nSprawdzenie kolumn zawierających same NaN:")
print(df.isna().sum())

if 'id' in df.columns:
    df.drop('id', axis=1, inplace=True)
if 'Unnamed: 32' in df.columns:
    df.drop('Unnamed: 32', axis=1, inplace=True)

print("\nZaktualizowane dane (po usunięciu zbędnych kolumn):")
print(df.head())

# Zadanie 2
if 'diagnosis' not in df.columns:
    raise ValueError("Kolumna 'diagnosis' nie istnieje w zbiorze danych.")

selected_features = ['radius_mean', 'texture_mean']
if not all(feature in df.columns for feature in selected_features):
    raise ValueError(f"Jedna lub więcej wybranych cech: {selected_features} nie istnieje w zbiorze danych.")

X_2d = df[selected_features]
y = df['diagnosis']

print("Pierwsze 5 wierszy cech (X_2d):")
print(X_2d.head())

print("\nPierwsze 5 etykiet (y):")
print(y.head())

X_2d_values = X_2d.values
y_values = y.values

print("\nMacierz cech (X_2d):", X_2d_values[:5])
print("\nWektor etykiet (y):", y_values[:5])

# Zadanie 3
label_encoder = LabelEncoder()
y_encoded = label_encoder.fit_transform(y)

X_train, X_temp, y_train, y_temp = train_test_split(
    X_2d, y_encoded, test_size=0.3, random_state=42, stratify=y_encoded
)

X_val, X_test, y_val, y_test = train_test_split(
    X_temp, y_temp, test_size=0.5, random_state=42, stratify=y_temp
)

print(f"Rozmiar zbioru treningowego: {X_train.shape[0]} próbek")
print(f"Rozmiar zbioru walidacyjnego: {X_val.shape[0]} próbek")
print(f"Rozmiar zbioru testowego: {X_test.shape[0]} próbek")

print("\nPrzykładowe dane z X_train:")
print(X_train.head())
print("\nPrzykładowe etykiety z y_train:")
print(y_train[:5])

# Zadanie 4
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_val_scaled = scaler.transform(X_val)
X_test_scaled = scaler.transform(X_test)

perceptron = Perceptron(max_iter=5000, eta0=0.001, random_state=42)
perceptron.fit(X_train_scaled, y_train)

y_val_pred = perceptron.predict(X_val_scaled)
val_accuracy = accuracy_score(y_val, y_val_pred)
print(f"Dokładność na zbiorze walidacyjnym: {val_accuracy * 100:.2f}%")

y_test_pred = perceptron.predict(X_test_scaled)
test_accuracy = accuracy_score(y_test, y_test_pred)
print(f"Dokładność na zbiorze testowym: {test_accuracy * 100:.2f}%")

# Zadanie 5
X_combined = np.vstack((X_train_scaled, X_val_scaled, X_test_scaled))
y_combined = np.hstack((y_train, y_val, y_test))

plt.figure(figsize=(8, 6))
for label, color, label_name in zip([0, 1], ['blue', 'red'], ['Benign', 'Malignant']):
    plt.scatter(
        X_combined[y_combined == label][:, 0],
        X_combined[y_combined == label][:, 1],
        c=color, label=label_name, alpha=0.7, edgecolors='k'
    )

x_values = np.linspace(X_combined[:, 0].min(), X_combined[:, 0].max(), 100)
y_values = -(perceptron.coef_[0][0] * x_values + perceptron.intercept_[0]) / perceptron.coef_[0][1]
plt.plot(x_values, y_values, color='black', linestyle='--', label='Granica decyzyjna')

plt.xlabel('Cechy: radius_mean (skalowane)')
plt.ylabel('Cechy: texture_mean (skalowane)')
plt.title('Wizualizacja danych i granicy decyzyjnej perceptronu')
plt.legend()
plt.grid(True)
plt.show()

# Wnioski
# Granica decyzyjna oddziela klasy 0 (Benign) i 1 (Malignant). W przypadku dużej liczby punktów błędnie zaklasyfikowanych 
# (tj. znajdujących się "po złej stronie" granicy), model wymaga dostosowania parametrów perceptronu (np. learning rate, liczby iteracji)
# lub zastosowania bardziej złożonego modelu.
