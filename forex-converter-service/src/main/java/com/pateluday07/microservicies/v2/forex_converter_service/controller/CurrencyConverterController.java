package com.pateluday07.microservicies.v2.forex_converter_service.controller;

import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;
import com.pateluday07.microservicies.v2.forex_converter_service.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/currency-converter")
@Log4j2
@RequiredArgsConstructor
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;


    @GetMapping("/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConverterDto convertedAmount(@PathVariable String from, @PathVariable String to,
                                                @PathVariable BigDecimal amount) {
        log.info("Converting {} To {} For The Amount {}", from, to, amount);
        return currencyConverterService.convert(from, to, amount);
    }

}
