from skfuzzy import control as ctrl
import skfuzzy as fuzz
import numpy as np


class WashingMachine:
    degree_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "degree_dirt")
    type_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "type_dirt")
    wash_time = ctrl.Consequent(np.arange(0, 61, 1), "wash_time")

    degree_names = ["Low", "Medium", "High"]
    type_names = ["NonFat", "Medium", "Fat"]

    degree_dirt["Low"] = fuzz.trapmf(degree_dirt.universe, [0, 0, 20, 40])
    degree_dirt["Medium"] = fuzz.trapmf(degree_dirt.universe, [30, 40, 60, 70])
    degree_dirt["High"] = fuzz.trapmf(degree_dirt.universe, [60, 80, 100, 100])

    type_dirt["NonFat"] = fuzz.trapmf(type_dirt.universe, [0, 0, 20, 40])
    type_dirt["Medium"] = fuzz.trapmf(type_dirt.universe, [30, 50, 70, 80])
    type_dirt["Fat"] = fuzz.trapmf(type_dirt.universe, [70, 90, 100, 100])

    wash_time["very_short"] = fuzz.trapmf(wash_time.universe, [0, 0, 5, 10])
    wash_time["short"] = fuzz.trimf(wash_time.universe, [8, 12, 20])
    wash_time["medium"] = fuzz.trapmf(wash_time.universe, [15, 20, 35, 45])
    wash_time["long"] = fuzz.trimf(wash_time.universe, [30, 40, 60])
    wash_time["very_long"] = fuzz.trapmf(wash_time.universe, [50, 55, 60, 60])

    rule1 = ctrl.Rule(degree_dirt["High"] | type_dirt["Fat"], wash_time["very_long"])
    rule2 = ctrl.Rule(degree_dirt["Medium"] | type_dirt["Fat"], wash_time["long"])
    rule3 = ctrl.Rule(degree_dirt["Low"] | type_dirt["Fat"], wash_time["long"])
    rule4 = ctrl.Rule(degree_dirt["High"] | type_dirt["Medium"], wash_time["long"])
    rule5 = ctrl.Rule(degree_dirt["Medium"] | type_dirt["Medium"], wash_time["medium"])
    rule6 = ctrl.Rule(degree_dirt["Low"] | type_dirt["Medium"], wash_time["medium"])
    rule7 = ctrl.Rule(degree_dirt["High"] | type_dirt["NonFat"], wash_time["medium"])
    rule8 = ctrl.Rule(degree_dirt["Medium"] | type_dirt["NonFat"], wash_time["short"])
    rule9 = ctrl.Rule(degree_dirt["Low"] | type_dirt["NonFat"], wash_time["very_short"])

    washing_ctrl = ctrl.ControlSystem(
        [rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9]
    )
    washing = ctrl.ControlSystemSimulation(washing_ctrl)


def fuzzify_laundry(fuzz_type, fuzz_degree):
    WashingMachine.washing.input["type_dirt"] = fuzz_type
    WashingMachine.washing.input["degree_dirt"] = fuzz_degree

    WashingMachine.washing.compute()

    WashingMachine.wash_time.view(sim=WashingMachine.washing)

    return WashingMachine.washing.output["wash_time"]


def compute_washing_parameters(type_of_dirt, degree_of_dirt):
    if type_of_dirt < 0.0 or type_of_dirt > 100.0:
        raise Exception("Invalid Type of Dirtiness: %lf" % type_of_dirt)
    if degree_of_dirt < 0.0 or degree_of_dirt > 100.0:
        raise Exception("Invalid Degree of Dirtiness: %lf" % degree_of_dirt)

    wash_time = fuzzify_laundry(type_of_dirt, degree_of_dirt)

    return wash_time


type_of_dirt = float(input("Enter Type of Dirtiness [0-100]: "))
degree_of_dirt = float(input("Enter Degree of Dirtiness [0-100]: "))
washing_parameters = compute_washing_parameters(type_of_dirt, degree_of_dirt)
print(f"Recommended washing time: {washing_parameters:.2f} minutes")
