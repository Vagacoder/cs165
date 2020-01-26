package observermultipleviewsex;

import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import static java.lang.Math.*;
import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;

import javax.swing.event.ListSelectionEvent;

public class MainWindow extends JFrame implements BalanceChangedListener {

	private JPanel mainPanel;
	private JTextField amountTextField;
	private JButton depositButton;
	private JButton withdrawButton;
	JFreeChart chart;
	DefaultCategoryDataset categoryDataset;
	int txnId = 1;

	Account account = new Account(0.0);
	private JPanel balancesPanel;

	private TransactionWindow transactionWindow;
	private FinanceChargeWindow financeChargeWindow;
	private JLabel balanceView;

	public static void main(String[] args) {
		new MainWindow().setVisible(true);
	}


	protected void do_this_windowOpened(WindowEvent e) {
	}


	protected void do_depositButton_actionPerformed(ActionEvent e) {
		account.deposit(parseDouble(amountTextField.getText()));
	}


	protected void do_withdrawButton_actionPerformed(ActionEvent e) {
		account.withdraw(parseDouble(amountTextField.getText()));
	}


	void initChart() {

		// Create an empty data set
		categoryDataset = new DefaultCategoryDataset();
		categoryDataset.setValue(account.getBalance(), "", "0");

		// Create a bar chart
		chart = ChartFactory.createBarChart3D("Balances", // Title
				"Transaction", // X-Axis label
				"Balance", // Y-Axis label
				categoryDataset, // Dataset
				PlotOrientation.VERTICAL, false, // Show legend
				true, true);
		chart.setAntiAlias(true);

		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(66, 189, 66));

		ChartPanel cp = new ChartPanel(chart);
		cp.setBounds(0, 78, 443, 295);
		cp.setPreferredSize(new Dimension(640, 480));
		cp.setBackground(Color.white);
		cp.setForeground(Color.white);
		cp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));

		balancesPanel.add(cp);
	}


	public MainWindow() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("bank-256x256.png"));
		account.addBalanceChangedListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				do_this_windowOpened(e);
			}
		});

		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setBounds(10, 11, 668, 63);
		mainPanel.setPreferredSize(new Dimension(300, 300));
		mainPanel.setMinimumSize(new Dimension(300, 300));
		mainPanel.setForeground(new Color(255, 255, 255));
		mainPanel.setBorder(null);
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		amountTextField = new JTextField();
		amountTextField.setForeground(new Color(51, 51, 51));
		amountTextField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		amountTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountTextField.setText("20");
		amountTextField.setBounds(273, 13, 67, 33);
		mainPanel.add(amountTextField);
		amountTextField.setColumns(10);

		depositButton = new JButton("DEPOSIT");
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_depositButton_actionPerformed(e);
			}
		});
		depositButton.setOpaque(true);
		depositButton.setForeground(new Color(51, 51, 51));
		depositButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		depositButton.setBackground(new Color(255, 255, 255));
		depositButton.setBounds(350, 11, 141, 35);
		mainPanel.add(depositButton);

		withdrawButton = new JButton("WITHDRAW");
		withdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_withdrawButton_actionPerformed(e);
			}
		});
		withdrawButton.setOpaque(true);
		withdrawButton.setForeground(new Color(51, 51, 51));
		withdrawButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		withdrawButton.setBackground(new Color(255, 255, 255));
		withdrawButton.setBounds(501, 11, 141, 35);
		mainPanel.add(withdrawButton);

		balanceView = new JLabel("$0.00");
		balanceView.setHorizontalAlignment(SwingConstants.CENTER);
		balanceView.setForeground(Color.BLUE);
		balanceView.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		balanceView.setBounds(22, 12, 241, 33);
		mainPanel.add(balanceView);

		balancesPanel = new JPanel();
		balancesPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
		balancesPanel.setBackground(new Color(255, 255, 255));
		balancesPanel.setBounds(10, 85, 668, 488);
		getContentPane().add(balancesPanel);
		balancesPanel.setLayout(new BorderLayout(0, 8));

		initChart();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(706, 600);
		setLocation(10, 10);

		initTransactionWindow();
		initFinanceChargeWindow();
	}


	private void initTransactionWindow() {
		transactionWindow = new TransactionWindow(account);
		transactionWindow.setLocation(710, 10);
		transactionWindow.setVisible(true);
	}


	private void initFinanceChargeWindow() {
		financeChargeWindow = new FinanceChargeWindow(account);
		financeChargeWindow.setLocation(710, 310);
		financeChargeWindow.setVisible(true);
	}


	@Override
	public void balanceChanged(Account sender) {
		txnId++;
		categoryDataset.setValue(account.getBalance(), "", String.valueOf(txnId));
		balanceView.setText(String.format("$%.2f", account.getBalance()));

	}

}
