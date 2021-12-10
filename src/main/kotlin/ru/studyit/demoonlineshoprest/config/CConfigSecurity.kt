package ru.studyit.demoonlineshoprest.config

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.keycloak.adapters.springsecurity.KeycloakConfiguration
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import ru.studyit.demoonlineshoprest.services.CServiceUserDetails


/********************************************************************************************************
 * Настройка безопасности сервиса.                                                                      *
 * @author Селетков И.П. 2021 1203.                                                                     *
 *******************************************************************************************************/
@KeycloakConfiguration
class CConfigSecurity                       : KeycloakWebSecurityConfigurerAdapter()
{
    @Autowired
    private lateinit var userDetailsService : CServiceUserDetails

    @Autowired
    private lateinit var passwordEncoder    : PasswordEncoder

    /****************************************************************************************************
     * Настройка режима доступа к отдельным контроллерам.                                               *
     ***************************************************************************************************/
    /*override fun configure(
            http                            : HttpSecurity
    )
    {
        http
            .authorizeRequests()
            //К контроллеру users все запросы разрешены.
            .antMatchers("/users").permitAll()
            //Ко всем остальным контроллерам - только при наличии авторизации.
            .anyRequest().authenticated()
            .and()
            //Тип авторизации - базовая (логин и пароль).
            .httpBasic()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//            .logout()
//            .permitAll()


    }*/
    override fun configure(
        http                                : HttpSecurity
    )
    {
        super.configure(http)
        http
            .authorizeRequests()
            //.antMatchers("/users").permitAll()
            .antMatchers("/orders").hasRole("user")
            //.anyRequest().authenticated();
            //.antMatchers("/orders*").authenticated()
            //.hasRole("user")
            .anyRequest()
            .permitAll()
        http.csrf().disable();
    }
    /****************************************************************************************************
     * Создание объекта класса, который будет отвечать за проверку учётных данных.                      *
     ***************************************************************************************************/
//    @Bean
//    fun authProvider()                      : DaoAuthenticationProvider?
//    {
//        val authProvider                    = DaoAuthenticationProvider()
//        //Сервис для поиска УЗ в СУБД.
//        authProvider.setUserDetailsService(userDetailsService)
//        //Объект класса для шифрования паролей.
//        authProvider.setPasswordEncoder(passwordEncoder)
//        return authProvider
//    }
//    /****************************************************************************************************
//     * Установка объекта класса для проверки УЗ в настройки авторизации приложения.                     *
//     ***************************************************************************************************/
//    override fun configure(
//        auth                                : AuthenticationManagerBuilder?
//    )
//    {
//        auth?.authenticationProvider(authProvider())
//
//    }

    @Autowired
    fun configureGlobal(
        auth                                : AuthenticationManagerBuilder
    ) {
//        val keycloakAuthenticationProvider  = keycloakAuthenticationProvider()
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(
//            SimpleAuthorityMapper())
        //auth.authenticationProvider(keycloakAuthenticationProvider)
        auth.authenticationProvider(keycloakAuthenticationProvider())
    }

    @Bean
    override fun sessionAuthenticationStrategy(

    )                                       : SessionAuthenticationStrategy?
    {
        return RegisterSessionAuthenticationStrategy(
            SessionRegistryImpl())
    }



}