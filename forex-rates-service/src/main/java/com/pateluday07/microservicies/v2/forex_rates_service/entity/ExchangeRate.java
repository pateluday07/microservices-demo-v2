package com.pateluday07.microservicies.v2.forex_rates_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExchangeRate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "currency_from", nullable = false)
  private String from;

  @Column(name = "currency_to", nullable = false)
  private String to;

  @Column(nullable = false)
  private BigDecimal rate;

  @Transient
  private Integer port;
}
