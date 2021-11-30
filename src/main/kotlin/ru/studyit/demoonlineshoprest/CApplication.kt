package ru.studyit.demoonlineshoprest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(
        basePackages                        = ["ru.studyit.demoonlineshoprest.model"]
)
class CApplication

fun main(args: Array<String>) {
    runApplication<CApplication>(*args)
}
