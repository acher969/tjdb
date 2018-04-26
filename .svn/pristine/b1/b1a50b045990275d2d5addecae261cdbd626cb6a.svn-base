/**
 * Copy Right Information   : lccx 
 * JDK version used         : jdk1.6
 * Comments                 : 框架启动默认的初始化controller
 * Version                  : 1.0
 * create date              : 2017.03.29
 * author                   ：刘硕
*/
package sy.frame;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.Util;
import sy.model.SysUser;

@Controller
@RequestMapping("/initController")
public class InitController {

	@RequestMapping("init")
	public String init(@ModelAttribute("sysUser") SysUser sysUser,Model model,HttpSession session){
		if(Util.isCon(session.getAttribute(ConstantClass.SESSION_USER)))
			return ConstantClass.SYS_HOME_PAGE;
		else
			return ConstantClass.SYS_LOGIN_PAGE;
	}

}
