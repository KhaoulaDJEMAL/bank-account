package services;

import domains.Account;
import exceptions.OperationException;

import java.math.BigDecimal;

public interface AccountService {

    Account withdraw(final Account account, final BigDecimal amount) throws OperationException;
    Account deposit(final Account account, final BigDecimal amount) throws OperationException;

    void showHistory(Account account);

}
