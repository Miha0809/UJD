package models;

public class Button {
  private double number1;
  private double number2;
  private char operator;
  private double result;

  public void setNumber1(double number1) {
    this.number1 = number1;
  }

  public void setNumber2(double number2) {
    this.number2 = number2;
  }

  public void setOperator(char operator) {
    this.operator = operator;
  }

  public void calculate() {
    switch (operator) {
      case '+':
        result = number1 + number2;
        break;
      case '-':
        result = number1 - number2;
        break;
      case '*':
        result = number1 * number2;
        break;
      case '/':
        if (number2 != 0) {
          result = number1 / number2;
        } else {
          result = Double.NaN; // Error for division by zero
        }
        break;
      default:
        result = Double.NaN;
    }
  }

  public double getResult() {
    return result;
  }

  public char getOperator() {
    return operator;
  }
}
