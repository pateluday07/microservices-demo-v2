package com.pateluday07.microservicies.v2.forex_converter_service.controller;

import java.math.BigDecimal;

import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;
import com.pateluday07.microservicies.v2.forex_converter_service.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-converter")
@RequiredArgsConstructor
public class CurrencyConverterController {

  private final CurrencyConverterService currencyConverterService;

  @GetMapping("/from/{from}/to/{to}/amount/{amount}")
  public CurrencyConverterDto convertedAmount(@PathVariable String from, @PathVariable String to,
                                              @PathVariable BigDecimal amount) {
    return currencyConverterService.convert(from, to, amount);
  }
}
