import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {
  private final int COUNT_BUTTONS = 17;

  private JButton[] buttons = new JButton[COUNT_BUTTONS];
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

  public Main() {
    InitDictionaryValues();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new GridLayout(6, 4));

    textField = new JTextField("");
    mainPanel.add("North", textField);

    addButtonsToPanel(buttonPanel, 6, 4);

    mainPanel.add("Center", buttonPanel);

    initialNumbers();
    initialSpecialSymbols();

    buttons[14].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (!textField.getText().equals("")) {
              textField.setText("");
            }
          }
        });

    buttons[15].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (!textField.getText().equals("")) {
              textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
          }
        });

    buttons[16].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              String[] numbers = textField.getText().split(" ");
              number1 = Double.parseDouble(numbers[0]);
              operator = numbers[1].charAt(0);
              number2 = Double.parseDouble(numbers[2]);
            } catch (Exception ex) {
              textField.setText("ERROR!");
              return;
            }

            if (operator == '+') {
              suma = number1 + number2;
            } else if (operator == '-') {
              suma = number1 - number2;
            } else if (operator == '*') {
              suma = number1 * number2;
            } else if (operator == '/') {
              suma = number1 / number2;
            }

            textField.setText(Double.toString(suma));
          }
        });

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

    for (int i = 0; i < COUNT_BUTTONS; i++) {
      buttons[i] = new JButton(values.get(i));
    }
  }

  private void initialNumbers() {
    for (int i = 0; i < 10; i++) {
      final int index = i;
      buttons[i].addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (textField.getText().length() == 0 && index == 0) {
                return;
              }

              textField.setText(textField.getText() + index);
            }
          });
    }
  }

  private void initialSpecialSymbols() {
    for (int i = 10; i <= 13; i++) {
      final int index = i;

      buttons[i].addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (textField.getText().indexOf(operator) == -1) {
                if (!textField.getText().equals("")) {
                  number1 = Double.parseDouble(textField.getText());
                }

                operator = values.get(index).charAt(0);
                textField.setText(textField.getText() + " " + values.get(index) + " ");
              }
            }
          });
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

  public static void main(String args[]) {
    new Main();
  }
}
