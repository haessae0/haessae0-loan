package com.haessae0.loan.loan.domain;

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
public class Terms extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "APPLICATION_ID", nullable = false, updatable = false)
  private Long applicationId;

  @Column(name = "NAME", length = 255)
  private String name;

  @Column(name = "TERMS_DTL_URL", length = 2255)
  private String termsDtlUrl;
}
