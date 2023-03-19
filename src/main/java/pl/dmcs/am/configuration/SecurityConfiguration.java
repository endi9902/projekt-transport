package pl.dmcs.am.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import pl.dmcs.am.dao.AppUserRepository;
import pl.dmcs.am.domain.AppUser;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name="myAppUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("anna").password("{noop}anna").roles("USER");
        auth.inMemoryAuthentication().withUser("a").password("{noop}a").roles("USER");
        //auth.userDetailsService(userDetailsService)
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
 }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/appUsers*").permitAll()//access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/appUserRole*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/addAppUser*").permitAll()
                .antMatchers("/adminPanel*").access("hasRole('ADMIN')")
                .antMatchers("/connections*").access("hasRole('ADMIN')or hasRole('USER')")
                .antMatchers("/tickets*").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/addConnection").access("hasRole('ADMIN')")
                .antMatchers("/addTicket").access("hasRole('USER')")
                .antMatchers("/findConnection").access("hasRole('USER')")
                .and().formLogin().loginPage("/login").permitAll()
                .usernameParameter("login").passwordParameter("password")
                .failureForwardUrl("/?error")
                .and().logout().logoutSuccessUrl("/?logout")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}