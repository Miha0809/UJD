package view_models;

import models.CalculatorModel;

public class CalculatorViewModel {
    private final CalculatorModel model;
    private StringBuilder input;

    public CalculatorViewModel(CalculatorModel model) {
        this.model = model;
        this.input = new StringBuilder();
    }

    public String getInput() {
        return input.toString();
    }

    public void appendInput(String value) {
        input.append(value);
    }

    public void clearInput() {
        input.setLength(0);
    }

    public void deleteLast() {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
    }

    public String calculate() {
        try {
            String[] parts = input.toString().split(" ");
            if (parts.length != 3) {
                return "ERROR!";
            }

            double number1 = Double.parseDouble(parts[0]);
            char operator = parts[1].charAt(0);
            double number2 = Double.parseDouble(parts[2]);

            model.setNumber1(number1);
            model.setNumber2(number2);
            model.setOperator(operator);
            model.calculate();

            clearInput();
            return String.valueOf(model.getResult());
        } catch (Exception e) {
            return "ERROR!";
        }
    }
}