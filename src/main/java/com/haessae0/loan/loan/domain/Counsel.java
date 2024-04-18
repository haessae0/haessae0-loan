package com.haessae0.loan.loan.domain;

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
public class Counsel extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "COUNSEL_ID", nullable = false, updatable = false)
  private Long counselId;

  @Column(name = "APPL_DT", nullable = false)
  private LocalDateTime applDt;

  @Column(name = "NAME", length = 12)
  private String name;

  @Column(name = "ADDR", length = 50)
  private String addr;

  @Column(name = "ADDR_DTL", length = 50)
  private String addrDtl;

  @Column(name = "PHONE_NO", length = 13)
  private String phoneNo;

  @Column(name = "EMAIL", length = 50)
  private String email;

  @Column(name = "MEMO", length = 1000)
  private String memo;

  @Column(name = "ZIP_CODE", length = 5)
  private String zipCode;
}
