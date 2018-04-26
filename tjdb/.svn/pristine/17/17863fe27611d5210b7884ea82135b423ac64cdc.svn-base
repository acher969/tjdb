package sy.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import sy.common.StringUtil;
import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;
import sy.service.assistant.AssistantData;
import sy.serviceI.AssistantServiceI;

@Controller
@RequestMapping("/assistantController")
public class AssistantController{

	private AssistantServiceI service;

	public AssistantServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(AssistantServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(AssistantData inputData,@ModelAttribute("data") AssistantData data){
		data=service.getAssistantListPage(data);
		return "assistant/list";
	}
	
	@RequestMapping("delAssistant")
	public void delAssistant(AssistantData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			service.delAssistantByIds(arr);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openCreate")
	public String openCreate(AssistantData data,Model model){
		System.out.println(data.getLogin_name());
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		return "assistant/create";
	}
	
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") AssistantData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(data.getName()== null ||"".equals(data.getName())){
			json.put("success", "name");
		}else if(data.getLogin_name()== null ||"".equals(data.getLogin_name())){
			json.put("success", "login_name");
		}else{
			
			try {
				boolean bool=service.save(data);
				if(bool)
					json.put("success", true);
				else
					json.put("success", "more");
			} catch (Exception e) {
				// TODO Auto-generated catch block
//			e.printStackTrace();
				json.put("success", false);
			}
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openUpdate")
	public String openUpdate(AssistantData inputData,Model model){
		inputData=service.getAssistantById(inputData);
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		model.addAttribute("data",inputData);
		return "assistant/edit";
	}
	
	@RequestMapping("updateActive")
	public void updateActive(AssistantData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updateActive(inputData);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("update")
	public void update(AssistantData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(inputData.getName()== null ||"".equals(inputData.getName())){
			json.put("success", "name");
		}else if(inputData.getLogin_name()== null ||"".equals(inputData.getLogin_name())){
			json.put("success", "login_name");
		}else if(inputData.getPassword()== null ||"".equals(inputData.getPassword())){
			json.put("success", "password");
		}else{
			try {
				boolean bool=service.update(inputData);
				if(bool)
					json.put("success",true);
				else
					json.put("success", "more");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				json.put("success", false);
			}
			
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openPwd")
	public String openPwd(AssistantData data){
		
		return "assistant/pwd";
	}
	
	@RequestMapping("updatePwd")
	public void updatePwd(AssistantData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updatePwd(inputData);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("batchDel")
	public void batchDel(@RequestParam("ids")String ids,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String []arr=ids.split(",");
		try {
			service.delAssistantByIds(arr);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
}
