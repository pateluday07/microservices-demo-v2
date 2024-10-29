package com.pateluday07.microservicies.v2.forex_converter_service.service;


import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;
import com.pateluday07.microservicies.v2.forex_converter_service.feign.ExchangeRatesFeignService;
import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Log4j2
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    @Value("${server.port}")
    private Integer port;

    private final ExchangeRatesFeignService exchangeRatesFeignService;

    @Override
    @Retry(name = "convert", fallbackMethod = "fallBackConverter")
    public CurrencyConverterDto convert(String from, String to, BigDecimal amount) {
        log.info("Converting {} To {} For The Amount {}", from, to, amount);
        CurrencyConverterDto converterDto = exchangeRatesFeignService.getExchangeRate(from, to);
        log.info("Got Exchange Rate From The Forex Service {}", converterDto);
        converterDto.setAmount(amount);
        converterDto.setPort(port);
        converterDto.setConvertedAmount(amount.multiply(converterDto.getRate()));
        return converterDto;
    }

    private CurrencyConverterDto fallBackConverter(String from, String to, BigDecimal amount, Throwable cause) {
        if (cause instanceof FeignException feignException && HttpStatus.NOT_FOUND.value() == feignException.status()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry The Conversion Rate Is Not Available For "
                    .concat(from).concat(" To ").concat(to).concat(" So We Can Not Provide The Converted Amount"), cause);
        }
        CurrencyConverterDto converterDto = new CurrencyConverterDto();
        converterDto.setFrom(from);
        converterDto.setTo(to);
        converterDto.setAmount(amount);
        converterDto.setPort(port);
        converterDto.setMessage("Sorry The Forex Rates Service IS Not Available At The Moment");
        return converterDto;
    }

}
