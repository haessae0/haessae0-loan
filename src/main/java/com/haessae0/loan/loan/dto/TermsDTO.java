package com.haessae0.loan.loan.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TermsDTO implements Serializable {
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  @Setter
  public static class Request {

    private String name;
    private String termsDtlUrl;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Getter
  @Setter
  public static class Response {

    private Long applicationId;
    private String name;
    private String termsDtlUrl;
    private LocalDateTime instDt;
    private LocalDateTime updtDt;
  }
}
