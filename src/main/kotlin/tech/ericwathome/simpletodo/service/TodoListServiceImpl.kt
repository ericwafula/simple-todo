package tech.ericwathome.simpletodo.service

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import tech.ericwathome.simpletodo.dto.TodoDto
import tech.ericwathome.simpletodo.entity.Todo
import tech.ericwathome.simpletodo.error.EmptyFieldsException
import tech.ericwathome.simpletodo.error.TodoNotFoundException
import tech.ericwathome.simpletodo.repository.TodoListRepository
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
@RequiredArgsConstructor
class TodoListServiceImpl(
    private val repository: TodoListRepository
) : TodoListService {
    override fun addTodo(todoDto: TodoDto): Todo {
        var todo = Todo()
        if (todoDto.title.isNotEmpty() && todoDto.description.isNotEmpty()) {
            todo.apply {
                title = todoDto.title
                description = todoDto.description
                dateOfCreation = Instant.now().toEpochMilli()
                dueDate = todoDto.dueDate
            }
        } else {
            throw EmptyFieldsException("title and description cannot be empty", "EMPTY_FIELDS")
        }
        return repository.save(todo)
    }

    override fun allTodos(): List<Todo> {
        return repository.findAll()
    }

    override fun findTodo(id: Long): Todo {
        return repository.findById(id)
            .orElseThrow { TodoNotFoundException("no TODO item found with id: $id", "NOT_FOUND") }
    }

    override fun searchForTodos(title: String): List<Todo> {
        return repository.findAllByTitleIgnoreCase(title)
    }

    override fun updateTodo(id: Long, todoDto: TodoDto): Todo {
        var todo = repository.findById(id).orElseThrow { TodoNotFoundException("no TODO item found with id: $id", "NOT_FOUND") }
        if (todoDto.title.isNotEmpty()) {
            todo.title = todoDto.title
        }
        if (todoDto.description.isNotEmpty()) {
            todo.description = todoDto.description
        }
        if (todoDto.dateOfCreation != 0L) {
            todo.dateOfCreation = todoDto.dateOfCreation
        }
        todo.dueDate = todoDto.dueDate
        return repository.save(todo)
    }

    override fun deleteTodo(id: Long): String {
        repository.findById(id).orElseThrow { TodoNotFoundException("no TODO item found with id: $id", "NOT_FOUND") }
        return "todo deleted successfully"
    }
}