package lesson34.controller;

import lesson34.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    @GetMapping
    public List<AccountDto> accounts() {
        return List.of();
    }

    @GetMapping({"/{id}", "/bi-id/{id}"})
    public AccountDto getById(@PathVariable Integer id,
                              @RequestHeader("Accept-encoding") String encoding) {
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        if (new Random().nextBoolean()) throw new IllegalArgumentException();
        return new AccountDto();
    }

    @PutMapping
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {

    }
}
