package com.pateluday07.microservicies.v2.forex_converter_service.feign;

import com.pateluday07.microservicies.v2.forex_converter_service.dto.CurrencyConverterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("forex-rates-service")
public interface ExchangeRatesFeignService {

  @GetMapping("/api/exchange-rates/from/{from}/to/{to}")
  CurrencyConverterDto getExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);

}
