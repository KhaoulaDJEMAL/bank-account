package services.impl;

import domains.Account;
import domains.Operation;
import domains.OperationType;
import exceptions.OperationException;

import lombok.extern.slf4j.Slf4j;
import services.AccountService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
public class AccountServiceImpl implements AccountService {
    @Override
    public Account withdraw(final Account account, final BigDecimal amount) throws OperationException {

        if (BigDecimal.ZERO.compareTo(amount) >= 0 ) {

            log.info("amount  {} must be positif !", amount);
            throw new OperationException("amount must be positif...");
        }else if(insufficientBalance(account, amount)) {
            throw new OperationException("Insufficient Balance...");
        }
        else {

        }
        final Operation op = new Operation(amount.negate(), LocalDateTime.now(), OperationType.WITHDRAW);
        account.addOperation(op);
        op.setCurrentBalance(account.getBalance());
        return account;

    }



    @Override
    public Account deposit(final Account account, final BigDecimal amount) throws OperationException {

        // amount must be postif
        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            log.info("amount  {} must be positif !", amount);
            throw new OperationException("amount must be positif...");
        }
        final Operation op = new Operation(amount, LocalDateTime.now(), OperationType.DEPOSIT);

        account.addOperation(op);
        // Update balance at the operation level for historisation
        op.setCurrentBalance(account.getBalance());
        return account;
    }

    @Override
    public void showHistory(Account account) {
        log.info( "balance : {} €", account.getBalance());

        account.getListOperation().forEach(op -> log.info(op.toString()));

    }

    private boolean insufficientBalance(Account account, BigDecimal amount) {

        return account.getBalance().compareTo(amount) < 0;
    }

}
