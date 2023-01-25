package tech.ericwathome.simpletodo.error

data class ErrorResponse(
    var message: String,
    var statusCode: String
)
