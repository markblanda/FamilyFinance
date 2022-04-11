package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalletTests {
    private Wallet userWallet;

    @Before
    public void init() {
        userWallet = new Wallet();
    }

    @Test
    public void createWalletWithAccount() {
        assertEquals(0, userWallet.getAccounts().size());
        userWallet.addAccount(new AccountRegister("Checking", AccountRegister.AccountType.CHECKING));
        assertEquals(1, userWallet.getAccounts().size());
    }

    @Test
    public void voidDeleteAccountFromWallet() {
        userWallet.addAccount(new AccountRegister("Checking", AccountRegister.AccountType.CHECKING));
        userWallet.deleteAccount(0);
    }
}
