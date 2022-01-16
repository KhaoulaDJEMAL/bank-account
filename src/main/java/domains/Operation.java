package domains;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.UUID;

@Data
public class Operation {

    private Long id;

    private LocalDateTime date;

    private BigDecimal montant;

    public Operation(LocalDateTime date, BigDecimal montant) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.date = date;
        this.montant = montant;
    }
}
