package com.haessae0.loan.loan.service;

import com.haessae0.loan.loan.dto.TermsDTO.Request;
import com.haessae0.loan.loan.dto.TermsDTO.Response;

public interface TermsService {

  Response create(Request request);

}
