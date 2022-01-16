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



    @BeforeAll
    public void init() {
        account = new Account(BigDecimal.ZERO, LocalDateTime.now());
    }

    @Test
    @Order(1)
    @DisplayName("In order to save money As a bank client I want to make a deposit in my account")
    public void depositMoneyAccount() {
        BigDecimal amount = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT);
        accountService.deposit(account, amount);

        Assertions.assertEquals(amount, account.getBalance());
    }

    @Test
    @Order(2)
    @DisplayName("deposit neagtif amount is not permitted")
    public void depositMoneyAccount_negatifAmount() {
        BigDecimal amount = BigDecimal.valueOf(-DEPOSIT_WTIHDRAW_AMOUNT);
        accountService.deposit(account, amount);

        Assertions.assertThrows(OperationException.class, () ->{
            accountService.deposit(account, amount);
                }
        );
    }

    @Test
    @Order(3)
    @DisplayName("In order to retrieve some or all of my savings As a bank client I want to make a withdrawal from my account")
    public void withdrawMoneyAccount() {
        BigDecimal amountToRetrieve = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT);
        accountService.withdraw(account, amountToRetrieve);

        Assertions.assertEquals(amountToRetrieve, account.getBalance());

    }


    @Test
    @Order(4)
    @DisplayName("Withdraw with insufficient balance is not permitted")
    public void withdrawMoneyAccount_Insufficientbalance() {
        BigDecimal amountToRetrieve = BigDecimal.valueOf(DEPOSIT_WTIHDRAW_AMOUNT);
        Assertions.assertThrows(OperationException.class, () ->{
            accountService.withdraw(account, amountToRetrieve);
                }
        );

    }


    @Test
    @Order(5)
    @DisplayName("In order to check my operations As a bank client I want to see the history (operation, date, amount, balance) of my operations")
     public void showOperationsHistory() {

    }


}