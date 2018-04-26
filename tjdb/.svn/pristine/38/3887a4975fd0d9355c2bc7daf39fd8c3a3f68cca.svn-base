package sy.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.StringUtil;
import sy.service.aboutclass.AboutClassData;
import sy.service.user.UserData;
import sy.serviceI.AboutClassServiceI;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/mobileWebController")
public class MobileWebController {

	private AboutClassServiceI ACservice;

	public AboutClassServiceI getACservice() {
		return ACservice;
	}
	@Autowired
	public void setACservice(AboutClassServiceI aCservice) {
		ACservice = aCservice;
	}

	@RequestMapping("open_about_class")
	public String aboutClass(){
		return "mobile_web/about_class";
	}
	
	@RequestMapping("save")
	public void save(HttpServletResponse response,AboutClassData data){
		JSONObject json=new JSONObject();
		try {
			ACservice.save(data);
			json.put("success", true);
			json.put("message", "预约成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
			json.put("message", "预约失败，请拨打预约电话");
		}
		StringUtil.outPrintJson(json, response);
	}
	
	
}
