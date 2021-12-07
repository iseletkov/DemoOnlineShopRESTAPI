package ru.studyit.demoonlineshoprest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.studyit.demoonlineshoprest.model.CRole
import ru.studyit.demoonlineshoprest.model.CUser
import java.util.*

@Repository
interface IRepositoryRoles                  : JpaRepository<CRole, UUID>
{

    @Query("SELECT r FROM CRole r JOIN r.users u WHERE u.login = :login")
    fun getRolesByUserLogin(
        login                               : String
    )                                       : List<CRole>
}