package ru.studyit.demoonlineshoprest.rest



import org.springframework.beans.factory.annotation.Autowired
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

//    @GetMapping("")
//    fun getAll(
//        principal                           : Principal
//    )                                       : List<COrder>
//    {
//        return serviceOrders.getOrdersByUserLogin(principal.name)
//    }
    @GetMapping("")
    fun getAll(
    )                                       : String
    {
        return "Это контроллер заказов"
    }
}