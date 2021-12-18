package com.spring.tester.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tester.config.auth.PrincipalDetails;
import com.spring.tester.modules.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter 가 있음.
// login 요청해서 username, password 전송하면 (post)
// UsernamePasswordAuthenticationFilter 동작을 함.
// formLogin disable 이기 때문에 필터만 만든다고 동작하지 않음. 직접 필터 걸어준다.
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // login 요청 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도중");

        try {
            // 1. username, password 받아서
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user.toString());

            // 1-2. 인증 토큰 생성
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // 2. 정상인지 로그인 시도 해봄. authenticationManager로 로그인 시도를 하면
            // PrincipalDetailsService가 호출 loadUserByUsername() 함수가 실행된 후 정상이면 authentication이 리턴됨.
            // authentication이 정상 리턴된다는 것은 -> DB에 있는 username과 password가 일치한다는 것.
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // 3. PrincipalDetails를 세션에 담고 (권한 관리 위해. 권한 1개뿐이라면 필요없음) => 로그인이 되었다는 뜻
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println(principalDetails.getUser().getUsername());

            return authentication;

        }catch(IOException e) {
            e.printStackTrace();
        }

        // 4. JWT 토큰 만들어서 응답하면 됨

        return null;
    }
}
