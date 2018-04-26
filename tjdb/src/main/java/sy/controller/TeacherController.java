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
import sy.service.teacher.TeacherData;
import sy.serviceI.TeacherServiceI;

@Controller
@RequestMapping("/teacherController")
public class TeacherController{

	private TeacherServiceI service;

	public TeacherServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(TeacherServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(TeacherData inputData,@ModelAttribute("data") TeacherData data){
		data=service.getTeacherListPage(data);
		return "teacher/list";
	}
	
	@RequestMapping("delTeacher")
	public void delTeacher(TeacherData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			boolean bool=service.delTeacherByIds(arr);
			if(bool){
				json.put("success", true);
			}else{
				json.put("success", "have");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openCreate")
	public String openCreate(TeacherData data,Model model){
		System.out.println(data.getLogin_name());
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		return "teacher/create";
	}
	
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") TeacherData data,HttpServletResponse response){
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
	public String openUpdate(TeacherData inputData,Model model){
		inputData=service.getTeacherById(inputData);
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		model.addAttribute("data",inputData);
		return "teacher/edit";
	}
	
	@RequestMapping("updateActive")
	public void updateActive(TeacherData inputData,HttpServletResponse response){
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
	public void update(TeacherData inputData,HttpServletResponse response){
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
	public String openPwd(TeacherData data){
		
		return "teacher/pwd";
	}
	
	@RequestMapping("updatePwd")
	public void updatePwd(TeacherData inputData,HttpServletResponse response){
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
			boolean bool=service.delTeacherByIds(arr);
			if(bool){
				json.put("success", true);
			}else{
				json.put("success", "have");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
}
