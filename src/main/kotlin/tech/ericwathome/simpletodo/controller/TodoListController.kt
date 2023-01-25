package tech.ericwathome.simpletodo.controller

import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.ericwathome.simpletodo.dto.TodoDto
import tech.ericwathome.simpletodo.entity.Todo
import tech.ericwathome.simpletodo.service.TodoListService

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
class TodoListController(
    private val service: TodoListService
) {

    @PostMapping("new")
    fun addTodo(@RequestBody todoDto: TodoDto): ResponseEntity<Todo> {
        return ResponseEntity(service.addTodo(todoDto), HttpStatus.CREATED)
    }

    @GetMapping
    fun allTodos(): ResponseEntity<List<Todo>> {
        return ResponseEntity(service.allTodos(), HttpStatus.OK)
    }

    @GetMapping("find/{id}")
    fun findTodo(@PathVariable("id") id: Long): ResponseEntity<Todo> {
        return ResponseEntity(service.findTodo(id), HttpStatus.OK)
    }

    @GetMapping("search")
    fun searchForTodos(@RequestParam("title") title: String): ResponseEntity<List<Todo>> {
        return ResponseEntity(service.searchForTodos(title), HttpStatus.OK)
    }

    @PutMapping("update/{id}")
    fun updateTodo(@PathVariable("id") id: Long, @RequestBody todoDto: TodoDto): ResponseEntity<Todo> {
        return ResponseEntity(service.updateTodo(id, todoDto), HttpStatus.OK)
    }

    @DeleteMapping("delete/{id}")
    fun deleteTodo(@PathVariable("id") id: Long): ResponseEntity<String> {
        return ResponseEntity(service.deleteTodo(id), HttpStatus.OK)
    }

}