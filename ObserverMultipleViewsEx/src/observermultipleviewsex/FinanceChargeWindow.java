package observermultipleviewsex;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinanceChargeWindow extends JFrame implements BalanceChangedListener {

	private JPanel contentPane;
	private Account account;
	private JButton applyFinanceChargeButton;
	private JLabel balanceView;

	/**
	 * Create the frame.
	 */
	public FinanceChargeWindow(Account account) {
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

		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblBalance.setBounds(20, 20, 272, 35);
		contentPane.add(lblBalance);

		balanceView = new JLabel("$0.00");
		balanceView.setHorizontalAlignment(SwingConstants.CENTER);
		balanceView.setForeground(Color.BLUE);
		balanceView.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		balanceView.setBounds(20, 60, 396, 35);
		contentPane.add(balanceView);

		applyFinanceChargeButton = new JButton("CHARGE REDICULOUS FEE");
		applyFinanceChargeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyFinanceChargeButtonClicked(account);
			}

		});
		applyFinanceChargeButton.setBounds(20, 205, 396, 35);
		contentPane.add(applyFinanceChargeButton);
		applyFinanceChargeButton.setOpaque(true);
		applyFinanceChargeButton.setForeground(new Color(51, 51, 51));
		applyFinanceChargeButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		applyFinanceChargeButton.setBackground(Color.WHITE);

	}


	private void applyFinanceChargeButtonClicked(Account account) {
		account.withdraw(account.getBalance() * 0.01);
	}


	@Override
	public void balanceChanged(Account sender) {
		balanceView.setText(String.format("$%.2f", account.getBalance()));

	}
}
