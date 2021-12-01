package ru.studyit.demoonlineshoprest.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.nio.file.Files


@RestController
@RequestMapping("/reports")
class CControllerReports {
    @GetMapping(value = ["/docx"])
    @ResponseBody
    fun getReport(

    )                                       : ByteArray
    {
        val file = File("C:\\Test\\123.txt")
        return Files.readAllBytes(file.toPath())
    }
}