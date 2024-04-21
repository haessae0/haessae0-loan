package com.haessae0.loan.loan.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.haessae0.loan.loan.domain.Application;
import com.haessae0.loan.loan.dto.ApplicationDTO.Request;
import com.haessae0.loan.loan.dto.ApplicationDTO.Response;
import com.haessae0.loan.loan.exception.BaseException;
import com.haessae0.loan.loan.exception.ResultType;
import com.haessae0.loan.loan.repository.ApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
  private final ApplicationRepository applicationRepository;
  private final ModelMapper modelMapper;

  @Override
  public Response create(Request request) {
    Application application = modelMapper.map(request, Application.class);
    application.setApplDt(LocalDateTime.now());

    Application applied = applicationRepository.save(application);
    return modelMapper.map(applied, Response.class);
  }

  @Override
  public Response get(Long applicationId) {
    Application application = applicationRepository.findById(applicationId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    return modelMapper.map(application, Response.class);
  }

  @Override
  public Response update(Long applicationId, Request request) {
    Application application = applicationRepository.findById(applicationId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    application.setName(request.getName());
    application.setPhoneNo(request.getPhoneNo());
    application.setEmail(request.getEmail());
    application.setHopeAmt(request.getHopeAmt());

    applicationRepository.save(application);

    return modelMapper.map(application, Response.class);
  }

  @Override
  public void delete(Long applicationId) {
    Application application = applicationRepository.findById(applicationId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    application.setIsDeleted(true);
    applicationRepository.save(application);
  }

}
