package com.luxoft.bankapp.exceptions;

public class OverdraftLimitExceededException extends NotEnoughFundsException {
	private final double overdraft;

	public OverdraftLimitExceededException(NotEnoughFundsException e, double overdraft) {
		super(e.getMessage());
		this.id = e.getId();
	    this.balance = e.getBalance();
	    this.amount = Math.round(getAmount() * 100) / 100d;
        this.overdraft = overdraft;
    }
	
	public double getOverdraft() {
		return overdraft;
	}
}
