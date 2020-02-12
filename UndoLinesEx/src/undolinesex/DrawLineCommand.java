package undolinesex;

import java.awt.*;

import javax.swing.*;

public abstract class DrawLineCommand implements Command {

	int height;
	int x;

	public DrawLineCommand(int x, int height) {
		super();
		this.x = x;
		this.height = height;
	}


	@Override
	public void execute() {
	}


	public void execute(Graphics g) {
	}

}
