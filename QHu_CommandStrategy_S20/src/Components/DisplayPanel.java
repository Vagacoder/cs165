package Components;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
    private JLabel resultLabel;

    public DisplayPanel(){



    }

    public void UpdateResultLabel(String content){
        this.resultLabel.setText(content);
    }


}