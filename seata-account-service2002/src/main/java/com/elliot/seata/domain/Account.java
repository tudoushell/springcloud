package com.elliot.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author happy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
  private Long id;
  private Long userId;
  private BigDecimal total;
  private BigDecimal used;
  private BigDecimal residue;
}
