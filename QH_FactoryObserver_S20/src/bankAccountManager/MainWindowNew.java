package bankAccountManager;

import static sbcc.Core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;

import bankAccount.*;

public class MainWindowNew extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private JPanel operationPanel;
  private JPanel balancePanel;
  private JComboBox<String> accountTypesView;
  private JButton addButton;
  private JScrollPane accountListPanel;
  private JButton removeButton;

  // account types in drop down list
  DefaultComboBoxModel<String> accountTypesModel = new DefaultComboBoxModel<>();
  // list of names ("index - type") of real, added accounts
  DefaultListModel<String> accountsModel = new DefaultListModel<>();

  // Balance Chart
  DefaultCategoryDataset chartModel;
  JFreeChart chart;

  // * added components
  private AccountFactory accountFactory;
  private IAccountManager accountManager;

  public MainWindowNew() {

    // * Setting up UI

    // * Operation panel (left panel)
    this.operationPanel = new JPanel();

    var mainTitle = new JLabel("BANK ACCOUNT MANAGER");
    mainTitle.setFont(new Font("Courier", Font.BOLD, 36));
    this.operationPanel.add(mainTitle);
    this.operationPanel.setBorder(BorderFactory.createLineBorder(new Color(0xa0a0a0), 1, true));
    // this.operationPanel.setBounds(10, 100, 300, 320);
    this.operationPanel.setPreferredSize(new Dimension(550, 630));
    this.operationPanel.setMinimumSize(new Dimension(500, 600));
    this.operationPanel.setLayout(new BoxLayout(this.operationPanel, BoxLayout.PAGE_AXIS));

    // drop down menu title
    var acctTypeLabel = new JLabel("Account Types");
    acctTypeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    this.operationPanel.add(acctTypeLabel);

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
    // accountTypesView.setModel(accountTypesModel);
    accountTypesView.setBounds(10, 67, 207, 32);
    this.operationPanel.add(accountTypesView);

    // * Add account botton
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
    this.operationPanel.add(addButton);

    // acount list title
    var accountListLabel = new JLabel("Account List");
    accountListLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    this.operationPanel.add(accountListLabel);

    // account list
    this.accountListPanel = new JScrollPane();
    accountListPanel.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
    accountListPanel.setForeground(new Color(0, 0, 0));
    accountListPanel.setBackground(new Color(255, 255, 255));
    accountListPanel.setViewportBorder(null);
    accountListPanel.setBounds(10, 113, 402, 78);
    this.operationPanel.add(accountListPanel);

    // * Balance panel (right panel)
    this.balancePanel = new JPanel(new FlowLayout());
    var balanceTitle = new JLabel("BALANCES");
    balanceTitle.setFont(new Font("Arial", Font.PLAIN, 24));
    this.balancePanel.add(balanceTitle);
    this.balancePanel.setBorder(BorderFactory.createLineBorder(new Color(0xa0a0a0), 1, true));
    this.balancePanel.setPreferredSize(new Dimension(550, 630));
    this.balancePanel.setMinimumSize(new Dimension(500, 600));

    // * Draw on bottom panel
    this.initChart();

    // * JFrame
    Container rootPane = this.getContentPane();
    rootPane.setLayout(new BorderLayout());
    rootPane.add(operationPanel, BorderLayout.WEST);
    rootPane.add(balancePanel, BorderLayout.EAST);
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

  public static void main(String[] args) {
    new MainWindowNew();
  }

}