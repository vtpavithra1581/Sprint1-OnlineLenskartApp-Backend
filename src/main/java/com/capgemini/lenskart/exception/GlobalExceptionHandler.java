package com.capgemini.lenskart.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        objectBody.put("errorCode", status.value());
        List<String> exceptions = ex.getBindingResult().getFieldErrors().stream().map(m -> m.getDefaultMessage()).collect(Collectors.toList());
        objectBody.put("errorMessages", exceptions);
        return new ResponseEntity<Object>(objectBody, status);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ExceptionResponse>handler(InvalidDataException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(CustomerNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(GlassNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(GlassNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	@ExceptionHandler(LensesNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(LensesNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(SunGlassesNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(SunGlassesNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	@ExceptionHandler(FrameNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(FrameNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	@ExceptionHandler(AddToCartNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(AddToCartNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	@ExceptionHandler(PaymentDeclineException.class)
	public ResponseEntity<ExceptionResponse>handler(PaymentDeclineException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	@ExceptionHandler(ProductsNotFoundException.class)
	public ResponseEntity<ExceptionResponse>handler(ProductsNotFoundException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse>response =new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
		return response;
	}
	


}