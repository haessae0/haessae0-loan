package com.haessae0.loan.loan.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haessae0.loan.loan.dto.ApplicationDTO.Request;
import com.haessae0.loan.loan.dto.ApplicationDTO.Response;
import com.haessae0.loan.loan.dto.ResponseDTO;
import com.haessae0.loan.loan.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")

public class ApplicationController extends AbstractController {

  private final ApplicationService applicationService;

  @PostMapping
  public ResponseDTO<Response> create(@RequestBody Request request) {
    return ok(applicationService.create(request));
  }

  @GetMapping("/{applicationId}")
  public ResponseDTO<Response> getMethodName(@PathVariable("applicationId") Long applicationId) {
    return ok(applicationService.get(applicationId));
  }

  @PutMapping("/{applicationId}")
  public ResponseDTO<Response> getMethodName(@PathVariable("applicationId") Long applicationId,
      @RequestBody Request request) {
    return ok(applicationService.update(applicationId, request));
  }

  @DeleteMapping("/{applicationId}")
  public ResponseDTO<Response> delete(@PathVariable("applicationId") Long applicationId) {
    applicationService.delete(applicationId);
    return ok();
  }
}
