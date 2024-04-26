package fr.eni.filmothequeapi.utils.handlers;

import fr.eni.filmothequeapi.dtos.ErrorResponseDto;
import fr.eni.filmothequeapi.utils.exceptions.ResourceNotFoundException;
import fr.eni.filmothequeapi.utils.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponseDto handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponseDto handleUnauthorizedException(UnauthorizedException ex) {
        return new ErrorResponseDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
    }

}
