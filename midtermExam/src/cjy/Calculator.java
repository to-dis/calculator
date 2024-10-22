package cjy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 간단한 윈도우 계산기입니다.
 * 
 * @author Choi Jong Yun 
 * @version 1.1
 * @since 1.0
 * 
 * @created 2024-10-19
 * @lastModified 2024-10-22
 * 
 * @changelog
 * <ul>
 *   <li>2024-10-19: 최초 생성</li>
 *   <li>2024-10-20: 계산기 외형 변경</li>
 *   <li>2024-10-22: 계산기 기능 추가</li>
 * </ul>
 */

public class Calculator extends JFrame {
    JTextField t1;
    double num1 = 0, num2 = 0;
    String opr = "";
    boolean startNewNumber = true; //@see chatGPT

    Calculator() {
        setTitle("계산기");
        setSize(300, 500);
        setLayout(new BorderLayout());

        t1 = new JTextField("0");
        t1.setFont(new Font("Arial", Font.PLAIN, 30)); // 결과 창 폰트 변경 @see chatGPT
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t1.setPreferredSize(new Dimension(300, 100)); // 결과 창 크기 조정 @see chatGPT
        t1.setEnabled(false);
        add(t1, "North");

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttonLabels = {
            "%", "CE", "C", "←",
            "1/x", "x²", "²√x", "+",
            "7", "8", "9", "-",
            "4", "5", "6", "*",
            "1", "2", "3", "/",
            "+/-", "0", ".", "="
        };

        ActionListener buttonListener = e -> {
            String command = e.getActionCommand(); 

            if (command.matches("[0-9]")) {  
                if (startNewNumber || t1.getText().equals("0")) {
                    t1.setText(command);
                    startNewNumber = false;
                } else {
                    t1.setText(t1.getText() + command);
                }
            } else {
                switch (command) {             //@see chatGPT
                    case "C":
                        num1 = 0;
                        num2 = 0;
                        opr = "";
                        t1.setText("0");
                        startNewNumber = true;
                        break;
                    case "=":
                        num2 = Double.parseDouble(t1.getText());
                        calculateResult();
                        opr = "";
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        num1 = Double.parseDouble(t1.getText());
                        opr = command;
                        startNewNumber = true;
                        break;
                    case ".":
                        if (!t1.getText().contains(".")) {
                            t1.setText(t1.getText() + ".");
                        }
                        break;
                }
            }
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonListener);
            p1.add(button);
        }

        add(p1, "Center");

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void calculateResult() {
        double result = 0;
        switch (opr) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        t1.setText(String.valueOf(result));
        startNewNumber = true;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}