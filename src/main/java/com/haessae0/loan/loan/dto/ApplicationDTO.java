package com.haessae0.loan.loan.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ApplicationDTO implements Serializable {
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  @Setter
  public static class Request {

    private String name;
    private String phoneNo;
    private String email;
    private BigDecimal hopeAmt;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  @Setter
  public static class Response {

    private Long ApplicationId;
    private String name;
    private String phoneNo;
    private String email;
    private BigDecimal hopeAmt;
    private LocalDateTime applDt;
    private LocalDateTime instDt;
    private LocalDateTime updtDt;
  }
}
