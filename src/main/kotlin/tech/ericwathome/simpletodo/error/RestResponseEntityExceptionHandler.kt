package tech.ericwathome.simpletodo.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(TodoNotFoundException::class)
    fun todoNotFoundException(e: TodoNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(e.localizedMessage, e.statusCode), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(EmptyFieldsException::class)
    fun emptyFieldsException(e: EmptyFieldsException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(e.localizedMessage, e.statusCode), HttpStatus.BAD_REQUEST)
    }

}