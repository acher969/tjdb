package sy.controller;

import java.util.List;

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
import sy.service.classhour.ClassHourData;
import sy.service.student.StudentData;
import sy.serviceI.ClassHourServiceI;

@Controller
@RequestMapping("/classHourController")
public class ClassHourController {

	private ClassHourServiceI service;

	public ClassHourServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(ClassHourServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("open")
	public String open(){
		return "classhour/list";
	}
	
	@RequestMapping("list")
	public void list(HttpServletRequest request,ClassHourData data,HttpServletResponse response){
		data.setPageNumber(Integer.parseInt(request.getParameter("page")));
		data.setStudentData(new StudentData());
		data.getStudentData().setName(request.getParameter("name"));
		data.getStudentData().setLogin_name(request.getParameter("login_name"));
		data=service.getStudentPageList(data);
		List<ClassHourData> list=data.getPageList();
		JSONArray jsarr=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject json=new JSONObject();
			json.put("id", list.get(i).getStudentData().getId());
			json.put("name", list.get(i).getStudentData().getName());
			json.put("tel", list.get(i).getStudentData().getTel());
			json.put("email", list.get(i).getStudentData().getEmail());
			if(list.get(i).getStudentData().getActive().equals("1")){
				json.put("active","启用");
			}else{
				json.put("active","停用");
			}
			
			jsarr.add(json);
		}
		JSONObject j=new JSONObject();
		j.put("total", data.getPageTotal());
		j.put("pageNumber", data.getPageNumber());
		j.put("rows", jsarr);
		StringUtil.outPrintJson(j, response);
		//return "classhour/list";
	}
	
	@RequestMapping("classhour")
	public String classhour(Model model,@RequestParam("id")String id){
		List<ClassHourData> list=service.getStudentLessonList(id);
		model.addAttribute("data", list);
		return "classhour/student_classhour";
	}
}
