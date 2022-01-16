package domains;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.UUID;

@Data
public class Operation {

    private Long id;

    private LocalDateTime date;

    private BigDecimal montant;
    private OperationType operationType;
    private BigDecimal currentBalance;

    public Operation(BigDecimal amount, LocalDateTime operationDate, OperationType operationType) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.date = operationDate;
        this.montant = amount;
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Operation{");
        sb.append(", operationType=").append(operationType);
        sb.append("date=").append(date);
        sb.append(", montant=").append(montant);
        sb.append(", currentBalance=").append(currentBalance);
        sb.append('}');
        return sb.toString();
    }
}
