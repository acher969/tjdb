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
import sy.service.room.RoomData;
import sy.serviceI.RoomServiceI;

@Controller
@RequestMapping("/roomController")
public class RoomController {
	
	private RoomServiceI service;

	public RoomServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(RoomServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(RoomData inputData,@ModelAttribute("data") RoomData data){
		data=service.getRoomListPage(data);
		return "room/list";
	}
	
	@RequestMapping("openCreate")
	public String openCreate(RoomData data,Model model){
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("cjmb");
		model.addAttribute("list", codeList);
		return "room/create";
	}
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") RoomData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(data.getName()== null ||"".equals(data.getName())){
			json.put("success", "name");
		}else if(data.getEffective_date()== null ||"".equals(data.getEffective_date())){
			json.put("success", "effective_date");
		}else if(data.getFailure_date()== null ||"".equals(data.getFailure_date())){
			json.put("success", "failure_date");
		}else if(data.getTeacher_url()== null ||"".equals(data.getTeacher_url())){
			json.put("success", "teacher_url");
		}else if(data.getStudent_url()== null ||"".equals(data.getStudent_url())){
			json.put("success", "student_url");
		}else if(data.getTeacher_password()== null ||"".equals(data.getTeacher_password())){
			json.put("success", "teacher_password");
		}else if(data.getStudent_password()== null ||"".equals(data.getStudent_password())){
			json.put("success", "student_password");
		}else if(data.getAssistant_password()== null ||"".equals(data.getAssistant_password())){
			json.put("success", "assistant_password");
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
	
	@RequestMapping("batchDel")
	public void batchDel(@RequestParam("ids")String ids,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String []arr=ids.split(",");
		try {
			boolean bool=service.delRoomByIds(arr);
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
	
	@RequestMapping("delRoom")
	public void delRoom(RoomData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			boolean bool=service.delRoomByIds(arr);
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
	
	@RequestMapping("openUpdate")
	public String openUpdate(RoomData inputData,Model model){
		inputData=service.getRoomById(inputData);
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("cjmb");
		model.addAttribute("list", codeList);
		model.addAttribute("data",inputData);
		return "room/edit";
	}
	
	@RequestMapping("update")
	public void update(RoomData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		if(inputData.getName()== null ||"".equals(inputData.getName())){
			json.put("success", "name");
		}else if(inputData.getEffective_date()== null ||"".equals(inputData.getEffective_date())){
			json.put("success", "effective_date");
		}else if(inputData.getFailure_date()== null ||"".equals(inputData.getFailure_date())){
			json.put("success", "failure_date");
		}else if(inputData.getTeacher_url()== null ||"".equals(inputData.getTeacher_url())){
			json.put("success", "teacher_url");
		}else if(inputData.getStudent_url()== null ||"".equals(inputData.getStudent_url())){
			json.put("success", "student_url");
		}else if(inputData.getTeacher_password()== null ||"".equals(inputData.getTeacher_password())){
			json.put("success", "teacher_password");
		}else if(inputData.getStudent_password()== null ||"".equals(inputData.getStudent_password())){
			json.put("success", "student_password");
		}else if(inputData.getAssistant_password()== null ||"".equals(inputData.getAssistant_password())){
			json.put("success", "assistant_password");
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

}
