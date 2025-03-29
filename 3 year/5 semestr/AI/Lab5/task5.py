import numpy as np
import matplotlib.pyplot as plt

def trapmf(x, params):
    a, b, c, d = params
    return np.maximum(0, np.minimum((x - a) / np.maximum(1e-10, b - a), np.minimum(1, (d - x) / np.maximum(1e-10, d - c))))

def gaussmf(x, params):
    c, sigma = params
    return np.exp(-0.5 * ((x - c) / sigma) ** 2)

def main():
    x = np.linspace(-np.pi, np.pi, 200)

    small_deviation = np.maximum(trapmf(x, [-np.pi, -np.pi, -np.pi/4, -np.pi/6]), trapmf(x, [np.pi/6, np.pi/4, np.pi, np.pi]))
    medium_deviation = gaussmf(x, [0, np.pi/8])
    large_deviation = np.maximum(trapmf(x, [-np.pi/2, -np.pi/3, -np.pi/4, -np.pi/6]), trapmf(x, [np.pi/6, np.pi/4, np.pi/3, np.pi/2]))

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
    plt.title('Aproksymacja funkcji sinus z innymi funkcjami przynależności')
    plt.legend(['sin(x)', 'Aproksymacja'], loc='upper right')

    plt.subplot(2, 1, 2)
    plt.plot(x, small_deviation, 'b', x, medium_deviation, 'g', x, large_deviation, 'r', linewidth=2)
    plt.title('Funkcje przynależności dla odchylenia')
    plt.legend(['Małe odchylenie', 'Średnie odchylenie', 'Duże odchylenie'], loc='upper right')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()