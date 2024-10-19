package cjy;

import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
	Calculator() {
		setTitle("계산기");
        setSize(400, 600);
        setLayout(new BorderLayout());
        
		JTextField t1 = new JTextField("0");
		t1.setFont(new Font("Arial", Font.PLAIN, 30));
		t1.setHorizontalAlignment(JTextField.RIGHT);
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
		
		for (int i = 0; i < buttonLabels.length; i++) {
			JButton button = new JButton(buttonLabels[i]);
			p1.add(button);
		}

		add(p1, "Center");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
