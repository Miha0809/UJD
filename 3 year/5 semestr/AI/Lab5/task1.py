import numpy as np
import matplotlib.pyplot as plt

def trimf(x, params):
    a, b, c = params
    return np.maximum(0, np.minimum((x - a) / np.maximum(1e-10, b - a), (c - x) / np.maximum(1e-10, c - b)))

def main():
    x = np.linspace(-np.pi, np.pi, 200)

    small_deviation = trimf(x, [-np.pi, -np.pi, -np.pi / 4])
    medium_small_deviation = trimf(x, [-np.pi / 4, -np.pi / 6, 0])
    medium_deviation = trimf(x, [-np.pi / 6, 0, np.pi / 6])
    medium_large_deviation = trimf(x, [0, np.pi / 6, np.pi / 4])
    large_deviation = trimf(x, [np.pi / 4, np.pi, np.pi])

    deviations = [small_deviation, medium_small_deviation, medium_deviation, medium_large_deviation, large_deviation]
    labels = ['Small', 'Medium Small', 'Medium', 'Medium Large', 'Large']

    approximated_sin = np.zeros_like(x)

    for i in range(len(x)):
        activations = [np.minimum(deviation[i], np.sin(x[i])) for deviation in deviations]
        aggregated = np.max(activations)

        if aggregated != 0:
            approximated_sin[i] = np.sum(x * aggregated) / np.sum(aggregated)
        else:
            approximated_sin[i] = 0

    plt.figure(figsize=(10, 6))

    plt.subplot(2, 1, 1)
    plt.plot(x, np.sin(x), 'b', x, approximated_sin, 'r', linewidth=2)
    plt.title('Aproksymacja funkcji sinus z różną liczbą reguł')
    plt.legend(['sin(x)', 'Aproksymacja'], loc='upper right')

    plt.subplot(2, 1, 2)
    for deviation, label in zip(deviations, labels):
        plt.plot(x, deviation, linewidth=2, label=label)
    plt.title('Zbiory rozmyte dla odchylenia')
    plt.legend(loc='upper right')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()