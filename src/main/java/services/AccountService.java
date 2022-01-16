package services;

import domains.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account withdraw(Account account, BigDecimal amount) ;
    Account deposit(Account account, BigDecimal amount);

    void showHistory(Account account);

}
