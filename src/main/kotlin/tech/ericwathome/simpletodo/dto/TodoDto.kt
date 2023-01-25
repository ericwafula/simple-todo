package tech.ericwathome.simpletodo.dto

data class TodoDto (
    var title: String,
    var description: String,
    var dateOfCreation: Long = 0L,
    var dueDate: Long = 0L
)