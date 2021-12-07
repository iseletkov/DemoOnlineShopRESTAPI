package ru.studyit.demoonlineshoprest.model

import javax.persistence.*

@Entity
@Table(name                                 = "roles")
class CRole (
    @Column(
        name                                = "name"
    )
    var name                                : String?
                                            = null,

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private val users                       : List<CUser>

)                                           : CObject()
