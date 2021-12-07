package ru.studyit.demoonlineshoprest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.studyit.demoonlineshoprest.model.COrder
import ru.studyit.demoonlineshoprest.model.CUser
import java.util.*

@Repository
interface IRepositoryOrders                 : JpaRepository<COrder, UUID>
{
    //fun findAll()                           : List<COrder>

    fun getAllByOwner(
        owner                               : CUser
    )                                       : List<COrder>
}