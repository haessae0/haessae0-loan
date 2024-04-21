package com.haessae0.loan.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.haessae0.loan.loan.domain.Application;
import com.haessae0.loan.loan.dto.ApplicationDTO.Request;
import com.haessae0.loan.loan.dto.ApplicationDTO.Response;
import com.haessae0.loan.loan.repository.ApplicationRepository;

@EnableJpaAuditing
@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {
  @InjectMocks
  ApplicationServiceImpl applicationServiceImpl;

  @Mock
  private ApplicationRepository applicationRepository;

  @Spy
  private ModelMapper modelMapper;

  @Test
  void Should_ReturnResponseOfNewApplyEntity_When_RequestApply() {
    Application entity = Application.builder()
        // .name("Member")
        .phoneNo("010-1111-2222")
        .email("mail@abc.de")
        .hopeAmt(BigDecimal.valueOf(50000000))
        .build();

    Request request = Request.builder()
        // .name("Member")
        .phoneNo("010-1111-2222")
        .email("mail@abc.de")
        .hopeAmt(BigDecimal.valueOf(50000000))
        .build();

    when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);

    Response actual = applicationServiceImpl.create(request);

    assertThat(actual.getName()).isSameAs(entity.getName());
  }

  @Test
  void Should_ReturnResponseOfExistApplicationEntity_When_RequestExistApplicationId() {
    Long findId = 152L;

    Application entity = Application.builder()
        .applicationId(findId)
        .build();

    when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

    Response actual = applicationServiceImpl.get(findId);

    assertThat(actual.getApplicationId()).isSameAs(findId);
  }

  @Test
  void Should_ReturnUpdatedResponseOfExistApplicationEntity_When_REquestUpdateExistApplcationInfo() {
    Long findId = 152L;

    Application entity = Application.builder()
        .applicationId(findId)
        .hopeAmt(BigDecimal.valueOf(
            30000000))
        .build();

    Request request = Request.builder()
        .hopeAmt(BigDecimal.valueOf(50000000))
        .build();

    when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);
    when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

    Response actual = applicationServiceImpl.update(findId, request);

    assertThat(actual.getApplicationId()).isSameAs(findId);
    assertThat(actual.getHopeAmt()).isSameAs(request.getHopeAmt());
  }

  @Test
  void Should_DeletedApplicationEntity_When_RequestDeleteExistApplicationInfo() {
    Long targetId = 1002L;

    Application entity = Application.builder()
        .applicationId(targetId)
        .build();
    when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);
    when(applicationRepository.findById(targetId)).thenReturn(Optional.ofNullable(entity));

    applicationRepository.deleteById(targetId);

    assertThat(entity.getIsDeleted()).isSameAs(false);
  }
}
