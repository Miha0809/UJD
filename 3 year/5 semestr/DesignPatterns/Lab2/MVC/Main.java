import controllers.*;
import models.*;
import views.*;

public class Main {
  public static void main(String[] args) {
    Button model = new Button();
    CalculatorView view = new CalculatorView();
    new CalculateController(view, model);
  }
}
