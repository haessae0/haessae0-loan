package com.haessae0.loan.loan.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haessae0.loan.loan.exception.BaseException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class ResponseDTO<T> implements Serializable {

  private ResultObject result;

  private T data;

  public ResponseDTO(ResultObject resultObject) {
    this.result = resultObject;
  }

  public ResponseDTO(T data) {
    this.data = data;
  }

  public static <T> ResponseDTO<T> ok() {
    return new ResponseDTO<>(ResultObject.getSuccess());
  }

  public static <T> ResponseDTO<T> ok(T data) {
    return new ResponseDTO<>(ResultObject.getSuccess(), data);
  }

  public static <T> ResponseDTO<T> response(T data) {
    return new ResponseDTO<>(ResultObject.getSuccess(), data);
  }

  public ResponseDTO(BaseException e) {
    this.result = new ResultObject(e);
  }
}
