package com.luxoft.bankapp.factory;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;

public class AccountFactory {
    public static AbstractAccount createNewAccount(AccountType accountType) {
        if (accountType == null) {
            return null;
        }

        return switch (accountType) {
            case CHECKING -> new CheckingAccount(0, 0, 0);
            case SAVING -> new SavingAccount(0, 0);
        };
    }
}
