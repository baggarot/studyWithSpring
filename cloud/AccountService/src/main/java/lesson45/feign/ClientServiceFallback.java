package lesson45.feign;

import lesson45.feign.dto.ClientDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientServiceFallback implements ClientServiceClient {

    @Override
    public Optional<ClientDto> findById(Long id) {
        return Optional.empty();
    }
}
