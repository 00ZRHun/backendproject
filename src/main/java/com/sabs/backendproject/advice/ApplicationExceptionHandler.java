package com.sabs.backendproject.advice;

//import com.amazonaws.SdkClientException;
import com.sabs.backendproject.exceptions.GetIdLessThanOneException;
import com.sabs.backendproject.exceptions.GetIdNullException;
import com.sabs.backendproject.exceptions.InvalidReferenceUserIdException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    // catch MethodArgumentNotValidException with code 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMessage = getErrorMessage(ex);

        // add addition error content
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMessage.put(error.getField(), error.getDefaultMessage());
        });

        return errorMessage;
    }

    // catch EntityNotFoundException with code 404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> handleEntityNotFoundException(EntityNotFoundException ex){
        return getErrorMessage(ex);
    }

    // catch ObjectOptimisticLockingFailureException with code 404
    // inner nested obj not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)   // OPT: JpaObjectRetrievalFailureException
    public Map<String, String> handleObjectOptimisticLockingFailureException(ObjectOptimisticLockingFailureException ex){
        return getErrorMessage(ex);
    }

    // bad header
    // catch HttpMediaTypeNotSupportedException with code 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String, String> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex){
        return getErrorMessage(ex);
    }

    // bad input
    // 1. catch GetIdNullException with code 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetIdNullException.class)
    public Map<String, String> handleGetIdNullException(GetIdNullException ex){
        return getErrorMessage(ex);
    }

    // 2. catch GetIdLessThanOneException with code 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetIdLessThanOneException.class)
    public Map<String, String> handleGetIdLessThanOneException(GetIdLessThanOneException ex){
        return getErrorMessage(ex);
    }

    // 2. catch HttpMessageNotReadableException with code 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return getErrorMessage(ex);
    }

    // 3. catch BindException with code 400 (input validation err)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Map<String, String> handleBindException(BindException ex){
        return getErrorMessage(ex);
    }
    // 4. catch InvalidReferenceUserIdException with code 400 (input validation err)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidReferenceUserIdException.class)
    public Map<String, String> handleInvalidReferenceUserIdException(InvalidReferenceUserIdException ex){
        return getErrorMessage(ex);
    }

    // catch NullPointerException with code 422
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NullPointerException.class)
    public Map<String, String> handleNullPointerException(NullPointerException ex){
        return getErrorMessage(ex);
    }

    /*// catch SdkClientException with code 422
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(SdkClientException.class)
    public Map<String, String> handleSdkClientException(SdkClientException ex){
        return getErrorMessage(ex);
    }*/

    // catch DataIntegrityViolationException with code 304 (catch SQL unique constraint)
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    @ExceptionHandler(DataIntegrityViolationException.class)   // OPT: SQLIntegrityConstraintViolationException
    public Map<String, String> DataIntegrityViolationException(DataIntegrityViolationException ex){
        System.out.println("=== DataIntegrityViolationException  ===");
        System.out.println("no show Error Message: -");
        System.out.println("* ex = " + ex);
        System.out.println("* getErrorMessage(ex) = " + getErrorMessage(ex));
        return getErrorMessage(ex);
    }

    // catch MaxUploadSizeExceededException with code 304
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    @ExceptionHandler(MaxUploadSizeExceededException.class)   // OPT: FileSizeLimitExceededException
    public Map<String, String> MaxUploadSizeExceededException(MaxUploadSizeExceededException ex){
        System.out.println("=== MaxUploadSizeExceededException  ===");
        System.out.println("no show Error Message: -");
        System.out.println("* ex = " + ex);
        System.out.println("* getErrorMessage(ex) = " + getErrorMessage(ex));
        return getErrorMessage(ex);
    }

    // catch IllegalStateException with code 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public Map<String, String> handleIllegalStateException(IllegalStateException ex){
        return getErrorMessage(ex);
    }

    // catch other unexpected exception with code 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String>  handleException(Exception ex){
        Map<String, String> errorMessage = getErrorMessage(ex);
        errorMessage.put("Exception", ex.toString());
        System.out.println("Exception = " + ex);   // debug
        return errorMessage;
    }

    // Reusable / small function(s)
    // get error message in Map<String, String> type
    private Map<String, String> getErrorMessage(Exception ex) {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message", ex.getMessage());
        return errorMap;
    }

}
