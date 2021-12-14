package ru.studyit.demoonlineshoprest.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import ru.studyit.demoonlineshoprest.model.COrder
import ru.studyit.demoonlineshoprest.repositories.IRepositoryOrders
import ru.studyit.demoonlineshoprest.repositories.IRepositoryRoles
import ru.studyit.demoonlineshoprest.repositories.IRepositoryUsers
import java.util.stream.Collectors




/********************************************************************************************************
 * Сервис, содержащий логику работы со списком заказов.                                                 *
 * @author Селетков И.П. 2021 1207.                                                                     *
 *******************************************************************************************************/
@Component
class CServiceOrders {

    @Autowired
    private lateinit var repositoryRoles    : IRepositoryRoles

    @Autowired
    private lateinit var repositoryUsers    : IRepositoryUsers

    @Autowired
    private lateinit var repositoryOrders   : IRepositoryOrders

    fun getOrdersByUserLogin(
        login                               : String
    )                                       : List<COrder>
    {
        //Получить пользователя по логину
        val user                            = repositoryUsers.findByLogin(login)
        user ?: return listOf()

        //java:
        //if (user==null)
        //    return new ArrayList<COrder>()

        //Получить роли по пользователю
        val roles                           = repositoryRoles.getRolesByUserLogin(login)

        //В зависимости от роли вызвать разные запросы по сбору заказов
        return if (roles.any {
                it.name == "Администратор"
            })
        {
            repositoryOrders.findAll()
        }
        else
        {
            repositoryOrders.getAllByOwner(user)
        }
        //java:
//        return (roles
//                .stream()
//                .filter { role -> role.getName() == "Администратор" }
//                .collect(Collectors.toList())
//                .size()>0
//        ) ? repositoryOrders.findAll() : repositoryOrders.getAllByOwner(user)

    }
    fun getOrdersByAuth(
        auth                                : Authentication
    )                                       : List<COrder>
    {
        val login                           = auth.name



        //Получить пользователя по логину
        val user                            = repositoryUsers.findByLogin(login)
        //TODO Если пользователя нет в БД, то это может быть вновь зарегистрированный пользователь
        //через внешний сервис авторизации.
        //Можно пользователя (покупателя) добавить.
        user ?: return listOf()

        //java:
        //if (user==null)
        //    return new ArrayList<COrder>()

        //Получить роли по пользователю
        //val roles                           = repositoryRoles.getRolesByUserLogin(login)
        val roles                           = ArrayList(auth.authorities)
            .map{
                it.authority.toString()
            }

        //В зависимости от роли вызвать разные запросы по сбору заказов
        return if (roles.any {
                it == "ROLE_admin"
            })
        {
            repositoryOrders.findAll()
        }
        else
        {
            repositoryOrders.getAllByOwner(user)
        }
        //java:
//        return (roles
//                .stream()
//                .filter { role -> role.getName() == "Администратор" }
//                .collect(Collectors.toList())
//                .size()>0
//        ) ? repositoryOrders.findAll() : repositoryOrders.getAllByOwner(user)

    }

}