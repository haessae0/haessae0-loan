package com.haessae0.loan.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.haessae0.loan.loan.domain.Counsel;
import com.haessae0.loan.loan.dto.CounselDTO.Request;
import com.haessae0.loan.loan.dto.CounselDTO.Response;
import com.haessae0.loan.loan.exception.BaseException;
import com.haessae0.loan.loan.exception.ResultType;
import com.haessae0.loan.loan.repository.CounselRepository;

@EnableJpaAuditing
@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

  @InjectMocks
  CounselServiceImpl counselServiceImpl;

  @Mock
  private CounselRepository counselRepository;

  // Mocking 처리하지 않고 순수하게 테스트를 위해 Spy처리
  @Spy
  private ModelMapper modelMapper;

  @Test
  void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel() {
    Counsel entity = Counsel.builder()
        .name("MINSU PARK")
        .phoneNo("010-7126-3642")
        .email("haessae0@gmail.com")
        .memo("저는 주택 대출을 받고 싶습니다.")
        .zipCode("12345")
        .addr("서울 영등포구 선유서로 34길 11-4")
        .addrDtl("305호")
        .build();

    Request request = Request.builder()
        .name("MINSU PARK")
        .phoneNo("010-7126-3642")
        .email("haessae0@gmail.com")
        .memo("저는 주택 대출을 받고 싶습니다.")
        .zipCode("12345")
        .addr("서울 영등포구 선유서로 34길 11-4")
        .addrDtl("305호")
        .build();

    when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

    Response actual = counselServiceImpl.create(request);

    assertThat(actual.getName()).isSameAs(entity.getName());
  }

  @Test
  void Should_ReturnResponseOfExistCounselEntity_When_RequestExistCounselId() {
    Long findId = 1L;
    Counsel entity = Counsel.builder()
        .counselId(1L)
        .build();

    when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

    Response actual = counselServiceImpl.get(findId);

    assertThat(actual.getCounselId()).isSameAs(findId);
  }

  @Test
  void Should_ThrowException_When_RequestNotExistCounselId() {
    Long findId = 2L;

    when(counselRepository.findById(findId)).thenThrow(new BaseException(ResultType.SYSTEM_ERROR));

    Assertions.assertThrows(BaseException.class, () -> counselServiceImpl.get(findId));
  }

  @Test
  void Should_ReturenUpdatedResponseOfExistCounselEntity_When_RequestUpdateExistCounselInfo() {
    Long findId = 1L;

    Counsel entity = Counsel.builder()
        .counselId(1L)
        .name("MINSU")
        .build();
    Request request = Request.builder()
        .name("MINSU PARK")
        .build();

    when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);
    when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

    Response actual = counselServiceImpl.update(findId, request);

    assertThat(actual.getCounselId()).isSameAs(findId);
    assertThat(actual.getName()).isSameAs(request.getName());
  }

  @Test
  void Should_DeletedCounselEntity_When_RequestDeleteExistCounslInfo() {
    Long targetId = 1002L;

    Counsel entity = Counsel.builder()
        .counselId(targetId)
        .build();
    when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);
    when(counselRepository.findById(targetId)).thenReturn(Optional.ofNullable(entity));

    counselRepository.deleteById(targetId);

    assertThat(entity.getIsDeleted()).isSameAs(false);
  }
}
