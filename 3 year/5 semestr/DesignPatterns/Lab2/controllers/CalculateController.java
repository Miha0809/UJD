package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Button;
import views.CalculatorView;

public class CalculateController {
  private final CalculatorView view;
  private final Button model;

  public CalculateController(CalculatorView view, Button model) {
    this.view = view;
    this.model = model;

    addListeners();
  }

  private void addListeners() {
    view.getButtons()[14].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            view.setTextFieldText("");
          }
        });

    view.getButtons()[15].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String text = view.getTextFieldText();
            if (text.length() > 0) {
              view.setTextFieldText(text.substring(0, text.length() - 1));
            }
          }
        });

    view.getButtons()[16].addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              String[] numbers = view.getTextFieldText().split(" ");
              model.setNumber1(Double.parseDouble(numbers[0]));
              model.setOperator(numbers[1].charAt(0));
              model.setNumber2(Double.parseDouble(numbers[2]));
              model.calculate();
              view.setTextFieldText(Double.toString(model.getResult()));
            } catch (Exception ex) {
              view.setTextFieldText("ERROR!");
            }
          }
        });

    for (int i = 0; i <= 9; i++) {
      final int index = i;
      view.getButtons()[i].addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              view.setTextFieldText(view.getTextFieldText() + index);
            }
          });
    }

    for (int i = 10; i <= 13; i++) {
      final int index = i;
      view.getButtons()[i].addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (view.getTextFieldText().indexOf(model.getOperator()) == -1) {
                if (!view.getTextFieldText().equals("")) {
                  model.setNumber1(Double.parseDouble(view.getTextFieldText()));
                }
                model.setOperator(view.getButtons()[index].getText().charAt(0));
                view.setTextFieldText(
                    view.getTextFieldText() + " " + view.getButtons()[index].getText() + " ");
              }
            }
          });
    }
  }
}
