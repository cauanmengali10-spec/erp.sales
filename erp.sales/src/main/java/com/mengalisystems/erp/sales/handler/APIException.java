package com.mengalisystems.erp.sales.handler;


import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Getter
@Log4j2
public class APIException extends RuntimeException {

  private HttpStatus statusException;
  private ErrorApiResponse bodyException;


  private APIException(HttpStatus statusException, String message, Exception exception){
      super(message, exception);
      this.statusException = statusException;
      this.bodyException = ErrorApiResponse.builder()
              .message(message)
              .details(getDetails(exception))
              .build();
  }
  private static String getDetails(Exception exception){
      return Optional.ofNullable(exception)
              .map(APIException::getCauseMessage).orElse(null);
  }
  private static String getCauseMessage(Exception exception){
      return exception.getCause() != null
              ? exception.getCause().getMessage()
              : exception.getMessage();
  }

public static APIException build (HttpStatus statusException, String message) {
    return new APIException(statusException, message, null);
}
public static APIException build(HttpStatus statusException, String message, Exception exception){
      log.error("EXCEPTION: ", exception);
      return new APIException(statusException, message, exception);
}

public ResponseEntity<ErrorApiResponse>errorApiResponseResponseEntity(){
      return  ResponseEntity
              .status(statusException)
              .body(bodyException);
}



}
