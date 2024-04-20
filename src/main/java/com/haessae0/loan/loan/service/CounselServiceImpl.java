package com.haessae0.loan.loan.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.haessae0.loan.loan.domain.Counsel;
import com.haessae0.loan.loan.dto.CounselDTO.Request;
import com.haessae0.loan.loan.dto.CounselDTO.Response;
import com.haessae0.loan.loan.exception.BaseException;
import com.haessae0.loan.loan.exception.ResultType;
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

  @Override
  public Response get(Long counselId) {
    Counsel counsel = counselRepository.findById(counselId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    return modelMapper.map(counsel, Response.class);
  }

  @Override
  public Response update(Long counselId, Request request) {
    Counsel counsel = counselRepository.findById(counselId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    counsel.setName(request.getName());
    counsel.setPhoneNo(request.getPhoneNo());
    counsel.setEmail(request.getEmail());
    counsel.setMemo(request.getMemo());
    counsel.setAddr(request.getAddr());
    counsel.setAddrDtl(request.getAddrDtl());
    counsel.setZipCode(request.getZipCode());

    counselRepository.save(counsel);

    return modelMapper.map(counsel, Response.class);
  }

  @Override
  public void delete(Long counselId) {
    Counsel counsel = counselRepository.findById(counselId).orElseThrow(() -> {
      throw new BaseException(ResultType.SYSTEM_ERROR);
    });

    counsel.setIsDeleted(true);
    counselRepository.save(counsel);
  }

}
