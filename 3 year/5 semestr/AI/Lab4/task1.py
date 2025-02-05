import numpy as np
import matplotlib.pyplot as plt

class CarClimateController:
    def __init__(self):
        pass

    def evaluate(self, external_temp, internal_temp):
        temp_difference = internal_temp - external_temp
        ventilation_strength = max(0.5, min(1.0, 1 - abs(temp_difference) / 10))
        temperature_setting = max(18, min(30, internal_temp - 0.5 * temp_difference))

        return ventilation_strength, temperature_setting

    def plot_membership_functions(self):
        external_temp_range = np.linspace(-10, 40, 100)
        internal_temp_range = np.linspace(15, 30, 100)

        membership_cold = np.maximum(0, 1 - (external_temp_range + 10) / 20)
        membership_hot = np.maximum(0, (external_temp_range - 20) / 20)
        membership_comfortable = np.maximum(0, 1 - np.abs(internal_temp_range - 22.5) / 7.5)

        plt.figure(figsize=(15, 5))
        plt.subplot(1, 3, 1)
        plt.plot(external_temp_range, membership_cold, label='Cold')
        plt.plot(external_temp_range, membership_hot, label='Hot')
        plt.title('Membership Function - External Temperature')
        plt.xlabel('External Temperature (°C)')
        plt.ylabel('Membership')
        plt.legend()
        plt.subplot(1, 3, 2)
        plt.plot(internal_temp_range, membership_comfortable, label='Comfortable')
        plt.title('Membership Function - Internal Temperature')
        plt.xlabel('Internal Temperature (°C)')
        plt.ylabel('Membership')
        plt.legend()

        plt.tight_layout()
        plt.show()

if __name__ == "__main__":
    climate_controller = CarClimateController()
    climate_controller.plot_membership_functions()
    external_temp_input = 35
    internal_temp_input = 28
    ventilation_strength, temperature_setting = climate_controller.evaluate(external_temp_input, internal_temp_input)

    print(f"External Temperature: {external_temp_input}°C")
    print(f"Internal Temperature: {internal_temp_input}°C")
    print(f"Ventilation Strength: {ventilation_strength:.2f}")
    print(f"Temperature Setting: {temperature_setting:.2f}°C")
