package com.haessae0.loan.loan.service;

import com.haessae0.loan.loan.dto.CounselDTO.Request;
import com.haessae0.loan.loan.dto.CounselDTO.Response;

public interface CounselService {

  Response create(Request request);

  Response get(Long counselId);

  Response update(Long counselId, Request request);

  void delete(Long counselId);
}
