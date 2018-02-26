package com.s63d.registrationsystem.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.userdetails.User


@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
//        http
//                .authorizeRequests()
//                .antMatchers("/login*", "/css/**", "/js/**", "/images/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//               .defaultSuccessUrl("/index")
//                .failureUrl("/login?error")
//                .and()
//                .logout().logoutSuccessUrl("/login")
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
       val user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build()

        auth.inMemoryAuthentication()
                .withUser(user)
    }


}