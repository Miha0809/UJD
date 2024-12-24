import tkinter as tk
from tkinter import messagebox
from skfuzzy import control as ctrl
import skfuzzy as fuzz
import numpy as np


class WashingMachine:
    degree_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "degree_dirt")
    type_dirt = ctrl.Antecedent(np.arange(0, 101, 1), "type_dirt")
    wash_time = ctrl.Consequent(np.arange(0, 61, 1), "wash_time")

    degree_names = ["Low", "Medium", "High"]
    type_names = ["NonFat", "Medium", "Fat"]

    degree_dirt.automf(names=degree_names)
    type_dirt.automf(names=type_names)

    wash_time["very_short"] = fuzz.trimf(wash_time.universe, [0, 8, 12])
    wash_time["short"] = fuzz.trimf(wash_time.universe, [8, 12, 20])
    wash_time["medium"] = fuzz.trimf(wash_time.universe, [12, 20, 40])
    wash_time["long"] = fuzz.trimf(wash_time.universe, [20, 40, 60])
    wash_time["very_long"] = fuzz.trimf(wash_time.universe, [40, 60, 60])

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
    return WashingMachine.washing.output["wash_time"]


def calculate_wash_time():
    try:
        type_of_dirt = float(entry_type_dirt.get())
        degree_of_dirt = float(entry_degree_dirt.get())

        if (
            type_of_dirt < 0
            or type_of_dirt > 100
            or degree_of_dirt < 0
            or degree_of_dirt > 100
        ):
            raise ValueError("Values must be between 0 and 100.")

        wash_time = fuzzify_laundry(type_of_dirt, degree_of_dirt)
        label_result.config(text=f"Recommended wash time: {wash_time:.2f} minutes")
    except ValueError as e:
        messagebox.showerror("Input Error", str(e))


root = tk.Tk()
root.title("Washing Machine Fuzzy Logic")
root.geometry("400x300")

tk.Label(root, text="Type of Dirt (0-100):").pack(pady=5)
entry_type_dirt = tk.Entry(root)
entry_type_dirt.pack(pady=5)

tk.Label(root, text="Degree of Dirt (0-100):").pack(pady=5)
entry_degree_dirt = tk.Entry(root)
entry_degree_dirt.pack(pady=5)

btn_calculate = tk.Button(root, text="Calculate Wash Time", command=calculate_wash_time)
btn_calculate.pack(pady=10)

label_result = tk.Label(root, text="", font=("Helvetica", 14))
label_result.pack(pady=20)

root.mainloop()
