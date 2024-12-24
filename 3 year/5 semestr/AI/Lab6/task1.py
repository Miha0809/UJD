import matplotlib.pyplot as plt
from skfuzzy import control as ctrl
import skfuzzy as fuzz
import numpy as np


class WashingMachine:
    degree_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "degree_dirt")
    type_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "type_dirt")
    wash_time = ctrl.Consequent(np.arange(0, 61, 1), "wash_time")

    @staticmethod
    def set_membership_functions(degree_params, time_params):
        WashingMachine.degree_dirt["Low"] = fuzz.trimf(
            WashingMachine.degree_dirt.universe, degree_params["Low"]
        )
        WashingMachine.degree_dirt["Medium"] = fuzz.trimf(
            WashingMachine.degree_dirt.universe, degree_params["Medium"]
        )
        WashingMachine.degree_dirt["High"] = fuzz.trimf(
            WashingMachine.degree_dirt.universe, degree_params["High"]
        )

        WashingMachine.wash_time["very_short"] = fuzz.trimf(
            WashingMachine.wash_time.universe, time_params["very_short"]
        )
        WashingMachine.wash_time["short"] = fuzz.trimf(
            WashingMachine.wash_time.universe, time_params["short"]
        )
        WashingMachine.wash_time["medium"] = fuzz.trimf(
            WashingMachine.wash_time.universe, time_params["medium"]
        )
        WashingMachine.wash_time["long"] = fuzz.trimf(
            WashingMachine.wash_time.universe, time_params["long"]
        )
        WashingMachine.wash_time["very_long"] = fuzz.trimf(
            WashingMachine.wash_time.universe, time_params["very_long"]
        )

    rules = [
        ctrl.Rule(degree_dirt["High"] | type_dirt["Fat"], wash_time["very_long"]),
        ctrl.Rule(degree_dirt["Medium"] | type_dirt["Fat"], wash_time["long"]),
        ctrl.Rule(degree_dirt["Low"] | type_dirt["Fat"], wash_time["long"]),
        ctrl.Rule(degree_dirt["High"] | type_dirt["Medium"], wash_time["long"]),
        ctrl.Rule(degree_dirt["Medium"] | type_dirt["Medium"], wash_time["medium"]),
        ctrl.Rule(degree_dirt["Low"] | type_dirt["Medium"], wash_time["medium"]),
        ctrl.Rule(degree_dirt["High"] | type_dirt["NonFat"], wash_time["medium"]),
        ctrl.Rule(degree_dirt["Medium"] | type_dirt["NonFat"], wash_time["short"]),
        ctrl.Rule(degree_dirt["Low"] | type_dirt["NonFat"], wash_time["very_short"]),
    ]

    @staticmethod
    def create_control_system():
        return ctrl.ControlSystemSimulation(ctrl.ControlSystem(WashingMachine.rules))


def experiment_with_membership_functions(
    degree_params, time_params, type_of_dirt, degree_of_dirt
):
    WashingMachine.set_membership_functions(degree_params, time_params)
    control_sim = WashingMachine.create_control_system()

    control_sim.input["type_dirt"] = type_of_dirt
    control_sim.input["degree_dirt"] = degree_of_dirt

    control_sim.compute()
    result = control_sim.output["wash_time"]

    WashingMachine.wash_time.view(sim=control_sim)
    plt.show()

    return result


degree_params = {
    "Low": [0, 0, 40],
    "Medium": [20, 50, 80],
    "High": [60, 100, 100],
}
time_params = {
    "very_short": [0, 8, 12],
    "short": [8, 12, 20],
    "medium": [12, 20, 40],
    "long": [20, 40, 60],
    "very_long": [40, 60, 60],
}

type_of_dirt = float(input("Enter Type of Dirtiness [0-100]: "))
degree_of_dirt = float(input("Enter Degree of Dirtiness [0-100]: "))

recommended_time = experiment_with_membership_functions(
    degree_params, time_params, type_of_dirt, degree_of_dirt
)
print(f"Recommended washing time: {recommended_time:.2f} minutes")
