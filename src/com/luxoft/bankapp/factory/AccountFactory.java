package com.luxoft.bankapp.factory;

import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;

public class AccountFactory {
    public static Account createNewAccount(AccountType accountType, int id, double amount) {
        if (accountType == null) {
            return null;
        }

        return switch (accountType) {
            case CHECKING -> new CheckingAccount(id, amount, 0);
            case SAVING -> new SavingAccount(id, amount);
        };
    }
}
