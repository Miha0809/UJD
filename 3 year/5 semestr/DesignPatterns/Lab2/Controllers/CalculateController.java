public class SumaController {
  private double result = 0;

  public double calculate(String expression) {
    try {
      String[] numbers = expression.split(" ");
      number1 = Double.parseDouble(numbers[0]);
      operator = numbers[1].charAt(0);
      number2 = Double.parseDouble(numbers[2]);
    } catch (Exception ex) {
      throw ex;
    }

    if (operator == '+') {
      result = number1 + number2;
    } else if (operator == '-') {
      result = number1 - number2;
    } else if (operator == '*') {
      result = number1 * number2;
    } else if (operator == '/') {
      result = number1 / number2;
    }

    return result;
  }
}
