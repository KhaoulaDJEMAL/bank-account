package domains;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Account {
    private long accountId;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private List<Operation> listOperation = new ArrayList<Operation>();

    public Account(BigDecimal balance, LocalDateTime creationDate) {
        this.accountId = UUID.randomUUID().getMostSignificantBits();
        final Operation op  = new Operation(balance, creationDate, OperationType.DEPOSIT);
        addOperation(op);
        op.setCurrentBalance(getBalance());
        this.creationDate = creationDate;
    }

    public void addOperation(Operation op){
        this.listOperation.add(op);
    }

    public BigDecimal getBalance(){

        this.balance = listOperation.stream().map(Operation::getMontant).reduce(BigDecimal.ZERO,
                BigDecimal::add);
        return balance;
    }
}
