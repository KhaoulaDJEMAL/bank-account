package domains;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

@Data
public class Account {
    private long accountId;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private List<Operation> listOperation;

    public Account(BigDecimal balance, LocalDateTime creationDate) {
        this.accountId = UUID.randomUUID().getMostSignificantBits();
        this.balance = balance;
        this.creationDate = creationDate;
    }
}
