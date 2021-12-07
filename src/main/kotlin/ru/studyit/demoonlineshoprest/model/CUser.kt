package ru.studyit.demoonlineshoprest.model


import com.fasterxml.jackson.annotation.JsonIdentityReference
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name                                 = "users")
//@JsonIgnoreProperties(value = [ "orders" ])
class CUser(


    @Column(
        name                                = "sex"
    )
    var sex                                 : Boolean
                                            = true,


    @Column(
        name                                = "login"
    )
    var login                               : String
                                            = "",

    @Column(
        name                                = "password"
    )
    var password                            : String
                                            = "",

    @Column(
        name                                = "date_of_birth",
        columnDefinition                    = "DATE"
    )
    var dateOfBirth                         : LocalDate?
                                            = null,

    @OneToMany(
        mappedBy                            = "owner",
        fetch                               = FetchType.EAGER,
        cascade                             = [CascadeType.REMOVE],
        orphanRemoval                       = true
    )
    //@JsonIgnore
    @JsonIdentityReference(
            alwaysAsId                      = true
    )

    var orders                              : MutableList<COrder>
                                            = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name                                = "user_roles",
        joinColumns                         = [
            JoinColumn(
                name                        = "user_id")
        ],
        inverseJoinColumns                  = [
            JoinColumn(
                name                        = "role_id")
        ]
    )
    @JsonIdentityReference(
        alwaysAsId                          = true
    )
    var roles                               : MutableList<CRole>
                                            = mutableListOf()
)                                           : CObject()

