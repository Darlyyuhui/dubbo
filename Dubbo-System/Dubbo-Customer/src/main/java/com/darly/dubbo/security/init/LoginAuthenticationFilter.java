package com.darly.dubbo.security.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**重写UsernamePasswordAnthenticationFilter
 * UsernamePasswordAnthenticationFilter的obtainUsername和obtainPassword方法的注释已经说了，
 * 可以让子类来自定义用户名和密码的获取工作。但是我们不打算重写这两个方法，而是重写它们的调用者attemptAuthentication方法，
 * 因为json反序列化毕竟有一定消耗，不会反序列化两次，只需要在重写的attemptAuthentication方法中检查是否json登录，
 * 然后直接反序列化返回Authentication对象即可。这样我们没有破坏原有的获取流程，
 * 还是可以重用父类原有的attemptAuthentication方法来处理表单登录。
 * Author : ZhangYuHui
 * Date : 2018/1/4
 * TODO :
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //attempt Authentication when Content-Type is json
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                ||request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            //use jackson to deserialize json
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()){
//                AuthenticationBean authenticationBean = mapper.readValue(is,AuthenticationBean.class);
//                authRequest = new UsernamePasswordAuthenticationToken(
//                        authenticationBean.getUsername(), authenticationBean.getPassword());
            }catch (IOException e) {
                e.printStackTrace();
                new UsernamePasswordAuthenticationToken(
                        "", "");
            }finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }else {
            //transmit it to UsernamePasswordAuthenticationFilter
            return super.attemptAuthentication(request, response);
        }
    }
}
