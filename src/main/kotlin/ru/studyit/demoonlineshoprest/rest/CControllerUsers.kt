package ru.studyit.demoonlineshoprest.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.studyit.demoonlineshoprest.model.CTest

@RestController
@RequestMapping("/users")
class CControllerUsers
{
    @GetMapping
    fun hello() : String
    {
        return "Hello word!"
    }

    @GetMapping("/test")
    fun testData() : List<CTest>
    {
        val list = ArrayList<CTest>()
        list.add(CTest())
        list.add(CTest("Это тест", 789))
        return list
    }

}