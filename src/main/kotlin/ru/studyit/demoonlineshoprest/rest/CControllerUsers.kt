package ru.studyit.demoonlineshoprest.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.data.repository.findByIdOrNull
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import ru.studyit.demoonlineshoprest.model.CUser
import ru.studyit.demoonlineshoprest.repositories.IRepositoryUsers
import java.time.LocalDate
import java.util.*


@RestController
@RequestMapping("/users")
class CControllerUsers
{
    @Autowired
    private val env                         : Environment?
                                            = null
    @Autowired
    private lateinit var repositoryUsers    : IRepositoryUsers


    @GetMapping("")
    fun getAll()                            : List<CUser>
    {
        return repositoryUsers.findAll()
    }

    @GetMapping(
            params                          = ["id"]
    )
    fun getById(
            @RequestParam id                : UUID
    )                                       : CUser?
    {
        return repositoryUsers.findByIdOrNull(id)
    }

    @GetMapping(
            params                          = ["sex"]
    )
    fun getBySex(
            @RequestParam sex               : Boolean
    )                                       : List<CUser>
    {
        return repositoryUsers.findBySex(sex)
    }

    @GetMapping(
            params                          = ["date_of_birth"]
    )
    fun getOlderThan(
            @RequestParam
//            @DateTimeFormat(
//                    iso                     = DateTimeFormat.ISO.DATE
//            )
            @DateTimeFormat(
                    pattern                 = "dd.MM.yyyy")
            date_of_birth                   : LocalDate
    )                                       : List<CUser>
    {
        return repositoryUsers.findOlderThan(date_of_birth)
    }
}