package ru.studyit.demoonlineshoprest.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import ru.studyit.demoonlineshoprest.repositories.IRepositoryUsers

/********************************************************************************************************
 * Сервис, позволяющий проверять учётные данные пользователей.                                          *
 * @author Селетков И.П. 2021 1203.                                                                     *
 *******************************************************************************************************/
@Component
class CServiceUserDetails                   : UserDetailsService
{
    @Autowired
    private lateinit var repositoryUsers    : IRepositoryUsers

    @Autowired
    private lateinit var passwordEncoder    : PasswordEncoder

    override fun loadUserByUsername(
            login                           : String
    )                                       : UserDetails
    {
        val user                            = repositoryUsers.findByLogin(login)

        user                                ?: throw UsernameNotFoundException("User not found")

        val authorities                     = listOf(SimpleGrantedAuthority("user"))

        return User(user.login, passwordEncoder.encode(user.password), authorities)
    }
}

//public class MongoUserDetailsService implements {
//    @Autowired
//    private UsersRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = repository.findByUsername(username);
//
//        if(user == null) {
//            throw new UsernameNotFoundException(“User not found”);
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(“user”));
//
//        return new User(user.getUsername(), user.getPassword(), authorities);
//}