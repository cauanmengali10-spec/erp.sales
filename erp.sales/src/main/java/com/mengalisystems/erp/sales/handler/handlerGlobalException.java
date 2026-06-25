package com.mengalisystems.erp.sales.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class handlerGlobalException {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorApiResponse>apiResponseResponseEntity(APIException apiException){
        return apiException.errorApiResponseResponseEntity();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception exception){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorApiResponse.builder()
                        .message("INTERNAL SERVER ERROR")
                        .details("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA")
                        .build());
    }
}
