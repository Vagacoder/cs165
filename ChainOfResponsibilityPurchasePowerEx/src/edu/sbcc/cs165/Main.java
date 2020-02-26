package edu.sbcc.cs165;

import static sbcc.Core.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		// Create employees and the chain of command
		var president = new President(20000, null);
		var vp = new VicePresident(10000, president);
		var director = new Director(2000, vp);
		var manager = new Manager(1000, director);

		boolean done = false;

		while (!done) {
			println("\n\nEnter the purchase order amount:  ");
			print("> ");
			int a = parseInt(readLine());
			if (a > 0)
				manager.processPurchaseRequest(new PurchaseRequest(0, a, "General"));
			else
				done = true;
		}

	}

}
