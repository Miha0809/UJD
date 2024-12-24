import numpy as np
import matplotlib.pyplot as plt

def trimf(x, params):
    a, b, c = params
    return np.maximum(0, np.minimum((x - a) / np.maximum(1e-10, b - a), (c - x) / np.maximum(1e-10, c - b)))

def main():
    x = np.linspace(-np.pi, np.pi, 200)

    small_deviation = np.maximum(trimf(x, [-np.pi, -np.pi/2, -np.pi/6]), trimf(x, [0, np.pi/6, np.pi/2]))
    medium_deviation = trimf(x, [-np.pi/4, 0, np.pi/4])
    large_deviation = np.maximum(trimf(x, [-np.pi/2, -np.pi/4, 0]), trimf(x, [np.pi/4, np.pi/2, np.pi]))

    approximated_sin = np.zeros_like(x)

    for i in range(len(x)):
        activation_small = np.minimum(small_deviation[i], np.sin(x[i]))
        activation_medium = np.minimum(medium_deviation[i], np.sin(x[i]))
        activation_large = np.minimum(large_deviation[i], np.sin(x[i]))

        aggregated = np.max([activation_small, activation_medium, activation_large])

        if aggregated != 0:
            approximated_sin[i] = np.sum(x * aggregated) / np.sum(aggregated)
        else:
            approximated_sin[i] = 0

    plt.subplot(2, 1, 1)
    plt.plot(x, np.sin(x), 'b', x, approximated_sin, 'r', linewidth=2)
    plt.title('Aproksymacja funkcji sinus (zmienione parametry)')
    plt.legend(['sin(x)', 'Aproksymacja'], loc='upper right')

    plt.subplot(2, 1, 2)
    plt.plot(x, small_deviation, 'b', x, medium_deviation, 'g', x, large_deviation, 'r', linewidth=2)
    plt.title('Zbiory rozmyte dla odchylenia (zmienione parametry)')
    plt.legend(['Małe odchylenie', 'Średnie odchylenie', 'Duże odchylenie'], loc='upper right')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()