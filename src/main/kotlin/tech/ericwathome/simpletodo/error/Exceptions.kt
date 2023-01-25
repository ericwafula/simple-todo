package tech.ericwathome.simpletodo.error

import jakarta.persistence.EntityNotFoundException

class TodoNotFoundException(override val message: String?, val statusCode: String) : EntityNotFoundException(message)

class EmptyFieldsException(override val message: String?, val statusCode: String) : RuntimeException(message)