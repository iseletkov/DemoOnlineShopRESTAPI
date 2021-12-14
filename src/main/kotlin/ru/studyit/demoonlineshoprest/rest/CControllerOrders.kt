package ru.studyit.demoonlineshoprest.rest



import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.studyit.demoonlineshoprest.model.COrder
import ru.studyit.demoonlineshoprest.services.CServiceOrders
import java.security.Principal
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/orders")
class CControllerOrders {

    @Autowired
    private lateinit var serviceOrders      : CServiceOrders

    @GetMapping("")
    fun getAll(
    )                                       : List<COrder>
    {
        return serviceOrders.getOrdersByAuth(SecurityContextHolder.getContext().authentication)
    }
//    @GetMapping("")
//    fun getAll(
//    )                                       : String
//    {
//        return "Это контроллер заказов"
//    }
}