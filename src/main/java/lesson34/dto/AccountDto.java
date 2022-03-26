package lesson34.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private long id;
    private String owner;
    private BigDecimal balance;
}
