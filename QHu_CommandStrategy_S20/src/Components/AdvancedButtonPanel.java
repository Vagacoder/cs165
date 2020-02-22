package Components;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class AdvancedButtonPanel extends JPanel {

  private static final long serialVersionUID = 3565557751488244211L;
  
  private Processor processor;
  private ArrayList<JButton> advBtnList;

  public AdvancedButtonPanel(Processor processor) {
    this.processor = processor;
    this.advBtnList = new ArrayList<>();
    this.setLayout(new FlowLayout());
    this.setSize(430, 125);
    this.setBackground(Color.LIGHT_GRAY);

    addAdvButtons();

  }

  private void addAdvButtons() {
    File advComFolder = new File("src/Commands/AdvancedCommands");
    File[] advComFiles = advComFolder.listFiles();
    Arrays.sort(advComFiles);

    for (int i = 0; i < advComFiles.length; i++) {
      File currentFile = advComFiles[i];
      if (currentFile.isFile()) {
        String advComName = currentFile.getName().replace("Command.java", "");
        String advBtnName = getBtnName(advComName);
        var btn = new JButton(advBtnName);
        btn.addActionListener((ActionEvent e)->{
          do_advOneOperandBtn_actionPerformed(advComName);
        });
        this.advBtnList.add(btn);
        this.add(btn);
      }
    }

  }

  private String getBtnName(String comName){
    String result = comName;

    if(comName.equals("Reciprocal")){
      return "1/x";
    } else if (comName.equals("Square")){
      return "x\u00b2";
    } else if( comName.equals("Sqrt")){
      return "\u221Ax";
    }

    return result;
  }


  protected void do_advOneOperandBtn_actionPerformed(String advComName) {
    System.out.println(advComName + " clicked");
    this.processor.executeAdvOneOperandCommand(advComName);
  }

}