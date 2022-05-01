package lesson45.service.impl;

import lesson45.generator.CardNumberGenerator;
import lesson45.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardNumberGenerator cardNumberGenerator;

    @Override
    public String generateCardNumber() {
        return cardNumberGenerator.generate();
    }
}
