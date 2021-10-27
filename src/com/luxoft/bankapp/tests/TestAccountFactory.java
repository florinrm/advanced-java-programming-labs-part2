package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import com.luxoft.bankapp.factory.AccountFactory;
import com.luxoft.bankapp.factory.AccountType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAccountFactory {

    @Test
    public void testSavingAccount() {
        Account savingAccount = AccountFactory.createNewAccount(AccountType.SAVING, 1, 1000);
        assertThat(savingAccount, instanceOf(SavingAccount.class));
    }

    @Test
    public void testCheckingAccount() {
        Account checkingAccount = AccountFactory.createNewAccount(AccountType.CHECKING, 1, 1000);
        assertThat(checkingAccount, instanceOf(CheckingAccount.class));
    }
}
