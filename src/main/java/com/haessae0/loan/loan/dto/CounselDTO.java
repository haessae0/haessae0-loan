package com.haessae0.loan.loan.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CounselDTO {

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Builder
  public static class Request {
    private String name;

    private String phoneNo;

    private String email;

    private String memo;

    private String addr;

    private String addrDtl;

    private String zipCode;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @Builder
  public static class Response {
    private Long counselId;

    private String name;

    private String phoneNo;

    private String email;

    private String memo;

    private String addr;

    private String addrDtl;

    private String zipCode;

    private LocalDateTime applDt;

    private LocalDateTime instDt;

    private LocalDateTime updtDt;
  }

}
