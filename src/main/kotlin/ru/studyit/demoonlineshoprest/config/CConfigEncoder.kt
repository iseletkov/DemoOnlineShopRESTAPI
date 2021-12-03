package ru.studyit.demoonlineshoprest.config

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

/********************************************************************************************************
 * Создание объекта класса для шифрования паролей.                                                      *
 * Вынесен в отдельный класс, чтобы не создавалась циклическая зависимость между                        *
 * CSecurityConfig и CServiceUserDetails. В обоих нужен этот шифровальшик.                              *
 * @author Селетков И.П. 2021 1203.                                                                     *
 *******************************************************************************************************/
@Component
class CConfigEncoder {
    @Bean
    fun passwordEncoder()                   : PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}