package ru.studyit.demoonlineshoprest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.studyit.demoonlineshoprest.model.CUser
import java.time.LocalDate
import java.util.*

@Repository
interface IRepositoryUsers : JpaRepository<CUser, UUID>
{
    fun findBySex(
        sex                                 : Boolean
    )                                       : List<CUser>

    @Query("SELECT u FROM CUser u WHERE u.dateOfBirth <= :dateOfBirth")
    fun findOlderThan(
            @Param("dateOfBirth") dateOfBirth : LocalDate
    )                                       : List<CUser>
}