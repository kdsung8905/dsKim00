package dsKim.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j

/*public class LoggerInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		log.debug("===========================================================     S T A R T     ===========================================================");
		return true;
	}
	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception{
		
		log.debug("===========================================================     E N D     ===========================================================");
	}
	
	
	
	
	
}*/

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		log.debug("===========================================================     S T A R T     ===========================================================");
		return super.preHandle(request, response, handler);
	}
	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception{
		
		log.debug("===========================================================     E N D     ===========================================================");
	}
}
