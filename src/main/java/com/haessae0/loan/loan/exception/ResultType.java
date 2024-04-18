package com.haessae0.loan.loan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultType {

  SUCCESS("0000", "SUCCESS"),

  SYSTEM_ERROR("9000", "SYSTEM ERROR");

  private final String code;
  private final String desc;
}
