package com.haessae0.loan.loan.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haessae0.loan.loan.dto.ResponseDTO;
import com.haessae0.loan.loan.dto.TermsDTO.Request;
import com.haessae0.loan.loan.dto.TermsDTO.Response;
import com.haessae0.loan.loan.service.TermsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terms")
public class TernsController extends AbstractController {

  private final TermsService termsService;

  @PostMapping
  public ResponseDTO<Response> create(@RequestBody Request request) {
    return ok(termsService.create(request));
  }
}
