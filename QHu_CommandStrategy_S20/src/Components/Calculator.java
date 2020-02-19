package Components;

/*
* CS165 Assignment: Command and Strategy, Calculator

* SRS:
1. Must support at least +, -, *, /.
2. Commands that have been executed can be undone, with unlimited levels of undo.
3. The log maintains a list of commands that have been executed.
4. Must use the Command design pattern to support undo-ing and logging of operations.
5. Must be able to write the log to a file in the following formats: plain text 
    or XML (you choose the element names).
6. Must use the Strategy design pattern to encapsulate each log-file-saving algorithm 
    in separate classes that implement a common interface.

STARTER PROJECT:  
You are welcome to use the Swing-based CalculatorStarter project.  
It's got buttons and menu items with predefined event handlers.  
But note that this is just an option - you can use any framework or language you 
like as long as it meets the requirements described above.

* Task
1. UML ... done
2. Project skeleton ... 
3. GUI
4. Basic arithmetic command
5. Test
6. Extension of commands

*/


import javax.swing.JFrame;

public class Calculator  extends JFrame{

    private static final long serialVersionUID = -5368647850418930747L;






	public static void main(String[] args){

    }
}