package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class TestCloneable {
    @Test
    public void testSavingAccount() {
        SavingAccount savingAccount = new SavingAccount(1, 1000.0);
        SavingAccount savingAccountClone = (SavingAccount) savingAccount.clone();

        savingAccountClone.setBalance(1100);

        assertNotSame(savingAccount.getBalance(), savingAccountClone.getBalance());
        assertSame(savingAccount.getId(), savingAccountClone.getId());
        assertSame(savingAccount.getCurrency(), savingAccountClone.getCurrency());
    }

    @Test
    public void testCheckingAccount() {
        CheckingAccount checkingAccount = new CheckingAccount(1, 1000.0, 100);
        CheckingAccount checkingAccountClone = (CheckingAccount) checkingAccount.clone();

        checkingAccountClone.setBalance(1100);
        checkingAccountClone.setOverdraft(50);

        assertNotSame(checkingAccount.getBalance(), checkingAccountClone.getBalance());
        assertNotSame(checkingAccount.getOverdraft(), checkingAccountClone.getOverdraft());
        assertSame(checkingAccount.getId(), checkingAccountClone.getId());
        assertSame(checkingAccount.getCurrency(), checkingAccountClone.getCurrency());
    }
}
