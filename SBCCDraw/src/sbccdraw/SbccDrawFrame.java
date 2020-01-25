package sbccdraw;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import sbccdraw.drawshapes.*;

/**
 * SBCCDrawFrame is the main window (frame) for the app. It handles menu and toolbar interaction. DrawPanel handles
 * interaction related to drawing on the canvas.
 */

public class SbccDrawFrame extends JFrame implements DrawShapeNamesChangedListener {

	DrawShapeFactory shapeFactory;

	Color fillColor = Color.white;

	Color borderColor = Color.black;

	JPanel contentPane;

	JMenuBar jMenuBar1 = new JMenuBar();

	JMenu jMenuFile = new JMenu();

	JMenuItem jMenuFileExit = new JMenuItem();

	JMenu jMenuHelp = new JMenu();

	JMenuItem jMenuHelpAbout = new JMenuItem();

	JToolBar jToolBar = new JToolBar();

	JLabel statusBar = new JLabel();

	BorderLayout borderLayout1 = new BorderLayout();

	DrawPanel drawPanel = new DrawPanel();

	Border border1;

	Border border2;

	JButton btnClear = new JButton();

	JComboBox cmbShape;

	JPanel jPanel1 = new JPanel();

	JButton btnFillColor = new JButton();

	JButton btnBorderColor = new JButton();

	JCheckBox chkFilled = new JCheckBox();

	JColorChooser fillColorChooser = new JColorChooser();

	JColorChooser borderColorChooser = new JColorChooser();


	// Init and build the frame
	public SbccDrawFrame() {

		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			shapeFactory = new DrawShapeFactory();
			shapeFactory.addDrawShapeNamesChangedListener(this);

			jbInit();
			getPrefs();
			drawPanel.setBorder(border1);
			drawPanel.setBorderColor(borderColor);
			drawPanel.setFillColor(fillColor);
			drawPanel.setFilled(chkFilled.isSelected());
			drawPanel.setShapeFactory(shapeFactory);
			drawPanel.setDrawShapeName((String) cmbShape.getSelectedItem());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Component initialization
	private void jbInit() throws Exception {

		// Load properties
		contentPane = (JPanel) this.getContentPane();
		border1 = BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(142,
				142, 142)), BorderFactory.createEmptyBorder(2, 2, 2, 2));
		border2 = BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(Color.white, new Color(142, 142, 142)),
				BorderFactory.createEmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(513, 390));
		this.setTitle("SBCC DRAW!");
		statusBar.setText(" ");
		jMenuFile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		jMenuFile.setBorder(new EmptyBorder(4, 4, 4, 4));

		jMenuFile.setText("FILE");
		jMenuFileExit.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		jMenuFileExit.setText("EXIT");
		jMenuFileExit.setBorder(new EmptyBorder(4, 4, 4, 4));
		jMenuFileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuFileExit_actionPerformed(e);
			}
		});
		jMenuHelp.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		jMenuHelp.setText("HELP");
		jMenuHelpAbout.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		jMenuHelpAbout.setText("ABOUT");
		jMenuHelpAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuHelpAbout_actionPerformed(e);
			}
		});
		jToolBar.setBorder(new EmptyBorder(4, 4, 4, 4));
		btnClear.setBorder(new EmptyBorder(4, 4, 4, 4));
		btnClear.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnClear.setMaximumSize(new Dimension(100, 40));
		btnClear.setMinimumSize(new Dimension(50, 23));
		btnClear.setPreferredSize(new Dimension(100, 40));
		btnClear.setText("CLEAR");
		btnClear.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnClear_actionPerformed(e);
			}
		});

		cmbShape = new JComboBox(
				shapeFactory.getDrawShapeNames()
						.toArray());
		cmbShape.setBorder(new EmptyBorder(4, 4, 4, 4));
		cmbShape.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		cmbShape.setMaximumSize(new Dimension(32767, 40));
		cmbShape.setMinimumSize(new Dimension(60, 40));
		cmbShape.setPreferredSize(new Dimension(90, 40));
		cmbShape.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cmbShape_actionPerformed(e);
			}
		});
		chkFilled.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		chkFilled.setBorder(new EmptyBorder(8, 8, 8, 8));
		chkFilled.setSelected(true);
		chkFilled.setText("FILLED");
		chkFilled.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chkFilled_actionPerformed(e);
			}
		});
		btnFillColor.setBorder(new EmptyBorder(4, 4, 4, 4));
		btnFillColor.setBackground(fillColor);
		btnFillColor.setMaximumSize(new Dimension(40, 40));
		btnFillColor.setMinimumSize(new Dimension(24, 24));
		btnFillColor.setPreferredSize(new Dimension(40, 40));
		btnFillColor.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnFillColor_actionPerformed(e);
			}
		});

		btnBorderColor.setBorder(new EmptyBorder(4, 4, 4, 4));
		btnBorderColor.setBackground(borderColor);
		btnBorderColor.setMaximumSize(new Dimension(40, 40));
		btnBorderColor.setMinimumSize(new Dimension(24, 24));
		btnBorderColor.setPreferredSize(new Dimension(40, 40));
		btnBorderColor.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnBorderColor_actionPerformed(e);
			}
		});
		jToolBar.add(btnClear, null);
		jToolBar.add(cmbShape, null);
		jToolBar.add(chkFilled, null);
		jToolBar.add(btnFillColor, null);
		jToolBar.add(btnBorderColor, null);
		jPanel1.setBackground(SystemColor.window);
		jToolBar.add(jPanel1, null);
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenuHelp);
		this.setJMenuBar(jMenuBar1);
		contentPane.add(jToolBar, BorderLayout.NORTH);
		contentPane.add(statusBar, BorderLayout.SOUTH);
		contentPane.add(drawPanel, BorderLayout.CENTER);
	}


	// File | Exit action performed
	public void jMenuFileExit_actionPerformed(ActionEvent e) {
		savePrefs();
		try {
			shapeFactory.shutdown();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}


	// Help | About action performed
	public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
		SbccDrawFrameAboutBox dlg = new SbccDrawFrameAboutBox(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.setVisible(true);
	}


	// Overridden so we can exit when window is closed
	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			jMenuFileExit_actionPerformed(null);
		}
	}


	/**
	 * Save UI preferences
	 */
	private void savePrefs() {
		try {
			Properties props = new Properties();
			props.setProperty("width", String.valueOf(getWidth()));
			props.setProperty("height", String.valueOf(getHeight()));
			props.setProperty("left", String.valueOf(getLocation().x));
			props.setProperty("top", String.valueOf(getLocation().y));
			props.setProperty("bordercolor", String.valueOf(borderColor.getRGB()));
			props.setProperty("fillcolor", String.valueOf(fillColor.getRGB()));
			props.store(new FileOutputStream("SBCCDraw.ini"), "");
		} catch (Exception ex) {
		}
	}


	/**
	 * Load the UI preferences
	 */
	private void getPrefs() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("SBCCDraw.ini"));
			int w = Integer.parseInt(props.getProperty("width", "640"));
			int h = Integer.parseInt(props.getProperty("height", "480"));
			int left = Integer.parseInt(props.getProperty("left", "20"));
			int top = Integer.parseInt(props.getProperty("top", "100"));
			this.setBounds(left, top, w, h);
			setBorderColor(new Color(Integer.parseInt(props.getProperty("bordercolor", "0"))));
			setFillColor(new Color(Integer.parseInt(props.getProperty("fillcolor", "0"))));
		} catch (Exception ex) {
		}
	}


	void btnFillColor_actionPerformed(ActionEvent e) {
		setFillColor(JColorChooser.showDialog(this, "CHOOSE FILL COLOR", fillColor));
	}


	private void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
		btnFillColor.setBackground(fillColor);
		drawPanel.setFillColor(fillColor);
	}


	void btnBorderColor_actionPerformed(ActionEvent e) {
		setBorderColor(JColorChooser.showDialog(this, "CHOOSE BORDER COLOR", borderColor));
	}


	private void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		btnBorderColor.setBackground(borderColor);
		drawPanel.setBorderColor(borderColor);
	}


	void chkFilled_actionPerformed(ActionEvent e) {
		drawPanel.setFilled(chkFilled.isSelected());
	}


	void cmbShape_actionPerformed(ActionEvent e) {
		String shapeName = (String) ((JComboBox) e.getSource()).getSelectedItem();
		drawPanel.setDrawShapeName(shapeName);
	}


	void btnClear_actionPerformed(ActionEvent e) {
		drawPanel.clearPanel();
	}


	@Override
	public void shapeNamesChanged(ShapeNamesChangedEvent e) {
		ArrayList<String> drawShapeNames = shapeFactory.getDrawShapeNames();
		cmbShape.removeAllItems();
		for (String s : drawShapeNames)
			cmbShape.addItem(s);
		Color bgcolor = cmbShape.getBackground();
		cmbShape.setBackground(Color.GREEN);
		cmbShape.repaint();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		cmbShape.setBackground(bgcolor);
	}

}