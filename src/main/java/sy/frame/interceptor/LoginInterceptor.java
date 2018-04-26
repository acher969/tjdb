package sy.frame.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sy.common.Util;
import sy.frame.ConstantClass;
import sy.model.SysUser;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		if(url.indexOf("init.action")>=0||url.indexOf("login.action")>=0)
			return true;
		HttpSession session = request.getSession();
		SysUser user=(SysUser)session.getAttribute(ConstantClass.SESSION_USER);
		if(Util.isCon(user)){
			if(Util.isCon(user.getName())){
				//request.getRequestDispatcher("../loginController/index.action").forward(request, response); 
				return true;
			}
		}
		request.getRequestDispatcher("../initController/init.action").forward(request, response);  
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}


}
