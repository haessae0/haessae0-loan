package com.haessae0.loan.loan.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haessae0.loan.loan.dto.CounselDTO.Request;
import com.haessae0.loan.loan.dto.CounselDTO.Response;
import com.haessae0.loan.loan.dto.ResponseDTO;
import com.haessae0.loan.loan.service.CounselService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/counsels")
public class CounselController extends AbstractController {

  private final CounselService counselService;

  @PostMapping
  public ResponseDTO<Response> create(@RequestBody Request request) {
    return ok(counselService.create(request));
  }

  @GetMapping("/{counselId}")
  public ResponseDTO<Response> get(@PathVariable("counselId") Long counselId) {
    return ok(counselService.get(counselId));
  }

  @PutMapping("/{counselId}")
  public ResponseDTO<Response> update(@PathVariable("counselId") Long counselId, @RequestBody Request request) {
    return ok(counselService.update(counselId, request));
  }

  @DeleteMapping("/{counselId}")
  public ResponseDTO<Response> delete(@PathVariable("counselId") Long counselId) {
    counselService.delete(counselId);
    return ok();
  }

}
