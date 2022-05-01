package lesson45.service;

import lesson45.dto.ProcessingDto;

import java.math.BigDecimal;

public interface ProcessingService {

    ProcessingDto issueCard(Long accountId);
    void spendMoney(String cardNumber, BigDecimal sum);
    ProcessingDto getProcessing(Long accountId);
}
