package jfreechartawtswtex;

import java.awt.*;
import java.lang.reflect.*;
import java.util.*;

import org.eclipse.swt.*;
import org.eclipse.swt.awt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import sun.misc.*;

public class MainWindow extends org.eclipse.swt.widgets.Composite {
	JFreeChart chart; // JFreeChart view
	ChartPanel chartPanel; // JFree panel to hold the chart
	DefaultCategoryDataset categoryDataset; // Data for the chart
	Random r = new Random(); // Random number generator
	private Menu menu1;
	private Button btnReplot;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	/**
	 * This GUI uses an SWT_AWT control, which is this group: chartComposite, frame1, and awtPanel
	 */
	private Panel awtPanel;
	private Frame frame1;
	private Composite chartComposite;

	private Menu fileMenu;

	private MenuItem fileMenuItem;

	public static void disableWarning() {
		try {
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			Unsafe u = (Unsafe) theUnsafe.get(null);

			Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
			Field logger = cls.getDeclaredField("logger");
			u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
		} catch (Exception e) {
			// ignore
		}
	}


	public static void main(String[] args) {
		disableWarning();
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		MainWindow inst = new MainWindow(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}


	/*
	 * Create the GUI and its chart
	 */
	public MainWindow(Composite parent, int style) {
		super(parent, style);
		initGUI();
		initChart();
	}


	/*
	 * Initialize the chart
	 */
	void initChart() {
		// Create an empty data set
		categoryDataset = new DefaultCategoryDataset();

		// Create a bar chart
		chart = ChartFactory.createBarChart3D("Balances", // Title
				"Accounts", // X-Axis label
				"Balance", // Y-Axis label
				categoryDataset, // Dataset
				PlotOrientation.VERTICAL, false, // Show legend
				true, true);
		chart.setAntiAlias(true);

		// Create random #'s for the data set
		updateCategoryDataset();

		// Create a JFree ChartPanel with a border layout
		chartPanel = new ChartPanel(chart);
		BorderLayout chartPanelLayout = new BorderLayout();
		chartPanel.setLayout(chartPanelLayout);

		// Add the ChartPanel to the SWT_AWT panel and give it a preferred (but not mandatory) size.
		awtPanel.add(chartPanel, BorderLayout.CENTER);
		chartPanel.setPreferredSize(new java.awt.Dimension(630, 437));
	}


	/*
	 * Create random #'s for the balances
	 */
	private void updateCategoryDataset() {
		categoryDataset.setValue(1000 * r.nextFloat(), "", "Savings");
		categoryDataset.setValue(1000 * r.nextFloat(), "", "Checking");
		categoryDataset.setValue(1000 * r.nextFloat(), "", "CD");
		categoryDataset.setValue(1000 * r.nextFloat(), "", "Extreme Checking");
	}


	/*
	 * Replot
	 */
	private void btnReplotWidgetSelected(SelectionEvent evt) {
		updateCategoryDataset();
	}


	/*
	 * Handle resize.
	 */
	private void rootControlResized(ControlEvent evt) {
		chartPanel.setBounds(0, 0, awtPanel.getWidth(), awtPanel.getHeight());
	}


	/*
	 * Handle exit menu
	 */
	private void exitMenuItemWidgetSelected(SelectionEvent evt) {
		getShell().dispose();
	}


	/**
	 * Initializes the GUI.
	 */
	private void initGUI() {
		try {
			this.setSize(640, 480);
			this.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
			GridLayout thisLayout = new GridLayout(1, true);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.setLayout(thisLayout);
			this.addControlListener(new ControlAdapter() {
				public void controlResized(ControlEvent evt) {
					rootControlResized(evt);
				}
			});
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("File");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							openFileMenuItem.setText("Open");
						}
						{
							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							newFileMenuItem.setText("New");
						}
						{
							saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							saveFileMenuItem.setText("Save");
						}
						{
							closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							closeFileMenuItem.setText("Close");
						}
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("Exit");
							exitMenuItem.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									exitMenuItemWidgetSelected(evt);
								}
							});
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							contentsMenuItem.setText("Contents");
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							{
								btnReplot = new Button(this, SWT.PUSH | SWT.CENTER);
								btnReplot.setText("Replot");
								btnReplot.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										btnReplotWidgetSelected(evt);
									}
								});
							}
							{
								GridData chartCompositeLData = new GridData();
								chartCompositeLData.grabExcessHorizontalSpace = true;
								chartCompositeLData.grabExcessVerticalSpace = true;
								chartCompositeLData.horizontalAlignment = GridData.FILL;
								chartCompositeLData.verticalAlignment = GridData.FILL;
								chartComposite = new Composite(this, SWT.EMBEDDED | SWT.BORDER);
								chartComposite.setLayoutData(chartCompositeLData);
								chartComposite.setBackground(SWTResourceManager.getColor(236, 233, 213));
								{
									frame1 = SWT_AWT.new_Frame(chartComposite);
									{
										awtPanel = new Panel();
										BorderLayout awtPanelLayout = new BorderLayout();
										awtPanel.setLayout(awtPanelLayout);
										frame1.add(awtPanel);
										frame1.setBackground(new java.awt.Color(236, 233, 213));
										awtPanel.setBackground(new java.awt.Color(236, 233, 213));
									}
								}
							}
							aboutMenuItem.setText("About");
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
