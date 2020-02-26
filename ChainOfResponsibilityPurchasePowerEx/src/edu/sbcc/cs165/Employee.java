package edu.sbcc.cs165;

import static sbcc.Core.*;

public abstract class Employee {

	protected int maxApprovalAmount = 0;

	protected Employee supervisor;

	public Employee(int maxApprovalAmount, Employee supervisor) {
		this.maxApprovalAmount = maxApprovalAmount;
		this.supervisor = supervisor;
	}


	public void processPurchaseRequest(PurchaseRequest request) {

		if (request.getAmount() <= maxApprovalAmount)
			println(getClass().getSimpleName() + ": approves your $" + request.getAmount() + " request.");

		else if (supervisor != null) {
			println(getClass().getSimpleName() + ":  Forwarding request.");
			supervisor.processPurchaseRequest(request);
		}
	}

}
