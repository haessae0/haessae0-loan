package com.haessae0.loan.loan.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.haessae0.loan.loan.domain.Counsel;
import com.haessae0.loan.loan.dto.CounselDTO.Request;
import com.haessae0.loan.loan.dto.CounselDTO.Response;
import com.haessae0.loan.loan.repository.CounselRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

  private final CounselRepository counselRepository;

  private final ModelMapper modelMapper;

  @Override
  public Response create(Request request) {

    // 요청받은 request를 Counsel Dto로 변환 후, 적용일자를 부여하였다.
    Counsel counsel = modelMapper.map(request, Counsel.class);
    counsel.setApplDt(LocalDateTime.now());

    Counsel created = counselRepository.save(counsel);

    return modelMapper.map(created, Response.class);
  }
}
