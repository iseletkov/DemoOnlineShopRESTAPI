package ru.studyit.demoonlineshoprest.rest

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream


@RestController
@RequestMapping("/upload_data")
class CControllerUploadData {
    @PostMapping
    fun handleFileUpload(
            @RequestParam("file") file      : MultipartFile//,
            //redirectAttributes: RedirectAttributes
    )
    {

        val targetStream = ByteArrayInputStream(file.bytes)
        val excel = XSSFWorkbook(targetStream)
        val n = excel.numberOfSheets

//        storageService.store(file)
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.originalFilename + "!")
    }
}