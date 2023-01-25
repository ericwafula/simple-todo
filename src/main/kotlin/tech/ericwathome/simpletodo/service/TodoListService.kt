package tech.ericwathome.simpletodo.service

import tech.ericwathome.simpletodo.dto.TodoDto
import tech.ericwathome.simpletodo.entity.Todo

interface TodoListService {
    fun addTodo(todoDto: TodoDto): Todo
    fun allTodos(): List<Todo>
    fun findTodo(id: Long): Todo
    fun searchForTodos(title: String): List<Todo>
    fun updateTodo(id: Long, todoDto: TodoDto): Todo
    fun deleteTodo(id: Long): String
}