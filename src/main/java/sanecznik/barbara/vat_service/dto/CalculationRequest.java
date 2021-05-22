package sanecznik.barbara.vat_service.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculationRequest {

    private Long id;
    private BigDecimal amount;
}
