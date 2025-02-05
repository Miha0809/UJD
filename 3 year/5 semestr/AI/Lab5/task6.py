import numpy as np
import matplotlib.pyplot as plt

def trimf(x, params):
    a, b, c = params
    return np.maximum(0, np.minimum((x - a) / np.maximum(1e-10, b - a), (c - x) / np.maximum(1e-10, c - b)))

def generate_fuzzy_sets(x, y):
    small_x = trimf(x, [-np.pi, -np.pi / 2, 0])
    medium_x = trimf(x, [-np.pi / 2, 0, np.pi / 2])
    large_x = trimf(x, [0, np.pi / 2, np.pi])

    small_y = trimf(y, [-np.pi, -np.pi / 2, 0])
    medium_y = trimf(y, [-np.pi / 2, 0, np.pi / 2])
    large_y = trimf(y, [0, np.pi / 2, np.pi])

    return small_x, medium_x, large_x, small_y, medium_y, large_y

def fuzzy_approximation(x, y):
    X, Y = np.meshgrid(x, y)
    Z = np.sin(X) + np.cos(Y)

    small_x, medium_x, large_x, small_y, medium_y, large_y = generate_fuzzy_sets(X, Y)

    activation_small_small = np.minimum(small_x, small_y)
    activation_medium_medium = np.minimum(medium_x, medium_y)
    activation_large_large = np.minimum(large_x, large_y)

    aggregated = np.maximum.reduce([
        activation_small_small * Z, 
        activation_medium_medium * Z, 
        activation_large_large * Z
    ])

    return X, Y, aggregated

def main():
    x = np.linspace(-np.pi, np.pi, 100)
    y = np.linspace(-np.pi, np.pi, 100)

    X, Y, Z = fuzzy_approximation(x, y)

    fig = plt.figure(figsize=(12, 6))

    ax1 = fig.add_subplot(121, projection='3d')
    Z_original = np.sin(X) + np.cos(Y)
    ax1.plot_surface(X, Y, Z_original, cmap='viridis')
    ax1.set_title('Original Function: sin(x) + cos(y)')
    ax1.set_xlabel('x')
    ax1.set_ylabel('y')
    ax1.set_zlabel('z')

    ax2 = fig.add_subplot(122, projection='3d')
    ax2.plot_surface(X, Y, Z, cmap='inferno')
    ax2.set_title('Fuzzy Approximation')
    ax2.set_xlabel('x')
    ax2.set_ylabel('y')
    ax2.set_zlabel('z')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()