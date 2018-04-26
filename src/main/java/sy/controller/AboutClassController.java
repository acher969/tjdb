package sy.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import sy.common.StringUtil;
import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;
import sy.service.aboutclass.AboutClassData;
import sy.serviceI.AboutClassServiceI;

@Controller
@RequestMapping("/aboutClassController")
public class AboutClassController {

	private AboutClassServiceI service;

	public AboutClassServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(AboutClassServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String list(@ModelAttribute("data") AboutClassData data,Model model){
		data=service.getPageList(data);
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("read_type");
		model.addAttribute("type_list", codeList);
		return "aboutclass/list";
	}
	
	@RequestMapping("update_type")
	public void update_type(AboutClassData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updateType(data);
			json.put("success", true);
			json.put("message", "操作完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
			json.put("message", "操作失败");
		}
		StringUtil.outPrintJson(json, response);
	}
}
