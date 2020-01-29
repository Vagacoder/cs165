package example0;

/*
 * This class is an example for many java.awt components
 * 
 * 
 */

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;


public class GUIsamples extends Frame{
	
	/**
	 *
	 */
	private static final long serialVersionUID = -3182521474915448353L;
	
	// private Panel mainPanel;
	private Label label1;
	private Label label2;
	private TextField textInput1;
	private Choice dropdownMenu1;
	private Checkbox option1;
	private Checkbox option2;
	private CheckboxGroup options1;
	private Button button1;
	private Button button2;

	public GUIsamples () {

		Panel mainPanel = new Panel();
		// this.mainPanel.setSize(200,100);
		mainPanel.setBackground(new Color(0xffff00));
		this.add(mainPanel);
		
		this.label1 = new Label("This is label #1");
		// this.label1.setSize(200, 100);
		mainPanel.add(this.label1);

		this.label2 = new Label("That was label #2", Label.RIGHT);
		mainPanel.add(this.label2);

		this.button1 = new Button("Click Me to show label 1");
		this.button1.setEnabled(true);
		mainPanel.add(this.button1);
		this.button2 = new Button("I am disabled!");
		this.button2.setEnabled(false);
		mainPanel.add(this.button2);

		this.textInput1 = new TextField("Please enter words", 20);
		mainPanel.add(this.textInput1);

	}
	
	public void setLabel1(String text){
		this.label1.setText(text);
	}
	
	
	
	
	public static void main(String[] args) {
		GUIsamples window = new GUIsamples();
		window.setSize(800,600);
		
		window.setVisible(true);
		window.setLabel1("Hello World!");
	}

}
