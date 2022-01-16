package services.impl;


import domains.Account;
import exceptions.OperationException;
import org.junit.jupiter.api.*;
import services.AccountService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImplTest {

    private static final int DEPOSIT_WTIHDRAW_AMOUNT = 500;
    private Account account;
    private AccountService accountService = new AccountServiceImpl();



    @BeforeEach
    public void init() {
        account = new Account(BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT), LocalDateTime.now());
    }

    @Test
    @Order(1)
    @DisplayName("In order to save money As a bank client I want to make a deposit in my account")
    public void depositMoneyAccount() throws OperationException {
        final BigDecimal amount = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT);
        final BigDecimal balance  = account.getBalance();
        accountService.deposit(account, amount);

        Assertions.assertEquals(amount.add(balance), account.getBalance());
    }

    @Test
    @Order(2)
    @DisplayName("deposit neagtif amount is not permitted")
    public void depositMoneyAccount_negatifAmount() throws OperationException {
        final BigDecimal amount = BigDecimal.valueOf(-DEPOSIT_WTIHDRAW_AMOUNT);

        Assertions.assertThrows(OperationException.class, () ->{
            accountService.deposit(account, amount);
                }
        );
    }

    @Test
    @Order(3)
    @DisplayName("In order to retrieve some or all of my savings As a bank client I want to make a withdrawal from my account")
    public void withdrawMoneyAccount() throws OperationException {
        final BigDecimal amountToRetrieve = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT);
        accountService.withdraw(account, amountToRetrieve);
        Assertions.assertEquals(BigDecimal.ZERO, account.getBalance());

    }


    @Test
    @Order(4)
    @DisplayName("Withdraw with insufficient balance is not permitted")
    public void withdrawMoneyAccount_Insufficientbalance() {
        final BigDecimal amountToRetrieve = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT*2);
        Assertions.assertThrows(OperationException.class, () ->{
            accountService.withdraw(account, amountToRetrieve);
                }
        );

    }


    @Test
    @Order(5)
    @DisplayName("In order to check my operations As a bank client I want to see the history (operation, date, amount, balance) of my operations")
     public void showOperationsHistory() throws OperationException {
        accountService.deposit(account, BigDecimal.TEN);
        accountService.withdraw(account, BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT));
        accountService.showHistory(account);
        Assertions.assertEquals(3, account.getListOperation().size());

    }

}