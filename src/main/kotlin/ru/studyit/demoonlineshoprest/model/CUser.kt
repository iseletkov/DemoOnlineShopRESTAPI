package ru.studyit.demoonlineshoprest.model


import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name                                 = "users")
//@JsonIgnoreProperties(value = [ "orders" ])
class CUser(
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
                                            = null,

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
                                            = mutableListOf()
)

