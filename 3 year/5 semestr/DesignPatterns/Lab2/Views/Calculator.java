import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;

public class Calculator {
  private final int COUNT_BUTTONS = 17;

  private Button[] buttons = new JButton[COUNT_BUTTONS];
  private JTextField textField;

  private Map<Integer, String> values = new HashMap<Integer, String>();

  private double number1;
  private char operator;
  private double number2;
  private double suma;

  private int[] obj =
      new int[] {
        -1, -1, -1, 14, 7, 8, 9, 12, 4, 5, 6, 13, 1, 2, 3, 10, -1, 0, -1, 11, 15, -1, -1, 16
      };

  public static void main(String[] args) {}
}
