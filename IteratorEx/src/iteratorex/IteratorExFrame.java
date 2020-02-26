package iteratorex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import static java.util.Arrays.*;

public class IteratorExFrame extends JFrame {

	/**
	 * List of data items
	 */
	ArrayList<String> data = new ArrayList<String>();

	/**
	 * Iterator 1
	 */
	ListIterator<String> it1;
	Color it1Color = new Color(0x40c4ff);

	/**
	 * Iterator 2
	 */
	ListIterator<String> it2;
	Color it2Color = new Color(0xa5d6a7);

	JPanel contentPane;
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu jMenuFile = new JMenu();
	JMenuItem jMenuFileExit = new JMenuItem();
	JMenu jMenuHelp = new JMenu();
	JMenuItem jMenuHelpAbout = new JMenuItem();
	JScrollPane jScrollPane1 = new JScrollPane();
	JList jList1 = new JList();
	JButton jButton1 = new JButton();
	JTextField jTextField1 = new JTextField();
	JLabel jLabel1 = new JLabel();
	JTextField jTextField2 = new JTextField();
	JButton jButton2 = new JButton();
	JLabel jLabel2 = new JLabel();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();

	String[] words = { "Unlightening", "Hiberdating", "Destinesia", "Textpectation", "Columbusing", "Youniverse",
			"Carcolepsy", "Ambitchous", "Unkeyboardinated", "Afterclap", "Beerboarding", "Nerdjacking", "Nomonym",
			"Dudevorce", "Nonversation", "Cellfish", "Chairdrobe" };

	// Construct the frame
	public IteratorExFrame() {

		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			// Build the collection
			sort(words);
			data.addAll(asList(words));

			// Ask the collection for two iterators.
			// They both start off just *before* the first item in the collection
			it1 = data.listIterator();
			it2 = data.listIterator();

			jbInit(); // Build the GUI
			jList1.setFont(new Font("Arial", Font.PLAIN, 18));

			jList1.setListData(data.toArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		this.setSize(new Dimension(723, 595));
		this.setTitle("Iterator Example");
		jMenuFile.setText("File");
		jMenuFileExit.setText("Exit");
		jMenuFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuFileExit_actionPerformed(e);
			}
		});
		jMenuHelp.setText("Help");
		jMenuHelpAbout.setText("About");
		jMenuHelpAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuHelpAbout_actionPerformed(e);
			}
		});
		jScrollPane1.setBounds(new Rectangle(11, 10, 308, 517));
		jButton1.setFont(new Font("Arial", Font.PLAIN, 18));
		jButton1.setBounds(new Rectangle(329, 48, 58, 44));
		jButton1.setText("<");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				it1Prev_actionPerformed(e);
			}
		});
		jTextField1.setFont(new Font("Arial", Font.PLAIN, 18));
		jTextField1.setText("Nothing");
		jTextField1.setBounds(new Rectangle(463, 55, 199, 30));
		jLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("ITERATOR 1");
		jLabel1.setBounds(new Rectangle(463, 33, 199, 22));
		jTextField2.setFont(new Font("Arial", Font.PLAIN, 18));
		jTextField2.setBounds(new Rectangle(463, 132, 199, 30));
		jTextField2.setText("Nothing");
		jButton2.setFont(new Font("Arial", Font.PLAIN, 18));
		jButton2.setText("<");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				it2Prev_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(329, 125, 58, 44));
		jLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
		jLabel2.setBounds(new Rectangle(463, 110, 199, 22));
		jLabel2.setText("ITERATOR 2");
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jButton3.setFont(new Font("Arial", Font.PLAIN, 18));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				it1Next_actionPerformed(e);
			}
		});
		jButton3.setText(">");
		jButton3.setBounds(new Rectangle(390, 48, 58, 44));
		jButton4.setFont(new Font("Arial", Font.PLAIN, 18));
		jButton4.setBounds(new Rectangle(390, 125, 58, 44));
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				it2Next_actionPerformed(e);
			}
		});
		jButton4.setText(">");
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);
		contentPane.add(jScrollPane1, null);
		contentPane.add(jButton3, null);
		contentPane.add(jTextField2, null);
		contentPane.add(jButton4, null);
		contentPane.add(jButton2, null);
		contentPane.add(jLabel2, null);
		contentPane.add(jTextField1, null);
		contentPane.add(jLabel1, null);
		contentPane.add(jButton1, null);
		jScrollPane1.setViewportView(jList1);
		this.setJMenuBar(jMenuBar1);
	}


	// File | Exit action performed
	public void jMenuFileExit_actionPerformed(ActionEvent e) {
		System.exit(0);
	}


	// Help | About action performed
	public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
	}


	// Overridden so we can exit when window is closed
	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			jMenuFileExit_actionPerformed(null);
		}
	}


	void it1Prev_actionPerformed(ActionEvent e) {

		if (it1.hasPrevious()) {
			jTextField1.setText(it1.previous());
			jList1.setSelectedValue(jTextField1.getText(), true);
			jList1.setSelectionBackground(it1Color);
		}
	}


	void it2Prev_actionPerformed(ActionEvent e) {

		if (it2.hasPrevious()) {
			jTextField2.setText(it2.previous());
			jList1.setSelectedValue(jTextField2.getText(), true);
			jList1.setSelectionBackground(it2Color);
		}
	}


	void it1Next_actionPerformed(ActionEvent e) {

		if (it1.hasNext()) {
			jTextField1.setText(it1.next());
			jList1.setSelectedValue(jTextField1.getText(), true);
			jList1.setSelectionBackground(it1Color);
		}
	}


	void it2Next_actionPerformed(ActionEvent e) {

		if (it2.hasNext()) {
			jTextField2.setText(it2.next());
			jList1.setSelectedValue(jTextField2.getText(), true);
			jList1.setSelectionBackground(it2Color);
		}
	}
}
