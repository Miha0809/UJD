
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import Perceptron

def main():
    # Zadanie 1
    try:
        df = pd.read_csv('heart.csv')
    except FileNotFoundError:
        print("Plik heart.csv nie został znaleziony. Upewnij się, że znajduje się w tym samym folderze co skrypt.")
        return

    print("\nPierwsze wiersze danych:")
    print(df.head())
    print("\nNazwy kolumn:")
    print(df.columns)

    print("\nLiczba wierszy i kolumn:")
    print(f"Wiersze: {df.shape[0]}, Kolumny: {df.shape[1]}")

    if 'id' in df.columns:
        df.drop('id', axis=1, inplace=True)
    if 'Unnamed: 32' in df.columns:
        df.drop('Unnamed: 32', axis=1, inplace=True)

    print("\nDane po usunięciu zbędnych kolumn:")
    print(df.head())

    # Zadanie 2
    if 'target' not in df.columns:
        print("\nKolumna 'target' nie została znaleziona w danych.")
        return

    y = df['target']
    X_2d = df[['chol', 'trestbps']]

    print("\nWektor etykiet (y):")
    print(y.head())
    print("\nWybrane cechy (X_2d):")
    print(X_2d.head())

    # Zadanie 3
    X_train, X_temp, y_train, y_temp = train_test_split(X_2d, y, test_size=0.3, random_state=42)
    X_val, X_test, y_val, y_test = train_test_split(X_temp, y_temp, test_size=0.5, random_state=42)

    print("\nRozmiary zbiorów:")
    print(f"Zbiór treningowy: {X_train.shape[0]} próbek")
    print(f"Zbiór walidacyjny: {X_val.shape[0]} próbek")
    print(f"Zbiór testowy: {X_test.shape[0]} próbek")
    print(f"Suma: {X_train.shape[0] + X_val.shape[0] + X_test.shape[0]} próbek")

    # Zadanie 4
    scaler = StandardScaler()
    X_train_scaled = scaler.fit_transform(X_train)
    X_val_scaled = scaler.transform(X_val)
    X_test_scaled = scaler.transform(X_test)

    perceptron = Perceptron(max_iter=5000, eta0=0.001, random_state=42)
    perceptron.fit(X_train_scaled, y_train)

    print("\nModel został wytrenowany.")

    # Zadanie 5
    X_all_scaled = np.vstack((X_train_scaled, X_val_scaled, X_test_scaled))
    y_all = np.hstack((y_train, y_val, y_test))

    w1, w2 = perceptron.coef_[0]
    b = perceptron.intercept_[0]

    plt.figure(figsize=(8, 6))

    plt.scatter(X_all_scaled[y_all == 0, 0], X_all_scaled[y_all == 0, 1], color='blue', label='Klasa 0 (brak choroby)', alpha=0.6)
    plt.scatter(X_all_scaled[y_all == 1, 0], X_all_scaled[y_all == 1, 1], color='red', label='Klasa 1 (choroba)', alpha=0.6)
    
    x_min, x_max = X_all_scaled[:, 0].min() - 1, X_all_scaled[:, 0].max() + 1
    x_values = np.linspace(x_min, x_max, 100)
    y_values = -(b + w1 * x_values) / w2
    plt.plot(x_values, y_values, color='green', label='Linia decyzyjna')

    plt.title("Wizualizacja danych i linii decyzyjnej perceptronu")
    plt.xlabel("Standaryzowana wartość cechy 1 (chol)")
    plt.ylabel("Standaryzowana wartość cechy 2 (trestbps)")
    plt.legend()
    plt.grid(True)
    plt.show()

if __name__ == "__main__":
    main()
