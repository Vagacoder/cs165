package changemyname;

import static sbcc.Core.*;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;

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

public class MainWindow extends JFrame {

	private JPanel mainPanel;
	private JComboBox accountTypesView;
	private JButton addButton;
	private JLabel accountsTitleLabel;
	private JScrollPane scrollPane;
	private JList accountsView;
	private JButton removeButton;
	private JTextField amountTextField;
	private JButton depositButton;
	private JButton withdrawButton;
	DefaultListModel<String> accountsModel = new DefaultListModel<>();
	DefaultComboBoxModel<String> accountTypesModel = new DefaultComboBoxModel<>();
	private JPanel balancesPanel;
	private JLabel balancesTitleLabel;
	JFreeChart chart;
	DefaultCategoryDataset chartModel;

	/**
	 * Creates the MainWindow and shows it on the screen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainWindow().setVisible(true);
	}


	/**
	 * Called when the window first opens.
	 * 
	 * @param e
	 */
	protected void do_this_windowOpened(WindowEvent e) {
	}


	/**
	 * Called when the ADD button is clicked.
	 * 
	 * @param e
	 */
	protected void do_addButton_actionPerformed(ActionEvent e) {
	}


	/**
	 * Called when the REMOVE button is clicked.
	 * 
	 * @param e
	 */
	protected void do_removeButton_actionPerformed(ActionEvent e) {
	}


	/**
	 * Called when the DEPOSIT button is clicked.
	 * 
	 * @param e
	 */
	protected void do_depositButton_actionPerformed(ActionEvent e) {
	}


	/**
	 * Called when the WITHDRAW button is clicked.
	 * 
	 * @param e
	 */
	protected void do_withdrawButton_actionPerformed(ActionEvent e) {
	}


	/**
	 * This method clears the account types list and fills it with the given values.
	 * 
	 * Call this method at startup with the list of account types that your factory can create. Also call this if your
	 * factory supports dynamic class loading of new account types.
	 * 
	 * @param accountTypes
	 */
	void updateAccountTypesView(String[] accountTypes) {
		accountTypesModel.removeAllElements();
		for (String type : accountTypes)
			accountTypesModel.addElement(type);
	}


	/**
	 * This method clears the accounts list and fills it with the given values.
	 * 
	 * Call this method whenever an account is added or removed.
	 * 
	 * @param accountTypes
	 */
	void updateAccountListView(String[] accounts) {
		accountsModel.removeAllElements();
		for (String account : accounts)
			accountsModel.addElement(account);
	}


	/**
	 * This method updates the x and y values in the chart. Call this whenever an account balance changes.
	 * 
	 * @param xLabels
	 * @param yValues
	 */
	void updateChartView(String[] xLabels, double[] yValues) {
		chartModel.clear();
		for (int ndx = 0; ndx < xLabels.length; ndx++)
			chartModel.setValue(yValues[ndx], "", xLabels[ndx]);
	}


	/**
	 * Creates the bar chart and adds it to the UI.
	 */
	void initChart() {
		chartModel = new DefaultCategoryDataset();
		chart = ChartFactory.createBarChart3D("", "", "DOLLARS", chartModel, PlotOrientation.VERTICAL, false, true,
				true);
		chart.setAntiAlias(true);
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
		balancesPanel.add(cp);

	}


	/**
	 * Constructs the UI.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("bank-256x256.png"));
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
		mainPanel.setBounds(10, 11, 668, 206);
		mainPanel.setPreferredSize(new Dimension(300, 300));
		mainPanel.setMinimumSize(new Dimension(300, 300));
		mainPanel.setForeground(new Color(255, 255, 255));
		mainPanel.setBorder(null);
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		accountTypesView = new JComboBox();
		accountTypesView.setBorder(null);
		accountTypesView.setForeground(new Color(51, 51, 51));
		accountTypesView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		accountTypesView.setModel(accountTypesModel);
		accountTypesView.setBounds(10, 67, 207, 32);
		mainPanel.add(accountTypesView);

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
		mainPanel.add(addButton);

		accountsTitleLabel = new JLabel("MY ACCOUNTS");
		accountsTitleLabel.setBackground(new Color(51, 51, 51));
		accountsTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		accountsTitleLabel.setForeground(new Color(51, 51, 51));
		accountsTitleLabel.setBounds(10, 29, 200, 27);
		mainPanel.add(accountsTitleLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 113, 402, 78);
		mainPanel.add(scrollPane);

		accountsView = new JList();
		accountsView.setLocation(24, 0);
		accountsView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		accountsView.setForeground(new Color(51, 51, 51));
		accountsView.setModel(accountsModel);
		accountsView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountsView.setBorder(new EmptyBorder(8, 8, 8, 8));
		accountsView.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(accountsView);

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
		mainPanel.add(removeButton);

		amountTextField = new JTextField();
		amountTextField.setForeground(new Color(51, 51, 51));
		amountTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		amountTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		amountTextField.setText("20");
		amountTextField.setBounds(426, 113, 232, 33);
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
		depositButton.setFocusPainted(false);
		depositButton.setForeground(new Color(51, 51, 51));
		depositButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		depositButton.setBackground(new Color(255, 255, 255));
		depositButton.setBounds(422, 158, 115, 33);
		mainPanel.add(depositButton);

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
		mainPanel.add(withdrawButton);

		balancesPanel = new JPanel();
		balancesPanel.setBorder(new EmptyBorder(16, 8, 24, 8));
		balancesPanel.setBackground(new Color(255, 255, 255));
		balancesPanel.setBounds(10, 228, 668, 520);
		getContentPane().add(balancesPanel);
		balancesPanel.setLayout(new BorderLayout(0, 0));

		balancesTitleLabel = new JLabel("BALANCES");
		balancesTitleLabel.setForeground(new Color(51, 51, 51));
		balancesTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		balancesTitleLabel.setBackground(new Color(51, 51, 51));
		balancesPanel.add(balancesTitleLabel, BorderLayout.NORTH);

		initChart();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 794);

	}

}
