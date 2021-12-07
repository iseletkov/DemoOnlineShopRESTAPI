package ru.studyit.demoonlineshoprest.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class CObject (
    @Id
    @GenericGenerator(
        name                                = "UUIDGenerator",
        strategy                            = "uuid2"
    )
    @GeneratedValue(
        generator                           = "UUIDGenerator"
    )
    @Column(
        name                                = "id"
    )
    var id                                  : UUID?
                                            = null
)