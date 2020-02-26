package edu.sbcc.cs165;

import static sbcc.Core.*;

public class Director extends Employee {

	public Director(int maxApprovalAmount, Employee supervisor) {
		super(maxApprovalAmount, supervisor);
	}


	@Override
	public void processPurchaseRequest(PurchaseRequest request) {

		if (request.getAmount() <= maxApprovalAmount)
			println("Director:  It seems like my only job at this company is approving $" + request.getAmount()
					+ " requests.  Request approved!.");

		else if (supervisor != null) {
			println("Director:  Forwarding request.");
			supervisor.processPurchaseRequest(request);
		}
	}

}
