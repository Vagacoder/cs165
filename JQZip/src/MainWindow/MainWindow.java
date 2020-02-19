package MainWindow;

/*
* CS165 Assignment #2: Command & Strategy Patterns

Plan B:
Create a utility program that allows the user to select an input file as well as 
a format for output. 

Output formats include, at a minimum, ZIP, GZIP, and one other 
of your choice (e.g. Jar, Tar, PGP-encrypted, etc.). When the user selects the 
save option, the specified file is output in the specified format. 

Use the Strategy design pattern to encapsulate each file-saving algorithm in 
separate classes that implement a common interface. 

The interface does not need to be fancy, perhaps it just declares one method, say 

    * public void write(String filename, byte[] data);

Verify that your program is working properly by opening your output files in another 
program (e.g. WinRar, which can read most of these formats).  One library you might 
want to consider using is the Apache Commons Compress library, which can handle 
many different compression formats.


SRS: 
1. GUI for software, using Swing; 
1.1. GUI for select input file;
1.2. GUI for select output file;
1.3. GUI for select format;
2. Support multiple output file formats
3. Providing compression and decompression options
4. ...

Task: 
1. finishe UML diagram ... done
2. skeleton the components ... done
3. implement algorithm and Strategy pattern ... done
4. GUI

*/

import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = -4165550345543619074L;
    private File selectedFile;
    private JLabel fileInfo;
    private JLabel messageLabel;
    private JButton openBtn;
    private JButton saveBtn;
    private JFileChooser fileChooser;
    private CompressionManager manager;
    private String algorithm;
    private ArrayList<JRadioButton> compressBtns;

    public MainWindow() {

        this.selectedFile = null;
        this.fileInfo = new JLabel("No file selected");
        this.messageLabel = new JLabel("Please select a file");
        this.fileChooser = new JFileChooser();
        this.manager = new CompressionManager();
        this.algorithm = "";

        // main frame
        Container mainPane = this.getContentPane();
        mainPane.setLayout(new FlowLayout());
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
        rootPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(""),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        rootPanel.setPreferredSize(new Dimension(580,360));
        mainPane.add(rootPanel);

        // Panel of open file (top panel)
        JPanel openFilePanel = new JPanel();
        openFilePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Step 1: Choose a file"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        rootPanel.add(openFilePanel);
        this.openBtn = new JButton("Open a File");
        openBtn.addActionListener(this);
        this.fileInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
        openFilePanel.add(openBtn);
        openFilePanel.add(this.fileInfo);

        // Panel of compression algorithm
        JPanel algoPanel = new JPanel();
        algoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Step 2: Select a compression formart"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        rootPanel.add(algoPanel);
        
        // set radio button of compression algorithms
        this.compressBtns = new ArrayList<>();
        ButtonGroup compressBtnGroup = new ButtonGroup();
        File algoFolder = new File("src/Compressor");
        File[] algoFiles = algoFolder.listFiles();
        Arrays.sort(algoFiles);

        for (int i = 0; i < algoFiles.length; i++){
            String algoName = algoFiles[i].getName().replace("Compressor.java", "");
            if(!algoName.equals("I") && !algoName.equals("No")){
                var btn = new JRadioButton(algoName);
                this.compressBtns.add(btn);
                compressBtnGroup.add(btn);
                algoPanel.add(btn);
                if(this.compressBtns.size() == 1){
                    btn.setSelected(true);
                }
            }
        }

        // Panel of save file
        JPanel saveFilePanel = new JPanel();
        saveFilePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Step 3: Save compressed file"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        rootPanel.add(saveFilePanel);
        this.saveBtn = new JButton("Compress a File");
        this.saveBtn.setEnabled(false);
        saveBtn.addActionListener(this);
        saveFilePanel.add(saveBtn);

        // Panel of system log
        JPanel systemInfoPanel = new JPanel();
        systemInfoPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("System Log"),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        rootPanel.add(systemInfoPanel);
        systemInfoPanel.add(this.messageLabel);

        this.setTitle("JQZip");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object target = event.getSource();
        if (target == this.openBtn) {
            int result = this.fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                this.selectedFile = this.fileChooser.getSelectedFile();
                String filePath = this.selectedFile.getPath();
                this.fileInfo.setText(filePath);
                this.messageLabel.setText(filePath + " is selected");
                this.saveBtn.setEnabled(true);
            } else {
                this.selectedFile = null;
                this.fileInfo.setText("No file selected");
                this.messageLabel.setText("Cancelled by user");
                this.saveBtn.setEnabled(false);
            }

        } else if (target == this.saveBtn) {
            for(var btn : this.compressBtns){
                if (btn.isSelected()){
                    this.algorithm = btn.getText();
                }
            }

            try {
                byte[] data = Files.readAllBytes(this.selectedFile.toPath());
                try {
                    manager.setCompressAlogrithm(this.algorithm);
                    try {
                        manager.write(this.selectedFile.getPath(), data);
                        String fileExtension;
                        if(this.algorithm.equals("GZip")){
                            fileExtension = ".gz";
                        } else if (this.algorithm.equals("Bzip2")){
                            fileExtension = ".bz2";
                        } else {
                            fileExtension = "." + algorithm.toLowerCase();
                        }
                        this.messageLabel.setText(this.selectedFile.getName() +  
                            fileExtension + " is succeessfully saved");
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.messageLabel.setText("Failed to write compressed file");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    this.messageLabel.setText("Selected compression method does not exists.");
                }

            } catch (Exception e) {
                this.messageLabel.setText("Failed to read original file");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });


        // ! No GUI part, for testing only
        // String message = "";
        // CompressionManager manager = new CompressionManager();
        // File infile = new File("red.bmp");
        // // File infile = new File("CS137Addresses.csv");
        // byte[] data = Files.readAllBytes(infile.toPath());

        // try {
        // manager.setCompressAlogrithm("Jar");
        // try {
        // manager.write(infile.getName(), data);
        // } catch (Exception e) {
        // e.printStackTrace();
        // message = "Fail to write compressed file";
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // message = "Selected compression method does not exists.";
        // }
    }

}
