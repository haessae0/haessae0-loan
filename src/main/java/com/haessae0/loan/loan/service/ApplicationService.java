package com.haessae0.loan.loan.service;

import com.haessae0.loan.loan.dto.ApplicationDTO.Request;
import com.haessae0.loan.loan.dto.ApplicationDTO.Response;

public interface ApplicationService {

  Response create(Request request);

  Response get(Long applicationId);

  Response update(Long applicationId, Request request);

  void delete(Long applicationId);
}
