package book.store.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@SuppressWarnings("all")
public class securityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public securityConfiguration(PasswordEncoder passwordEncoder) {
        super();
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/*", "/js/*").permitAll()
                .antMatchers("/book/view/*")
                .hasAnyRole(userRole.USERS.name(), userRole.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/author/book/*")
                .hasRole(userRole.USERS.name())
                .antMatchers(HttpMethod.POST, "/book/single/savebook/*")
                .hasRole(userRole.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/book/update/*")
                .hasRole(userRole.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/book/delete/*")
                .hasRole(userRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and().httpBasic();
    }

    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails maruf = User.builder().username("maruf")
                .password(passwordEncoder.encode("maruf123"))
                .roles(userRole.USERS.name()).build();

        UserDetails ahmed = User.builder().username("ahmed")
                .password(passwordEncoder.encode("ahmed123"))
                .roles(userRole.ADMIN.name()).build();

        return new InMemoryUserDetailsManager(maruf, ahmed);
    }
}
