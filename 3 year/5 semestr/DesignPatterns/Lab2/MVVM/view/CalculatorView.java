package view;

import java.util.*;
import javax.swing.*;
import java.awt.*;

import models.*;
import view_models.*;

public class CalculatorView extends JFrame {
    private final JTextField textField;
    private final JButton[] buttons;
    private final Map<Integer, String> values;

    public CalculatorView(CalculatorViewModel viewModel) {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
        add(buttonPanel, BorderLayout.CENTER);

        buttons = new JButton[17];
        values = initValues();

        for (int i = 0; i < 17; i++) {
            buttons[i] = new JButton(values.get(i));
            buttonPanel.add(buttons[i]);
        }

        for (int i = 0; i < 10; i++) {
            final int index = i;
            buttons[i].addActionListener(e -> {
                viewModel.appendInput(String.valueOf(index));
                textField.setText(viewModel.getInput());
            });
        }

        for (int i = 10; i <= 13; i++) {
            final int index = i;
            buttons[i].addActionListener(e -> {
                if (!viewModel.getInput().contains(" ")) {
                    viewModel.appendInput(" " + values.get(index) + " ");
                    textField.setText(viewModel.getInput());
                }
            });
        }

        buttons[14].addActionListener(e -> {
            viewModel.clearInput();
            textField.setText("");
        });

        buttons[15].addActionListener(e -> {
            viewModel.deleteLast();
            textField.setText(viewModel.getInput());
        });

        buttons[16].addActionListener(e -> {
            String result = viewModel.calculate();
            textField.setText(result);
        });

        pack();
        setVisible(true);
    }

    private Map<Integer, String> initValues() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, Integer.toString(i));
        }
        map.put(10, "*");
        map.put(11, "/");
        map.put(12, "-");
        map.put(13, "+");
        map.put(14, "C");
        map.put(15, "<-");
        map.put(16, "=");
        return map;
    }

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorViewModel viewModel = new CalculatorViewModel(model);
        new CalculatorView(viewModel);
    }
}
