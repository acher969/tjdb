package sy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sy.common.StringUtil;
import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;
import sy.service.lesson.LessonData;
import sy.service.student.StudentData;
import sy.serviceI.StudentServiceI;

@Controller
@RequestMapping("/studentController")
public class StudentController{

	private StudentServiceI service;

	public StudentServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(StudentServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(StudentData inputData,@ModelAttribute("data") StudentData data){
		data=service.getStudentListPage(data);
		return "student/list";
	}
	
	@RequestMapping("delStudent")
	public void delStudent(StudentData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			boolean bool=service.delStudentByIds(arr);
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
	public String openCreate(StudentData data,Model model){
		System.out.println(data.getLogin_name());
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		return "student/create";
	}
	@RequestMapping("openCreate2")
	public String openCreate2(StudentData data,Model model){
		System.out.println(data.getLogin_name());
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		return "teacher/create";
	}
	
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") StudentData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(data.getName()== null ||"".equals(data.getName())){
			json.put("success", "name");
		}else if(data.getLogin_name()== null ||"".equals(data.getLogin_name())){
			json.put("success", "login_name");
		}else if(data.getPassword()== null ||"".equals(data.getPassword())){
			json.put("success", "password");
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
	public String openUpdate(StudentData inputData,Model model){
		inputData=service.getStudentById(inputData);
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("sex");
		model.addAttribute("list", codeList);
		model.addAttribute("data",inputData);
		return "student/edit";
	}
	
	@RequestMapping("updateActive")
	public void updateActive(StudentData inputData,HttpServletResponse response){
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
	public void update(StudentData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(inputData.getName()== null ||"".equals(inputData.getName())){
			json.put("success", "name");
		}else if(inputData.getLogin_name()== null ||"".equals(inputData.getLogin_name())){
			json.put("success", "login_name");
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
	public String openPwd(StudentData data){
		
		return "student/pwd";
	}
	
	@RequestMapping("updatePwd")
	public void updatePwd(StudentData inputData,HttpServletResponse response){
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
			boolean bool=service.delStudentByIds(arr);
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
	@RequestMapping("openLesson")
	public String openLesson(StudentData data,Model model){
		//Map<String, String> lesson;
		Map<String, String> hasLesson;
		try {
			hasLesson=service.getLessonById(data);
			//lesson = service.getLessonList(data);
			model.addAttribute("courses", hasLesson);
			//model.addAttribute("lesson", lesson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student/choose";
	}
	
	@RequestMapping("saveLesson")
	public void saveLesson(StudentData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
				service.saveLesson(data);
				json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("getTest")
	public void getTest(StudentData data,HttpServletRequest request,HttpServletResponse response){
		JSONArray jarr=new JSONArray();
		try {
			Map<String, String> lesson=service.getLessonList(data);
			for(String id:lesson.keySet()){
				JSONObject j1=new JSONObject();
				j1.put("id", id);
				j1.put("name", lesson.get(id));
				jarr.add(j1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringUtil.outPrintJsonArr(jarr, response);
		
		
	}
}
