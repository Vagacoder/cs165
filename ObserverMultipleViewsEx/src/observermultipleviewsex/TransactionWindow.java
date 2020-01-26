package observermultipleviewsex;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class TransactionWindow extends JFrame implements BalanceChangedListener {

	private JPanel contentPane;
	private Account account;
	private double balance;
	private String txnType = "";
	private double txnAmount = 0.0;

	private Color depositColor = new Color(0, 0, 255);
	private Color withdrawalColor = new Color(255, 0, 0);
	private JLabel currentTransactionView;
	private JLabel previousTransactionView;

	/**
	 * Create the frame.
	 */
	public TransactionWindow(Account account) {

		this.account = account;
		account.addBalanceChangedListener(this);

		setIconImage(Toolkit.getDefaultToolkit().getImage("bank-256x256.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("PREVIOUS TRANSACTION");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 112, 254, 35);
		contentPane.add(lblNewLabel);

		JLabel lblCurrentTransaction = new JLabel("CURRENT TRANSACTION");
		lblCurrentTransaction.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblCurrentTransaction.setBounds(20, 20, 272, 35);
		contentPane.add(lblCurrentTransaction);

		currentTransactionView = new JLabel("");
		currentTransactionView.setHorizontalAlignment(SwingConstants.CENTER);
		currentTransactionView.setForeground(Color.BLUE);
		currentTransactionView.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		currentTransactionView.setBounds(20, 55, 396, 35);
		contentPane.add(currentTransactionView);

		previousTransactionView = new JLabel("");
		previousTransactionView.setHorizontalAlignment(SwingConstants.CENTER);
		previousTransactionView.setForeground(Color.BLUE);
		previousTransactionView.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		previousTransactionView.setBounds(20, 146, 396, 35);
		contentPane.add(previousTransactionView);

		initTxns();
	}


	void initTxns() {
		txnType = "Account Created";
		balance = account.getBalance();
		txnAmount = balance;
		currentTransactionView.setText(txnType + ":  " + txnAmount);
		previousTransactionView.setText("None");
	}


	@Override
	public void balanceChanged(Account sender) {
		previousTransactionView.setText(currentTransactionView.getText());
		previousTransactionView.setForeground(currentTransactionView.getForeground());
		double newBalance = account.getBalance();
		if (newBalance > balance) {
			txnType = "Deposit";
			currentTransactionView.setForeground(depositColor);
		} else {
			txnType = "Withdrawal";
			currentTransactionView.setForeground(withdrawalColor);
		}
		txnAmount = Math.abs(newBalance - balance);
		balance = newBalance;
		String s = "$" + String.format("%.2f", txnAmount);
		currentTransactionView.setText(txnType + ": " + s);

	}
}
