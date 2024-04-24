package com.haessae0.loan.loan.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.haessae0.loan.loan.domain.Terms;
import com.haessae0.loan.loan.dto.TermsDTO.Request;
import com.haessae0.loan.loan.dto.TermsDTO.Response;
import com.haessae0.loan.loan.repository.TermsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService {

  private final TermsRepository termsRepository;

  private final ModelMapper modelMapper;

  @Override
  public Response create(Request request) {
    Terms terms = modelMapper.map(request, Terms.class);

    Terms created = termsRepository.save(terms);

    return modelMapper.map(created, Response.class);
  }

}
