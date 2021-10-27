package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.Account;
import com.luxoft.bankapp.domain.AccountCache;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import com.luxoft.bankapp.factory.AccountType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestAccountCache {
    @Test
    public void testSavingAccount() {
        AccountCache.loadCache();
        Account savingAccount = AccountCache.createAccount(AccountType.SAVING);
        assertThat(savingAccount, instanceOf(SavingAccount.class));
        assertEquals(savingAccount.getBalance(), 0.0, 0);
        assertEquals(savingAccount.getId(), 0);
    }

    @Test
    public void testCheckingAccount() {
        AccountCache.loadCache();
        Account checkingAccount = AccountCache.createAccount(AccountType.CHECKING);
        assertThat(checkingAccount, instanceOf(CheckingAccount.class));
        assertEquals(checkingAccount.getBalance(), 0.0, 0);
        assertEquals(checkingAccount.getId(), 0);
        assertEquals(((CheckingAccount) checkingAccount).getOverdraft(), 0.0, 0);
    }
}
