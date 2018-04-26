package sy.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.Encrypt;
import sy.common.StringUtil;
import sy.common.Util;
import sy.frame.ConstantClass;
import sy.frame.InitController;
import sy.model.SysModule;
import sy.model.SysRole;
import sy.model.SysUser;
import sy.service.login.LoginData;
import sy.serviceI.LoginServiceI;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/loginController")
public class LoginController extends InitController{
	
	private LoginServiceI service;

	public LoginServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(LoginServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("login")
	public void login(LoginData data,HttpSession session,HttpServletResponse response) {
		data.setPassword(Encrypt.EncryptString(data.getPassword()));
		SysUser user=service.loginSelect(data);
		JSONObject json=new JSONObject();
		if(Util.isCon(user)){
			if(user.getActive().equals("1")){
				List<SysRole> list=service.getUserRole(user.getId());
				if(list.size()>0){
					json.put("success", true);
					session.setAttribute(ConstantClass.SESSION_USER, user);
					session.setAttribute(ConstantClass.SESSION_USER_ROLE, list);
					session.setAttribute(ConstantClass.SESSION_LOGIN_TYPE, "1");
				}else{
					json.put("success", "role");
				}
			}else{
				json.put("success", "role");
			}
		}else{
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("index")
	public String index(HttpSession session){
		return "index";
	}
	
	/**
	 * top页
	 * @param session
	 * @param topList
	 * @return
	 */
	@RequestMapping("top")
	public String top(HttpSession session,@ModelAttribute("data") SysModule data){
		List<SysRole> roleList=(List<SysRole>)session.getAttribute(ConstantClass.SESSION_USER_ROLE);
		List<SysModule> topList=service.getUserTopModule(roleList);
		data.setBaseList(topList);
		return "top";
	}
	
	@RequestMapping("left")
	public String left(HttpSession session,LoginData data,@ModelAttribute("data") SysModule moduleData){
		data.setRoleList((List<SysRole>)session.getAttribute(ConstantClass.SESSION_USER_ROLE));
		List<SysModule> list=service.getLeftModules(data);
		moduleData.setBaseList(list);
		return "left";
	}
	
	@RequestMapping("quit")
	public String quit(HttpSession session){
		session.invalidate();
		return "redirect:../initController/init.action";
	}
	
}
