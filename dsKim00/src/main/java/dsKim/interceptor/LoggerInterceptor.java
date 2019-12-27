package dsKim.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggerInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		System.out.println("=============================pre handle method is calling===================================");
		return true;
	}
	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception{
		
		System.out.println("=======================================post handle method is calling===================================");
	}
	
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		
	} 
	
	
	
}
