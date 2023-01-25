package tech.ericwathome.simpletodo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.ericwathome.simpletodo.entity.Todo

@Repository
interface TodoListRepository : JpaRepository<Todo, Long> {
    fun findAllByTitleIgnoreCase(title: String): List<Todo>
}