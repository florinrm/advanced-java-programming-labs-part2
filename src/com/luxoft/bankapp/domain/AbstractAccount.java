package com.luxoft.bankapp.domain;

import java.io.Serializable;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.utils.Params;

public abstract class AbstractAccount implements Account, Serializable {
	public static final int SAVING_ACCOUNT_TYPE = 1;
	public static final int CHECKING_ACCOUNT_TYPE = 2;
	
	private final int id;
	private int type;

	public double balance;
	
	public AbstractAccount(int id, double amount) {
		this.id = id;
		this.balance = amount;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void deposit(final double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	@Override
	public void withdraw(final double amount) throws NotEnoughFundsException {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		
		if (amount > maximumAmountToWithdraw()) {
			throw new NotEnoughFundsException(id, balance, amount, "Requested amount exceeds the maximum amount to withdraw");
		}
		
		this.balance -= amount;
	}
	
	public double maximumAmountToWithdraw(){
		switch (type) {
		   case SAVING_ACCOUNT_TYPE:
			   return balance;
		   case CHECKING_ACCOUNT_TYPE:
			   CheckingAccount checkingAccount = (CheckingAccount)this;
			  return checkingAccount.balance + checkingAccount.overdraft;
		}
		
        return 0;
    }

	@Override
	public int getId() {
		return id;
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
    public long decimalValue(){
        return Math.round(balance);
    }

	public AbstractAccount setBalance(double balance) {
		this.balance = balance;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractAccount other = (AbstractAccount) obj;
		return id == other.id;
	}
	
	public static Account parse(Params params) {

		return switch (params.get("accountType")) {
			case "s" -> SavingAccount.parse(params);
			case "c" -> CheckingAccount.parse(params);
			default -> null;
		};

	}

}
