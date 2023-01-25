package tech.ericwathome.simpletodo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Todo (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var dateOfCreation: Long? = null,
    var dueDate: Long? = null
)