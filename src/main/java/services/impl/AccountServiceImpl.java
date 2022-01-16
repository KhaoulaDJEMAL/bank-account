package services.impl;

import domains.Account;
import lombok.extern.slf4j.Slf4j;
import services.AccountService;

import java.math.BigDecimal;

@Slf4j
public class AccountServiceImpl implements AccountService {
    @Override
    public Account withdraw(Account account, BigDecimal amount) {
        return null;
    }

    @Override
    public Account deposit(Account account, BigDecimal amount) {
        return null;
    }

    @Override
    public void showHistory(Account account) {

    }

}
