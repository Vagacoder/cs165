package edu.sbcc.cs165;

public class PurchaseRequest {

	private int number;

	private int amount;

	private String purpose;


	public PurchaseRequest(int number, int amount, String purpose) {
		this.number = number;
		this.amount = amount;
		this.purpose = purpose;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amt) {
		amount = amt;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String reason) {
		purpose = reason;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int num) {
		number = num;
	}

}
