package com.spring.tester.config;

import com.spring.tester.config.jwt.JwtAuthenticationFilter;
import com.spring.tester.config.jwt.JwtAuthorizationFilter;
import com.spring.tester.filter.MyFilter2;
import com.spring.tester.modules.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
@EnableWebSecurity // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.addFilterBefore(new MyFilter2(), SecurityContextPersistenceFilter.class) // 가장 첫번째 Security Filter 전에 등록
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable() // 기본 id,pw 으로 인증하는 방식 (안쓰고 토큰 방식 쓰려고 disable 처리)
                // 여기까지 form 미사용 security 기본 셋팅
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // 직접 login 시 동작할 필터 걸어줌. AuthenticationManager 으로 로그인 진행해야해서 주입
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository)) // 권한 체크할 페이지 요청 시 필터 동작.
                .authorizeRequests()
                .antMatchers("/api/v1/user/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/manager/**")
                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();
    }

}