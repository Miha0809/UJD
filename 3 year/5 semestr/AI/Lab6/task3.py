from skfuzzy import control as ctrl
import skfuzzy as fuzz
import numpy as np
import matplotlib.pyplot as plt

class washing_machine:
    degree_dirt = ctrl.Antecedent(np.arange(0, 101, 1), 'degree_dirt')
    type_dirt = ctrl.Antecedent(np.arange(0, 101, 1), 'type_dirt')
    wash_time = ctrl.Consequent(np.arange(0, 61, 1), 'wash_time')

    degree_names = ['Low', 'Medium', 'High']
    type_names = ['NonFat', 'Medium', 'Fat']

    degree_dirt.automf(names=degree_names)
    type_dirt.automf(names=type_names)

    wash_time['very_short'] = fuzz.trapmf(wash_time.universe, [0, 0, 8, 12])
    wash_time['short'] = fuzz.trapmf(wash_time.universe, [8, 12, 15, 20])
    wash_time['medium'] = fuzz.trapmf(wash_time.universe, [12, 20, 30, 40])
    wash_time['long'] = fuzz.trapmf(wash_time.universe, [20, 40, 50, 60])
    wash_time['VeryLong'] = fuzz.trapmf(wash_time.universe, [40, 50, 60, 60])

    rule1 = ctrl.Rule(degree_dirt['High'] | type_dirt['Fat'], wash_time['VeryLong'])
    rule2 = ctrl.Rule(degree_dirt['Medium'] | type_dirt['Fat'], wash_time['long'])
    rule3 = ctrl.Rule(degree_dirt['Low'] | type_dirt['Fat'], wash_time['long'])
    rule4 = ctrl.Rule(degree_dirt['High'] | type_dirt['Medium'], wash_time['long'])
    rule5 = ctrl.Rule(degree_dirt['Medium'] | type_dirt['Medium'], wash_time['medium'])
    rule6 = ctrl.Rule(degree_dirt['Low'] | type_dirt['Medium'], wash_time['medium'])
    rule7 = ctrl.Rule(degree_dirt['High'] | type_dirt['NonFat'], wash_time['medium'])
    rule8 = ctrl.Rule(degree_dirt['Medium'] | type_dirt['NonFat'], wash_time['short'])
    rule9 = ctrl.Rule(degree_dirt['Low'] | type_dirt['NonFat'], wash_time['very_short'])

    washing_ctrl = ctrl.ControlSystem([rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9])
    washing = ctrl.ControlSystemSimulation(washing_ctrl)

def fuzzify_laundry(fuzz_type, fuzz_degree):
    washing_machine.washing.input['type_dirt'] = fuzz_type
    washing_machine.washing.input['degree_dirt'] = fuzz_degree

    washing_machine.washing.compute()

    washing_machine.wash_time.view(sim=washing_machine.washing)
    plt.show()

    return washing_machine.washing.output['wash_time']

def compute_washing_parameters(type_of_dirt, degree_of_dirt):
    if type_of_dirt < 0.0 or type_of_dirt > 100.0:
        raise Exception(f"Invalid Type of Dirtiness: {type_of_dirt}")
    if degree_of_dirt < 0.0 or degree_of_dirt > 100.0:
        raise Exception(f"Invalid Degree of Dirtiness: {degree_of_dirt}")

    type_fuzzy = fuzzify_laundry(type_of_dirt, degree_of_dirt)
    return type_fuzzy

type_of_dirt = float(input("Enter Type of Dirtiness [0-100]: "))
degree_of_dirt = float(input("Enter Degree of Dirtiness [0-100]: "))

washing_parameters = compute_washing_parameters(type_of_dirt, degree_of_dirt)

print(f"Recommended washing time: {washing_parameters} minutes")
