import numpy as np
import matplotlib.pyplot as plt

class RoomLightingController:
    def __init__(self):
        pass

    def evaluate(self, natural_light_level, time_of_day):
        if time_of_day < 6 or time_of_day > 20:  # Nighttime
            artificial_light = max(0, 100 - natural_light_level)
        elif 6 <= time_of_day <= 18:  # Daytime
            artificial_light = max(0, 50 - 0.5 * natural_light_level)
        else:  # Evening or early morning
            artificial_light = max(0, 75 - 0.75 * natural_light_level)

        return artificial_light

    def plot_membership_functions(self):
        natural_light_range = np.linspace(0, 100, 100)
        time_of_day_range = np.linspace(0, 23, 100)
        membership_dim = np.maximum(0, 1 - natural_light_range / 50)
        membership_bright = np.maximum(0, (natural_light_range - 50) / 50)
        membership_night = np.maximum(0, 1 - np.abs(time_of_day_range - 23) / 3)
        membership_day = np.maximum(0, 1 - np.abs(time_of_day_range - 12) / 6)
        membership_evening = np.maximum(0, 1 - np.abs(time_of_day_range - 18) / 3)

        plt.figure(figsize=(15, 5))
        plt.subplot(1, 2, 1)
        plt.plot(natural_light_range, membership_dim, label='Dim')
        plt.plot(natural_light_range, membership_bright, label='Bright')
        plt.title('Membership Function - Natural Light')
        plt.xlabel('Natural Light Intensity')
        plt.ylabel('Membership')
        plt.legend()
        plt.subplot(1, 2, 2)
        plt.plot(time_of_day_range, membership_night, label='Night')
        plt.plot(time_of_day_range, membership_day, label='Day')
        plt.plot(time_of_day_range, membership_evening, label='Evening')
        plt.title('Membership Function - Time of Day')
        plt.xlabel('Time of Day (hours)')
        plt.ylabel('Membership')
        plt.legend()
        plt.tight_layout()
        plt.show()

if __name__ == "__main__":
    lighting_controller = RoomLightingController()
    lighting_controller.plot_membership_functions()
    natural_light_input = 30  # Natural light intensity (0 to 100)
    time_of_day_input = 21   # Hour of the day (0 to 23)
    artificial_light = lighting_controller.evaluate(natural_light_input, time_of_day_input)

    print(f"Natural Light Intensity: {natural_light_input}")
    print(f"Time of Day: {time_of_day_input}:00")
    print(f"Artificial Lighting Brightness: {artificial_light:.2f}")
