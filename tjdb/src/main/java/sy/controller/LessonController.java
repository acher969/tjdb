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

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sy.common.StringUtil;
import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;
import sy.service.lesson.LessonData;
import sy.serviceI.LessonServiceI;

@Controller
@RequestMapping("/lessonController")
public class LessonController {
	
	private LessonServiceI service;

	public LessonServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(LessonServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(LessonData inputData,@ModelAttribute("data") LessonData data){
		data=service.getLessonListPage(data);
		return "lesson/list";
	}
	
	@RequestMapping("openCreate")
	public String openCreate(LessonData data,Model model){
		Map<String, String> teacher;
		Map<String, String> room;
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lesson/choose";
	}
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") LessonData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(data.getName()== null ||"".equals(data.getName())){
			json.put("success", "name");
		}else if(data.getTeacher_id()== null ||"".equals(data.getTeacher_id())){
			json.put("success", "teacher");
		}else if(data.getRoom_id()== null ||"".equals(data.getRoom_id())){
			json.put("success", "room");
		}else if(data.getClass_hour()== null ||"".equals(data.getClass_hour())){
			json.put("success", "class_hour");
		}else{
			try {
				boolean a=service.haveTeacher(data);
				boolean b=service.haveRoom(data);
				if(a){
					if(b){
						service.save(data);
						json.put("success", true);
					}else{
						json.put("success", "noRoom");
					}
				}else{
					json.put("success", "noTeacher");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				json.put("success", false);
			}
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("batchDel")
	public void batchDel(@RequestParam("ids")String ids,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String []arr=ids.split(",");
		try {
			boolean bool=service.delLessonByIds(arr);
			if(bool)
			json.put("success", true);
			else
				json.put("success", "more");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("delLesson")
	public void delLesson(LessonData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			boolean bool=service.delLessonByIds(arr);
			if(bool)
			json.put("success", true);
			else
				json.put("success", "more");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openUpdate")
	public String openUpdate(LessonData inputData,Model model){
		inputData=service.getLessonById(inputData);
		model.addAttribute("data",inputData);
		Map<String, String> teacher;
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lesson/edit";
	}
	
	@RequestMapping("update")
	public void update(LessonData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(inputData.getName()== null ||"".equals(inputData.getName())){
			json.put("success", "name");
		}else{
		try {
			boolean bool=service.update(inputData);
			if(bool)
				json.put("success",true);
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
//	@RequestMapping("getTeachers")
//	public String getTeachers(LessonData data,HttpServletResponse response,Model model){
//		JSONObject json=new JSONObject();
//			try {
//				Map<String,String> m=service.getTeacherList();
//				model.addAttribute("data",m);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return "lesson/edit";
//	}
	
	@RequestMapping("getTest")
	public void getTest(HttpServletRequest request,HttpServletResponse response){
		JSONArray jarr=new JSONArray();
		String teacher=request.getParameter("q");
		LessonData data=new LessonData();
		data.setTeacher_id(teacher);
		try {
				Map<String,String> m=service.getTeacherList(data);
				for(String id:m.keySet()){
					JSONObject j1=new JSONObject();
					j1.put("id", id);
					j1.put("text", m.get(id));
					jarr.add(j1);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringUtil.outPrintJsonArr(jarr, response);
	}
	@RequestMapping("getTest2")
	public void getTest2(HttpServletRequest request,HttpServletResponse response){
		JSONArray jarr=new JSONArray();
		String room=request.getParameter("q");
		LessonData data=new LessonData();
		data.setRoom_id(room);
		try {
			Map<String,String> m=service.getRoomList(data);
			for(String id:m.keySet()){
				JSONObject j1=new JSONObject();
				j1.put("id", id);
				j1.put("text", m.get(id));
				jarr.add(j1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringUtil.outPrintJsonArr(jarr, response);
	}
	
}
