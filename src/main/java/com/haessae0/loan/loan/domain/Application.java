package com.haessae0.loan.loan.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Application extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "APPLICATION_ID", nullable = false, updatable = false)
  private Long applicationId;

  @Column(name = "APPL_DT", nullable = false)
  private LocalDateTime applDt;

  @Column(name = "NAME", length = 12)
  private String name;

  @Column(name = "EMAIL", length = 50)
  private String email;

  @Column(name = "PHONE_NO", length = 13)
  private String phoneNo;

  @Column(name = "FEE", length = 10)
  private String fee;

  @Column(name = "HOPE_AMT")
  private BigDecimal hopeAmt;

  @Column(name = "INT_RATE")
  private BigDecimal intRate;

  @Column(name = "MATURITY")
  private LocalDateTime maturity;
}