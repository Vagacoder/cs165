package Components;

import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Commands.*;

public class ButtonPanel extends JPanel {

  private static final long serialVersionUID = -8624240534510302094L;

  private Processor processor;
  private JPanel basicPanel;
  private JPanel advancePanel;

  private JButton clearButton;
  private JButton btnUndo;
  private JButton plusMinusButton;
  private JButton divideButton;
  private JButton sevenButton;
  private JButton eightButton;
  private JButton nineButton;
  private JButton multiplyButton;
  private JButton fourButton;
  private JButton fiveButton;
  private JButton sixButton;
  private JButton subtractButton;
  private JButton oneButton;
  private JButton twoButton;
  private JButton threeButton;
  private JButton plusButton;
  private JButton zeroButton;
  private JButton equalsButton;
  private JButton periodButton;

  public ButtonPanel(DisplayPanel displayPanel) {

    this.processor = new Processor(displayPanel);

    // * main panel for all buttons
    this.setLayout(null);
    this.setSize(450, 765);
    this.setBackground(new Color(255, 255, 255));
    this.setFont(new Font("Arial", Font.PLAIN, 18));

    // ** top panel for advanced function buttons
    this.advancePanel = new JPanel();
    advancePanel.setLayout(null);
    advancePanel.setSize(450, 150);
    advancePanel.setBounds(0, 0, 450, 150);
    advancePanel.setBackground(new Color(0xf0, 0xf0, 0xf0));
    advancePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Advance Functions"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    ;
    this.add(this.advancePanel);

    // ** bottom panel for basic function buttons
    this.basicPanel = new JPanel();
    basicPanel.setLayout(null);
    basicPanel.setSize(450, 600);
    basicPanel.setBounds(0, 150, 450, 565);
    basicPanel.setBackground(new Color(0xf0, 0xf0, 0xf0));
    basicPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Basic Functions"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    this.add(this.basicPanel);

    // ** Buttons
    clearButton = new JButton("ac");
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_clearButton_actionPerformed(e);
      }
    });
    clearButton.setBorderPainted(false);
    clearButton.setOpaque(true);
    clearButton.setForeground(new Color(51, 51, 51));
    clearButton.setFont(new Font("Arial", Font.PLAIN, 26));
    clearButton.setFocusable(false);
    clearButton.setDoubleBuffered(true);
    clearButton.setBackground(new Color(255, 255, 255));
    clearButton.setBounds(15, 22, 96, 96);
    basicPanel.add(clearButton);

    btnUndo = new JButton("undo");
    btnUndo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_btnUndo_actionPerformed(e);
      }
    });
    btnUndo.setBorderPainted(false);
    btnUndo.setOpaque(true);
    btnUndo.setForeground(new Color(51, 51, 51));
    btnUndo.setFont(new Font("Arial", Font.PLAIN, 26));
    btnUndo.setFocusable(false);
    btnUndo.setDoubleBuffered(true);
    btnUndo.setBackground(new Color(255, 255, 255));
    btnUndo.setBounds(123, 22, 96, 96);
    basicPanel.add(btnUndo);

    plusMinusButton = new JButton("\u00b1");
    plusMinusButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_plusMinusButton_actionPerformed(e);
      }
    });
    plusMinusButton.setBorderPainted(false);
    plusMinusButton.setOpaque(true);
    plusMinusButton.setForeground(new Color(51, 51, 51));
    plusMinusButton.setFont(new Font("Arial", Font.PLAIN, 48));
    plusMinusButton.setFocusable(false);
    plusMinusButton.setDoubleBuffered(true);
    plusMinusButton.setBackground(new Color(255, 255, 255));
    plusMinusButton.setBounds(231, 22, 96, 96);
    basicPanel.add(plusMinusButton);

    divideButton = new JButton("\u00f7");
    divideButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_divideButton_actionPerformed(e);
      }
    });
    divideButton.setBorderPainted(false);
    divideButton.setOpaque(true);
    divideButton.setForeground(new Color(51, 51, 51));
    divideButton.setFont(new Font("Arial", Font.PLAIN, 48));
    divideButton.setFocusable(false);
    divideButton.setDoubleBuffered(true);
    divideButton.setBackground(new Color(255, 204, 0));
    divideButton.setBounds(339, 22, 96, 96);
    basicPanel.add(divideButton);

    sevenButton = new JButton("7");
    sevenButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_sevenButton_actionPerformed(e);
      }
    });
    sevenButton.setBorderPainted(false);
    sevenButton.setOpaque(true);
    sevenButton.setForeground(new Color(51, 51, 51));
    sevenButton.setFont(new Font("Arial", Font.PLAIN, 48));
    sevenButton.setFocusable(false);
    sevenButton.setDoubleBuffered(true);
    sevenButton.setBackground(Color.WHITE);
    sevenButton.setBounds(15, 130, 96, 96);
    basicPanel.add(sevenButton);

    eightButton = new JButton("8");
    eightButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_eightButton_actionPerformed(e);
      }
    });
    eightButton.setBorderPainted(false);
    eightButton.setOpaque(true);
    eightButton.setForeground(new Color(51, 51, 51));
    eightButton.setFont(new Font("Arial", Font.PLAIN, 48));
    eightButton.setFocusable(false);
    eightButton.setDoubleBuffered(true);
    eightButton.setBackground(Color.WHITE);
    eightButton.setBounds(123, 130, 96, 96);
    basicPanel.add(eightButton);

    nineButton = new JButton("9");
    nineButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_nineButton_actionPerformed(e);
      }
    });
    nineButton.setBorderPainted(false);
    nineButton.setOpaque(true);
    nineButton.setForeground(new Color(51, 51, 51));
    nineButton.setFont(new Font("Arial", Font.PLAIN, 48));
    nineButton.setFocusable(false);
    nineButton.setDoubleBuffered(true);
    nineButton.setBackground(Color.WHITE);
    nineButton.setBounds(231, 130, 96, 96);
    basicPanel.add(nineButton);

    this.multiplyButton = new JButton("x");
    multiplyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_multiplyButton_actionPerformed(e);
      }
    });
    multiplyButton.setBorderPainted(false);
    multiplyButton.setOpaque(true);
    multiplyButton.setForeground(new Color(51, 51, 51));
    multiplyButton.setFont(new Font("Arial", Font.PLAIN, 48));
    multiplyButton.setFocusable(false);
    multiplyButton.setDoubleBuffered(true);
    multiplyButton.setBackground(new Color(255, 204, 0));
    multiplyButton.setBounds(339, 130, 96, 96);
    basicPanel.add(multiplyButton);

    fourButton = new JButton("4");
    fourButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_fourButton_actionPerformed(e);
      }
    });
    fourButton.setBorderPainted(false);
    fourButton.setOpaque(true);
    fourButton.setForeground(new Color(51, 51, 51));
    fourButton.setFont(new Font("Arial", Font.PLAIN, 48));
    fourButton.setFocusable(false);
    fourButton.setDoubleBuffered(true);
    fourButton.setBackground(Color.WHITE);
    fourButton.setBounds(15, 238, 96, 96);
    basicPanel.add(fourButton);

    fiveButton = new JButton("5");
    fiveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_fiveButton_actionPerformed(e);
      }
    });
    fiveButton.setBorderPainted(false);
    fiveButton.setOpaque(true);
    fiveButton.setForeground(new Color(51, 51, 51));
    fiveButton.setFont(new Font("Arial", Font.PLAIN, 48));
    fiveButton.setFocusable(false);
    fiveButton.setDoubleBuffered(true);
    fiveButton.setBackground(Color.WHITE);
    fiveButton.setBounds(123, 238, 96, 96);
    basicPanel.add(fiveButton);

    sixButton = new JButton("6");
    sixButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_sixButton_actionPerformed(e);
      }
    });
    sixButton.setBorderPainted(false);
    sixButton.setOpaque(true);
    sixButton.setForeground(new Color(51, 51, 51));
    sixButton.setFont(new Font("Arial", Font.PLAIN, 48));
    sixButton.setFocusable(false);
    sixButton.setDoubleBuffered(true);
    sixButton.setBackground(Color.WHITE);
    sixButton.setBounds(231, 238, 96, 96);
    basicPanel.add(sixButton);

    subtractButton = new JButton("-");
    subtractButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_subtractButton_actionPerformed(e);
      }
    });
    subtractButton.setOpaque(true);
    subtractButton.setForeground(UIManager.getColor("Button.foreground"));
    subtractButton.setFont(new Font("Arial", Font.PLAIN, 48));
    subtractButton.setFocusable(false);
    subtractButton.setDoubleBuffered(true);
    subtractButton.setBorderPainted(false);
    subtractButton.setBackground(new Color(255, 204, 0));
    subtractButton.setBounds(339, 238, 96, 96);
    basicPanel.add(subtractButton);

    this.oneButton = new JButton("1");
    oneButton.setBorderPainted(false);
    oneButton.setOpaque(true);
    oneButton.setFocusable(false);
    oneButton.setDoubleBuffered(true);
    oneButton.setFont(new Font("Arial", Font.PLAIN, 48));
    oneButton.setForeground(new Color(51, 51, 51));
    oneButton.setBackground(new Color(255, 255, 255));
    oneButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        do_oneButton_actionPerformed(e);
      }

    });
    oneButton.setBounds(15, 346, 96, 96);
    basicPanel.add(oneButton);

    twoButton = new JButton("2");
    twoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_twoButton_actionPerformed(e);
      }
    });
    twoButton.setBorderPainted(false);
    twoButton.setOpaque(true);
    twoButton.setForeground(new Color(51, 51, 51));
    twoButton.setFont(new Font("Arial", Font.PLAIN, 48));
    twoButton.setFocusable(false);
    twoButton.setDoubleBuffered(true);
    twoButton.setBackground(Color.WHITE);
    twoButton.setBounds(123, 346, 96, 96);
    basicPanel.add(twoButton);

    this.threeButton = new JButton("3");
    threeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_threeButton_actionPerformed(e);
      }
    });
    threeButton.setBorderPainted(false);
    threeButton.setOpaque(true);
    threeButton.setForeground(new Color(51, 51, 51));
    threeButton.setFont(new Font("Arial", Font.PLAIN, 48));
    threeButton.setFocusable(false);
    threeButton.setDoubleBuffered(true);
    threeButton.setBackground(Color.WHITE);
    threeButton.setBounds(231, 346, 96, 96);
    basicPanel.add(threeButton);

    this.plusButton = new JButton("+");
    plusButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_plusButton_actionPerformed(e);
      }
    });
    plusButton.setBorderPainted(false);
    plusButton.setOpaque(true);
    plusButton.setForeground(new Color(51, 51, 51));
    plusButton.setFont(new Font("Arial", Font.PLAIN, 48));
    plusButton.setFocusable(false);
    plusButton.setDoubleBuffered(true);
    plusButton.setBackground(new Color(255, 204, 0));
    plusButton.setBounds(339, 346, 96, 96);
    basicPanel.add(plusButton);

    this.zeroButton = new JButton(" 0");
    zeroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_zeroButton_actionPerformed(e);
      }
    });
    zeroButton.setHorizontalAlignment(SwingConstants.LEFT);
    zeroButton.setBorderPainted(false);
    zeroButton.setOpaque(true);
    zeroButton.setForeground(new Color(51, 51, 51));
    zeroButton.setFont(new Font("Arial", Font.PLAIN, 48));
    zeroButton.setFocusable(false);
    zeroButton.setDoubleBuffered(true);
    zeroButton.setBackground(Color.WHITE);
    zeroButton.setBounds(15, 454, 204, 96);
    basicPanel.add(zeroButton);

    periodButton = new JButton(".");
    periodButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_periodButton_actionPerformed(e);
      }
    });
    periodButton.setBorderPainted(false);
    periodButton.setOpaque(true);
    periodButton.setForeground(new Color(51, 51, 51));
    periodButton.setFont(new Font("Arial", Font.PLAIN, 48));
    periodButton.setFocusable(false);
    periodButton.setDoubleBuffered(true);
    periodButton.setBackground(Color.WHITE);
    periodButton.setBounds(231, 454, 96, 96);
    basicPanel.add(periodButton);

    equalsButton = new JButton("=");
    equalsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_equalsButton_actionPerformed(e);
      }
    });
    equalsButton.setBorderPainted(false);
    equalsButton.setOpaque(true);
    equalsButton.setForeground(new Color(51, 51, 51));
    equalsButton.setFont(new Font("Arial", Font.PLAIN, 48));
    equalsButton.setFocusable(false);
    equalsButton.setDoubleBuffered(true);
    equalsButton.setBackground(new Color(255, 204, 0));
    equalsButton.setBounds(339, 454, 96, 96);
    basicPanel.add(equalsButton);

  }

  protected void do_oneButton_actionPerformed(ActionEvent e) {
    println("1 clicked");
    this.processor.takeOperand("1");
  }

  protected void do_zeroButton_actionPerformed(ActionEvent e) {
    println("0 clicked");
    // this.processor.executeCommand(new DigitCommand("0", this.processor));
  }

  protected void do_twoButton_actionPerformed(ActionEvent e) {
    println("2 clicked");
    // this.processor.executeCommand(new DigitCommand("2", this.processor));
  }

  protected void do_threeButton_actionPerformed(ActionEvent e) {
    println("3 clicked");
    // this.processor.executeCommand(new DigitCommand("3", this.processor));
  }

  protected void do_fourButton_actionPerformed(ActionEvent e) {
    println("4 clicked");
    // this.processor.executeCommand(new DigitCommand("4", this.processor));
  }

  protected void do_fiveButton_actionPerformed(ActionEvent e) {
    println("5 clicked");
    // this.processor.executeCommand(new DigitCommand("5", this.processor));
  }

  protected void do_sixButton_actionPerformed(ActionEvent e) {
    println("6 clicked");
    // this.processor.executeCommand(new DigitCommand("6", this.processor));
  }

  protected void do_sevenButton_actionPerformed(ActionEvent e) {
    println("7 clicked");
    // this.processor.executeCommand(new DigitCommand("7", this.processor));
  }

  protected void do_eightButton_actionPerformed(ActionEvent e) {
    println("8 clicked");
    // this.processor.executeCommand(new DigitCommand("8", this.processor));
  }

  protected void do_nineButton_actionPerformed(ActionEvent e) {
    println("9 clicked");
    // this.processor.executeCommand(new DigitCommand("9", this.processor));
  }

  protected void do_clearButton_actionPerformed(ActionEvent e) {
    println("ac clicked");
    this.processor.clearAll();
  }

  protected void do_btnUndo_actionPerformed(ActionEvent e) {
    println("undo clicked");
  }

  protected void do_plusMinusButton_actionPerformed(ActionEvent e) {
    println("\u00b1 clicked");
  }

  protected void do_divideButton_actionPerformed(ActionEvent e) {
    println("\u00f7 clicked");
  }

  protected void do_multiplyButton_actionPerformed(ActionEvent e) {
    println("x clicked");
  }

  protected void do_subtractButton_actionPerformed(ActionEvent e) {
    println("- clicked");
  }

  protected void do_plusButton_actionPerformed(ActionEvent e) {
    println("+ clicked");
    this.processor.takeOperator("+");

  }

  protected void do_equalsButton_actionPerformed(ActionEvent e) {
    println("= clicked");
    this.processor.executeCommand();
  }

  protected void do_periodButton_actionPerformed(ActionEvent e) {
    println(". clicked");
    // this.processor.executeCommand(new DigitCommand(".", this.processor));
  }

}