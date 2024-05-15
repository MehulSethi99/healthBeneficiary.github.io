package com.jpa.exceptions;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jpa.exceptions.AccountNotFoundException;
import com.jpa.exceptions.BeneficiaryNotFoundException;
import com.jpa.exceptions.DuplicateEntityException;
import com.jpa.exceptions.HealthPackageNotFoundException;
import com.jpa.exceptions.NoDataException;

@ControllerAdvice
public class AllExceptionsHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorList= 
				ex.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(fe->fe.getDefaultMessage())
					.collect(Collectors.toList());
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errors", errorList);
		
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	//Exception Handler method to handle duplicate entity
	@ExceptionHandler(DuplicateEntityException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateEntityException de) {
		Map<String, Object> errors = new LinkedHashMap<>();
		errors.put("details", de.getMessage());
		errors.put("timestamp", LocalDate.now());

		return new ResponseEntity<Map>(errors, HttpStatus.BAD_REQUEST);
	}

	//Exception Handler method to handle Empty data
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<?> handleNoData(NoDataException ne) {
		Map<String, Object> errors = new LinkedHashMap<>();
		errors.put("details", ne.getMessage());
		errors.put("timestamp", LocalDate.now());

		return new ResponseEntity<Map>(errors, HttpStatus.BAD_REQUEST);
	}

	//Exception Handler method to handle No beneficiary data
	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public ResponseEntity<?> handleBeneficiaryNotFound(BeneficiaryNotFoundException be) {
		Map<String, Object> errors = new LinkedHashMap<>();
		errors.put("details", be.getMessage());
		errors.put("timestamp", LocalDate.now());

		return new ResponseEntity<Map>(errors, HttpStatus.BAD_REQUEST);
	}

	//Exception Handler method to handle No account
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<?> handleAccountNotFound(AccountNotFoundException ae) {
		Map<String, Object> errors = new LinkedHashMap<>();
		errors.put("details", ae.getMessage());
		errors.put("timestamp", LocalDate.now());

		return new ResponseEntity<Map>(errors, HttpStatus.BAD_REQUEST);
	}

	//Exception Handler method to handle no health package
	@ExceptionHandler(HealthPackageNotFoundException.class)
	public ResponseEntity<?> handleHealthPackageNotFound(HealthPackageNotFoundException pe) {
		Map<String, Object> errors = new LinkedHashMap<>();
		errors.put("details", pe.getMessage());
		errors.put("timestamp", LocalDate.now());

		return new ResponseEntity<Map>(errors, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<?> handleUserDataErrors(InvalidUserException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotAuthorizedException.class)
	public ResponseEntity<?> handleNotAuthorized(NotAuthorizedException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<?> handleTokenErrors(InvalidTokenException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
}
