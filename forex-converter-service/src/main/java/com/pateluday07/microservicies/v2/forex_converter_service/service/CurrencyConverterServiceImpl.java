package com.pateluday07.microservicies.v2.forex_converter_service.service;


import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;
import com.pateluday07.microservicies.v2.forex_converter_service.feign.ExchangeRatesFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Log4j2
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

  @Value("${server.port}")
  private Integer port;

  private final ExchangeRatesFeignService exchangeRatesFeignService;

  @Override
  public CurrencyConverterDto convert(String from, String to, BigDecimal amount) {
    log.info("Converting {} To {} For The Amount {}", from, to, amount);
    CurrencyConverterDto converterDto = exchangeRatesFeignService.getExchangeRate(from, to);
    log.info("Got Exchange Rate From The Forex Service {}", converterDto);
    converterDto.setAmount(amount);
    converterDto.setPort(port);
    converterDto.setConvertedAmount(amount.multiply(converterDto.getRate()));
    return converterDto;
  }

}
