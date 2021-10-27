package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.domain.AccountCache;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import com.luxoft.bankapp.factory.AccountFactory;
import com.luxoft.bankapp.factory.AccountType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAccountCache {
    @Test
    public void testSavingAccount() {
        Account savingAccount = AccountCache.createAccount(AccountType.SAVING);
        assertThat(savingAccount, instanceOf(SavingAccount.class));
    }

    @Test
    public void testCheckingAccount() {
        Account checkingAccount = AccountCache.createAccount(AccountType.CHECKING);
        assertThat(checkingAccount, instanceOf(CheckingAccount.class));
    }
}
