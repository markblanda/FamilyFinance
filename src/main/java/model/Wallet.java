package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Wallet {
    private final List<AccountRegister> accountRegisterList;

    public Wallet() {
        accountRegisterList = new ArrayList<>();
    }

    public Collection<AccountRegister> getAccounts() {
        return accountRegisterList;
    }

    public void addAccount(AccountRegister accountRegister) {
        accountRegisterList.add(accountRegister);
    }

    public void deleteAccount(int accountIndex) {
        accountRegisterList.remove(accountIndex);
    }
}
