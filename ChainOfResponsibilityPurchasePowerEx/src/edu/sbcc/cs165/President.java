package edu.sbcc.cs165;

import static sbcc.Core.*;

public class President extends Employee {


	public President(int maxApprovalAmount, Employee supervisor) {
		super(maxApprovalAmount, supervisor);
	}


	@Override
	public void processPurchaseRequest(PurchaseRequest request) {

		if (request.getAmount() <= maxApprovalAmount)
			println("President:  Will approve the $" + request.getAmount() + " request after his nap.");
		else
			println("President:  Your request for $" + request.getAmount() + " needs a board meeting!");

	}
}
