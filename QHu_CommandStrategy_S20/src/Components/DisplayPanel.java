package Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DisplayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
    private JLabel resultLabel;

    public DisplayPanel(){
		this.resultLabel = new JLabel("0");
		resultLabel.setBorder(new EmptyBorder(3, 8, 0, 40));
		resultLabel.setBackground(new Color(51, 51, 51));
		resultLabel.setOpaque(true);
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		resultLabel.setForeground(new Color(255, 255, 255));
		resultLabel.setFont(new Font("Arial", Font.PLAIN, 72));
        resultLabel.setBounds(0, 0, 443, 96);
        this.setLayout(null);
        this.setSize(443, 96);
        this.add(resultLabel);
    }

    public void UpdateResultLabel(String content){
        this.resultLabel.setText(content);
    }


}