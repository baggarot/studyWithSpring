package lesson29.impl;

import lesson29.LocalizationService;
import lesson29.config.ApplicationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final MessageSource messageSource;
    private final Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource, ApplicationProperties applicationProperties) {
        this.messageSource = messageSource;
        this.locale = applicationProperties.getLocale();
    }

    @Override
    public String localize(String key, Object... vars) {
        return messageSource.getMessage(key, vars, locale);
    }
}
