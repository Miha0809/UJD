import numpy as np
import matplotlib.pyplot as plt

def trimf(x, params):
    a, b, c = params
    return np.maximum(0, np.minimum((x - a) / np.maximum(1e-10, b - a), (c - x) / np.maximum(1e-10, c - b)))

def main():
    x = np.linspace(-np.pi, np.pi, 200)

    small_deviation = np.maximum(trimf(x, [-np.pi, -np.pi, -np.pi/6]), trimf(x, [0, np.pi/6, np.pi]))
    medium_deviation = trimf(x, [-np.pi/6, 0, np.pi/6])
    large_deviation = np.maximum(trimf(x, [-np.pi/3, -np.pi/6, 0]), trimf(x, [np.pi/6, np.pi/3, np.pi/2]))

    sin_x = np.sin(x)
    activation_small = np.minimum(small_deviation, sin_x)
    activation_medium = np.minimum(medium_deviation, sin_x)
    activation_large = np.minimum(large_deviation, sin_x)
    aggregated = np.maximum.reduce([activation_small, activation_medium, activation_large])

    approximated_sin = np.where(
        aggregated != 0,
        np.sum(x * aggregated) / np.sum(aggregated),
        0
    )

    plt.subplot(2, 1, 1)
    plt.plot(x, np.sin(x), 'b', x, approximated_sin, 'r', linewidth=2)
    plt.title('Aproksymacja funkcji sinus')
    plt.legend(['sin(x)', 'Aproksymacja'], loc='upper right')

    plt.subplot(2, 1, 2)
    plt.plot(x, small_deviation, 'b', x, medium_deviation, 'g', x, large_deviation, 'r', linewidth=2)
    plt.title('Zbiory rozmyte dla odchylenia')
    plt.legend(['Małe odchylenie', 'Średnie odchylenie', 'Duże odchylenie'], loc='upper right')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()