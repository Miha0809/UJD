package views;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class CalculatorView extends JFrame {
  private final JButton[] buttons = new JButton[17];
  private final JTextField textField;
  private final Map<Integer, String> values;
  private final int[] obj;

  public CalculatorView() {
    values = new HashMap<>();
    obj =
        new int[] {
          -1, -1, -1, 14, 7, 8, 9, 12, 4, 5, 6, 13, 1, 2, 3, 10, -1, 0, -1, 11, 15, -1, -1, 16
        };
    InitDictionaryValues();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new GridLayout(6, 4));

    textField = new JTextField("");
    mainPanel.add("North", textField);

    addButtonsToPanel(buttonPanel, 6, 4);

    mainPanel.add("Center", buttonPanel);
    setContentPane(mainPanel);
    pack();
    setVisible(true);
  }

  private void InitDictionaryValues() {
    for (int i = 0; i < 10; i++) {
      values.put(i, Integer.toString(i));
    }
    values.put(10, "*");
    values.put(11, "/");
    values.put(12, "-");
    values.put(13, "+");
    values.put(14, "C");
    values.put(15, "<-");
    values.put(16, "=");
    for (int i = 0; i < 17; i++) {
      buttons[i] = new JButton(values.get(i));
    }
  }

  private void addButtonsToPanel(JPanel buttonPanel, int a, int b) {
    for (int i = 0; i < 6 * 4; i++) {
      if (obj[i] == -1) {
        buttonPanel.add(new JLabel());
        continue;
      }
      buttonPanel.add(buttons[obj[i]]);
    }
  }

  public void setTextFieldText(String text) {
    textField.setText(text);
  }

  public String getTextFieldText() {
    return textField.getText();
  }

  public JButton[] getButtons() {
    return buttons;
  }
}
