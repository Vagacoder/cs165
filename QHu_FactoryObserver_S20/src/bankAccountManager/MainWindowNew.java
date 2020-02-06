package bankAccountManager;

import static sbcc.Core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;

import bankAccount.*;

public class MainWindowNew extends JFrame implements IAccountListener {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private JPanel operationPanel;
  private JPanel balancePanel;
  private JComboBox<String> accountTypesView;
  private JButton addButton;
  private JScrollPane accountListDisplayPanel;
  private JList<String> accountsView;
  private JButton removeButton;
  private JButton transactionButton;
  private JTextField amountTextField;
  private JButton depositButton;
  private JButton withdrawButton;
  private JLabel messageField;
  private JScrollPane transactionListDisplayPanel;
  private JList<String> transactionsView;

  // account types in drop down list
  DefaultComboBoxModel<String> accountTypesModel = new DefaultComboBoxModel<>();
  // list of names ("index - type") of real, added accounts
  DefaultListModel<String> accountsModel = new DefaultListModel<>();
  // list of transaction info (Date - Amount - Operation - balance);
  DefaultListModel<String> transactionsModel = new DefaultListModel<>();

  // Balance Chart
  DefaultCategoryDataset chartModel;
  JFreeChart chart;

  // * added components
  private AccountFactory accountFactory;
  private IAccountManager accountManager;

  public MainWindowNew() {

    this.accountFactory = new AccountFactory();
    this.accountManager = new AccountManager();
    this.accountManager.addAccountListener(this);

    // **** Setting up UI
    // ** Operation panel (left panel)
    this.operationPanel = new JPanel();
    this.operationPanel.setPreferredSize(new Dimension(500, 640));
    this.operationPanel.setMinimumSize(new Dimension(500, 635));
    this.operationPanel.setLayout(new BoxLayout(this.operationPanel, BoxLayout.PAGE_AXIS));

    // * Account Type List Dropdown Menu and ADD button
    var accountTypeListPanel = new JPanel();
    accountTypeListPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Account Types"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    accountTypeListPanel.setLayout(new FlowLayout());
      
    // pre-set account types
    ArrayList<String> accountTypes = new ArrayList<String>();
    accountTypes.add("CD");
    accountTypes.add("Checking");
    accountTypes.add("Saving");
    accountTypes.add("MoneyMarket");

    // drop down menu
    this.accountTypesModel.addAll(accountTypes);
    this.accountTypesView = new JComboBox<String>(accountTypesModel);
    accountTypesView.setBorder(null);
    accountTypesView.setForeground(new Color(51, 51, 51));
    accountTypesView.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    accountTypesView.setBorder(new EmptyBorder(10, 10, 10, 10));
    accountTypesView.setPrototypeDisplayValue("0 - MoneyMarket");
    accountTypesView.setPreferredSize(new Dimension(220,45));
    accountTypeListPanel.add(accountTypesView);

    // ADD botton
    addButton = new JButton("ADD");
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_addButton_actionPerformed(e);
      }
    });
    addButton.setFocusPainted(false);
    addButton.setOpaque(true);
    addButton.setForeground(new Color(51, 51, 51));
    addButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    addButton.setBackground(new Color(255, 255, 255));
    accountTypeListPanel.add(addButton);
    this.operationPanel.add(accountTypeListPanel);

    // * Account List and REMOVE, TRANSACTION Buttons
    var accountListPanel = new JPanel();
    accountListPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Accounts List"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    accountListPanel.setLayout(new FlowLayout());

    // account list display subpanel
    this.accountListDisplayPanel = new JScrollPane();
    accountListDisplayPanel.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
    accountListDisplayPanel.setForeground(new Color(0, 0, 0));
    accountListDisplayPanel.setBackground(new Color(255, 255, 255));
    accountListDisplayPanel.setPreferredSize(new Dimension(300, 70));
    accountListPanel.add(accountListDisplayPanel);
    this.operationPanel.add(accountListPanel);

    // Real account list
    accountsView = new JList<String>(accountsModel);
    accountsView.setLocation(24, 0);
    accountsView.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    accountsView.setForeground(new Color(51, 51, 51));
    accountsView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    accountsView.setBorder(new EmptyBorder(8, 8, 8, 8));
    accountsView.setBackground(new Color(255, 255, 255));
    accountListDisplayPanel.setViewportView(accountsView);

    // SUbpanel for Buttons
    var buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    accountListPanel.add(buttonPanel);
    // REMOVE button
    removeButton = new JButton("    REMOVE    ");
    removeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_removeButton_actionPerformed(e);
      }
    });
    removeButton.setOpaque(true);
    removeButton.setFocusPainted(false);
    removeButton.setForeground(new Color(51, 51, 51));
    removeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    removeButton.setBackground(new Color(255, 255, 255));
    removeButton.setPreferredSize(new Dimension(170, 25));
    removeButton.setAlignmentX(CENTER_ALIGNMENT);
    buttonPanel.add(removeButton);
    buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));

    // TRANSACTION button
    transactionButton = new JButton("TRANSACTION");
    transactionButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_transactionButton_actionPerformed(e);
      }
    });
    transactionButton.setOpaque(true);
    transactionButton.setFocusPainted(false);
    transactionButton.setForeground(new Color(51, 51, 51));
    transactionButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    transactionButton.setBackground(new Color(255, 255, 255));
    transactionButton.setPreferredSize(new Dimension(170, 25));
    transactionButton.setAlignmentX(CENTER_ALIGNMENT);
    buttonPanel.add(transactionButton);
    

    // * Amount panel: AMOUNT Inputfield, DEPOSIT, WITHDRAW buttons
    var amountPanel = new JPanel();
    amountPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Amount ($)"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // Input field for amount
    amountTextField = new JTextField();
    amountTextField.setForeground(new Color(51, 51, 51));
    amountTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    amountTextField.setHorizontalAlignment(SwingConstants.RIGHT);
    amountTextField.setText("20");
    amountTextField.setBounds(426, 113, 232, 33);
    amountTextField.setColumns(10);
    amountTextField.setBorder(BorderFactory.createLoweredBevelBorder());
    amountPanel.add(amountTextField);

    // Deposit button
    depositButton = new JButton("DEPOSIT");
    depositButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_depositButton_actionPerformed(e);
      }
    });
    depositButton.setOpaque(true);
    depositButton.setFocusPainted(false);
    depositButton.setForeground(new Color(51, 51, 51));
    depositButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    depositButton.setBackground(new Color(255, 255, 255));
    depositButton.setBounds(422, 158, 115, 33);
    amountPanel.add(depositButton);

    // Withdraw button
    withdrawButton = new JButton("WITHDRAW");
    withdrawButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        do_withdrawButton_actionPerformed(e);
      }
    });
    withdrawButton.setOpaque(true);
    withdrawButton.setFocusPainted(false);
    withdrawButton.setForeground(new Color(51, 51, 51));
    withdrawButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    withdrawButton.setBackground(new Color(255, 255, 255));
    withdrawButton.setBounds(543, 157, 115, 33);
    amountPanel.add(withdrawButton);
    this.operationPanel.add(amountPanel);

    // * Transcation Panel
    var transactionListPanel = new JPanel();
    transactionListPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Transactions"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // transaction list display subpanel
    this.transactionListDisplayPanel = new JScrollPane();
    transactionListDisplayPanel.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
    transactionListDisplayPanel.setForeground(new Color(0, 0, 0));
    transactionListDisplayPanel.setBackground(new Color(255, 255, 255));
    // transactionListDisplayPanel.setBounds(10, 113, 402, 78);
    transactionListDisplayPanel.setPreferredSize(new Dimension(460, 200));
    transactionListPanel.add(transactionListDisplayPanel);
    this.operationPanel.add(transactionListPanel);

    // Real transaction list
    transactionsView = new JList<String>(transactionsModel);
    transactionsView.setLocation(24, 0);
    transactionsView.setFont(new Font("Courier", Font.PLAIN, 13));
    transactionsView.setForeground(new Color(51, 51, 51));
    transactionsView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    transactionsView.setBorder(new EmptyBorder(8, 8, 8, 8));
    transactionsView.setBackground(new Color(255, 255, 255));
    transactionsView.setSize(new Dimension(500, 100));
    transactionListDisplayPanel.setViewportView(transactionsView);

    // * Message Panel
    var messagePanel = new JPanel();
    messagePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("System Log"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    this.messageField = new JLabel("");
    messagePanel.add(this.messageField);
    this.operationPanel.add(messagePanel);

    // ** Balance panel (right panel)
    balancePanel = new JPanel();
    balancePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("BALANCES"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // * Draw on right panel
    this.initChart();

    // *** JFrame
    Container rootPane = this.getContentPane();
    var rootPanel = new JPanel();
    rootPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    rootPanel.setLayout(new BorderLayout());
    var mainTitle = new JLabel("BANK ACCOUNT MANAGER");
    mainTitle.setFont(new Font("Courier", Font.BOLD, 36));
    rootPanel.add(mainTitle, BorderLayout.NORTH);
    rootPanel.add(operationPanel, BorderLayout.WEST);
    rootPanel.add(balancePanel, BorderLayout.EAST);
    rootPane.add(rootPanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1200, 700);
    this.setVisible(true);
  }

  /**
   * Creates the bar chart and adds it to the UI.
   */
  private void initChart() {
    this.chartModel = new DefaultCategoryDataset();
    this.chart = ChartFactory.createBarChart3D("", "", "DOLLARS", chartModel, PlotOrientation.VERTICAL, false, true,
        false);
    this.chart.setAntiAlias(true);
    CategoryPlot plot = chart.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setSeriesPaint(0, new Color(66, 189, 66));

    ChartPanel cp = new ChartPanel(chart);
    FlowLayout flowLayout = (FlowLayout) cp.getLayout();
    flowLayout.setVgap(0);
    flowLayout.setHgap(0);
    cp.setBounds(0, 0, 640, 480);
    cp.setPreferredSize(new Dimension(640, 480));
    cp.setBackground(Color.white);
    cp.setForeground(Color.white);
    cp.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    this.balancePanel.add(cp);

  }

  protected void do_this_windowOpened(WindowEvent e) {
    this.transactionsModel.removeAllElements();
    ;
    this.transactionsModel.addElement(String.format("%s%30s%20s%20s", "Date", "Amount", "Operation", "Balance"));
  }

  protected void do_addButton_actionPerformed(ActionEvent e) {
    String selectedAccountType = String.valueOf(this.accountTypesView.getSelectedItem());
    println(selectedAccountType);
    if (!selectedAccountType.equals("null")) {
      try {
        IAccount newAccount = this.accountFactory.createAccount(selectedAccountType);
        println(newAccount.getAcctType());
        this.accountManager.addAccount(newAccount);
        this.accountManager.fireAccountUpdated();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else {
      println("System warning: Please select an account type!");
    }
  }

  protected void do_removeButton_actionPerformed(ActionEvent e) {
    int selectedIndex = this.accountsView.getSelectedIndex();
    this.accountManager.removeSelectedAccount(this, selectedIndex);
  }

  protected void do_transactionButton_actionPerformed(ActionEvent e) {
    int selectedIndex = this.accountsView.getSelectedIndex();
    this.accountManager.showAcctTransactions(selectedIndex);
  }

  protected void do_depositButton_actionPerformed(ActionEvent e) {
    String inputAmount = this.amountTextField.getText();
    println(inputAmount);
    try {
      Double amount = Double.parseDouble(inputAmount);
      int amountInCent = (int) (amount * 100);
      println(amountInCent);

      int selectedIndex = this.accountsView.getSelectedIndex();
      this.accountManager.deposit(selectedIndex, amountInCent);
    } catch (Exception ex) {
      println("System warning: Wrong input!");
    }
  }

  protected void do_withdrawButton_actionPerformed(ActionEvent e) {
    String inputAmount = this.amountTextField.getText();
    println(inputAmount);
    try {
      Double amount = Double.parseDouble(inputAmount);
      int amountInCent = (int) (amount * 100);
      println(amountInCent);

      int selectedIndex = this.accountsView.getSelectedIndex();
      this.accountManager.withdraw(selectedIndex, amountInCent);
    } catch (Exception ex) {
      println("System warning: Wrong input!");
    }
  }

  @Override
  public void updateAccount(IAccountManager source) {
    ArrayList<IAccount> accountsList = source.getAllAccounts();
    int N = accountsList.size();
    String[] accountNames = new String[N];
    String[] xLabelsForChart = new String[N];
    double[] yValuesForChart = new double[N];

    this.accountsModel.clear();
    for (int i = 0; i < N; i++) {
      IAccount acct = accountsList.get(i);
      accountNames[i] = ((i + 1) + " - " + acct.getAcctType());
      xLabelsForChart[i] = (i + 1) + " - " + acct.getAcctType();
      int amountInCent = acct.getBalanceInCent();
      double amount = amountInCent * 1.0 / 100;
      yValuesForChart[i] = amount;
    }
    this.updateAccountListView(accountNames);
    this.updateChartView(xLabelsForChart, yValuesForChart);
  }

  @Override
  public void updateMessage(IAccountManager source) {
    println("Update Message");
    String message = source.getFeedbackMessage();
    this.messageField.setText(message);
    if (message.startsWith("Warning")) {
      this.messageField.setForeground(Color.magenta);
    } else if (message.startsWith("Error")) {
      this.messageField.setForeground(Color.RED);
    } else {
      this.messageField.setForeground(Color.BLACK);
    }
    println(message);
  }

  void updateAccountListView(String[] accounts) {
    accountsModel.removeAllElements();
    for (String account : accounts)
      accountsModel.addElement(account);
  }

  void updateChartView(String[] xLabels, double[] yValues) {
    chartModel.clear();
    for (int ndx = 0; ndx < xLabels.length; ndx++)
      chartModel.setValue(yValues[ndx], "", xLabels[ndx]);
  }

  @Override
  public void updateTransaction(IAccountManager source) {
    ArrayList<Transaction> trans = source.getTransactions();
    this.transactionsModel.removeAllElements();
    ;
    this.transactionsModel.addElement(String.format("%s%20s%14s%16s", "Date", "Amount", "Operation", "Balance"));
    for (var tran : trans) {
      Date date = tran.getDate();
      int year = 1900 + date.getYear();
      int month = 1 + date.getMonth();
      int day = date.getDate();
      String dateStr = year + "-" + month + "-" + day;
      String amount = getMoneyString(tran.getAmountInCent());
      String balance = getMoneyString(tran.getBalanceAfter());
      this.transactionsModel.addElement(String.format("%s%16s%14s%16s", dateStr, amount, tran.getOperation(), balance));
    }
  }

  public static String getMoneyString(int amountInCent) {
    int dollars = amountInCent / 100;
    int cents = amountInCent % 100;
    return dollars + "." + cents;
  }

  public static void main(String[] args) {
    new MainWindowNew();
  }

}