package bankAccountManager;

import static sbcc.Core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
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
  private JTextField amountTextField;
  private JButton depositButton;
  private JButton withdrawButton;
  private JTextArea messageField;
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
    // this.operationPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    // this.operationPanel.setBounds(10, 100, 300, 320);
    this.operationPanel.setPreferredSize(new Dimension(500, 630));
    this.operationPanel.setMinimumSize(new Dimension(500, 625));
    this.operationPanel.setLayout(new BoxLayout(this.operationPanel, BoxLayout.PAGE_AXIS));

    // * Account Type List Dropdown Menu and ADD button
    var accountTypeListPanel = new JPanel();
    accountTypeListPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Account Types"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

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
    accountTypesView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    accountTypesView.setBounds(10, 67, 207, 32);
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
    addButton.setBounds(223, 68, 90, 33);
    accountTypeListPanel.add(addButton);
    this.operationPanel.add(accountTypeListPanel);

    // * Account List and REMOVE Buttons
    var accountListPanel = new JPanel();
    accountListPanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("Accounts List"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // account list display subpanel
    this.accountListDisplayPanel = new JScrollPane();
    accountListDisplayPanel.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
    accountListDisplayPanel.setForeground(new Color(0, 0, 0));
    accountListDisplayPanel.setBackground(new Color(255, 255, 255));
    accountListDisplayPanel.setBounds(10, 113, 402, 78);
    accountListPanel.add(accountListDisplayPanel);
    this.operationPanel.add(accountListPanel);

    // Real account list
    accountsView = new JList<String>(accountsModel);
    accountsView.setLocation(24, 0);
    accountsView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    accountsView.setForeground(new Color(51, 51, 51));
    accountsView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    accountsView.setBorder(new EmptyBorder(8, 8, 8, 8));
    accountsView.setBackground(new Color(255, 255, 255));
    accountListDisplayPanel.setViewportView(accountsView);

    // REMOVE button
    removeButton = new JButton("REMOVE");
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
    removeButton.setBounds(325, 68, 90, 33);
    accountListPanel.add(removeButton);

    // * Amount panel: AMOUNT Inputfield, DEPOSITE, WITHDRAW buttons
    var amountPanel = new JPanel();
    amountPanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("Amount ($)"),
    BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // Input field for amount
    amountTextField = new JTextField();
    amountTextField.setForeground(new Color(51, 51, 51));
    amountTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    amountTextField.setHorizontalAlignment(SwingConstants.RIGHT);
    amountTextField.setText("20");
    amountTextField.setBounds(426, 113, 232, 33);
    amountTextField.setColumns(10);
    amountPanel.add(amountTextField);

    // Deposite button
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

    // * Message Panel
    var messagePanel = new JPanel();
    messagePanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("System Feedback"),
    BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    this.messageField = new JTextArea("", 2, 40);
    this.messageField.setEditable(false);
    this.messageField.setBorder(BorderFactory.createLoweredBevelBorder());
    messagePanel.add(this.messageField);
    this.operationPanel.add(messagePanel);

    // * Transcation Panel
    var transactionListPanel = new JPanel();
    transactionListPanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("Transactions"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    // transaction list display subpanel
    this.transactionListDisplayPanel = new JScrollPane();
    transactionListDisplayPanel.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
    transactionListDisplayPanel.setForeground(new Color(0, 0, 0));
    transactionListDisplayPanel.setBackground(new Color(255, 255, 255));
    // transactionListDisplayPanel.setBounds(10, 113, 402, 78);
    transactionListDisplayPanel.setSize(new Dimension(500, 100));
    transactionListPanel.add(transactionListDisplayPanel);
    this.operationPanel.add(transactionListPanel);
    

    // Real transaction list
    transactionsView = new JList<String>(transactionsModel);
    transactionsView.setLocation(24, 0);
    transactionsView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    transactionsView.setForeground(new Color(51, 51, 51));
    transactionsView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    transactionsView.setBorder(new EmptyBorder(8, 8, 8, 8));
    transactionsView.setBackground(new Color(255, 255, 255));
    transactionsView.setSize(new Dimension(500, 100));
    transactionListDisplayPanel.setViewportView(transactionsView);


    // ** Balance panel (right panel)
    balancePanel = new JPanel();
    balancePanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("BALANCES"),
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
    this.setSize(1200, 650);
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
    this.accountManager.removeSelectedAccount(selectedIndex);
  }

  protected void do_depositButton_actionPerformed(ActionEvent e) {
    String inputAmount = this.amountTextField.getText();
    println(inputAmount);
    try {
      Double amount = Double.parseDouble(inputAmount);
      int amountInCent = (int) (amount * 100);
      println(amountInCent);

      int selectedIndex = this.accountsView.getSelectedIndex();
      this.accountManager.deposite(selectedIndex, amountInCent);
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
    ArrayList<IAccount> accountsList = source.getAllAccouts();
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

  public static void main(String[] args) {
    new MainWindowNew();
  }

}