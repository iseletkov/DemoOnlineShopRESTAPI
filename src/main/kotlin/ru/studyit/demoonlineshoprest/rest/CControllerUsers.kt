package ru.studyit.demoonlineshoprest.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import ru.studyit.demoonlineshoprest.model.CTest
import javax.annotation.PostConstruct


@RestController
@RequestMapping("/users")
class CControllerUsers
{
    @Value("\${iseletkov.count_of_test_objects}")
    private val count                       : Int
                                            = 2

    @Autowired
    private val env                         : Environment?
                                            = null

    val list                                = ArrayList<CTest>()

    @PostConstruct
    fun initializeSetting()
    {
        val x                               = (env?.getProperty("iseletkov.count_of_test_objects"))?.toInt()?:0
        for (i in 0 until x)
        {
            list.add(CTest(test2=i))
        }
    }

    @GetMapping
    fun hello() : String
    {
        return "Hello word!"
    }

    @GetMapping("/test")
    fun testData() : List<CTest>
    {
        return list
    }

    @GetMapping(
            value                           = ["/test"],
            params                          = ["index"]
    )
    fun testData(
            @RequestParam index             : Int
    )                                       : CTest
    {
        if (index<0 || index>=list.size)
            throw IllegalArgumentException("Нет элемента с таким номером!")
        return list[index]
    }
    @GetMapping(
            value                           = ["/test"],
            params                          = ["test1"]
    )
    fun getByTest1(
            @RequestParam test1             : String
    )                                       : CTest?
    {
        for (test in list)
        {
            if (test.test1 == test1)
                return test
        }

        return null
    }
    @PostMapping("/test")
    fun createNew(
         @RequestBody item                  : CTest
    )
    {
        list.add(item)
    }

}