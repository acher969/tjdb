package sy.controller;

import java.util.List;

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
import sy.common.Util;
import sy.service.role.RoleData;
import sy.service.user.UserData;
import sy.serviceI.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController{

	private UserServiceI service;

	public UserServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(UserServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getPageList(UserData inputData,@ModelAttribute("data") UserData data){
		data=service.getUserListPage(data);
		return "user/list";
	}
	
	@RequestMapping("delUser")
	public void delUser(UserData data,HttpServletResponse response){
		String ids=data.getId();
		String []arr=ids.split(",");
		JSONObject json=new JSONObject();
		try {
			service.delUserByIds(arr);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openCreate")
	public String openCreate(UserData data){
		System.out.println(data.getLoginName());
		return "user/create";
	}
	
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") UserData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
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
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openUpdate")
	public String openUpdate(UserData inputData,Model model){
		inputData=service.getUserById(inputData);
		model.addAttribute("data",inputData);
		return "user/edit";
	}
	
	@RequestMapping("updateActive")
	public void updateActive(UserData inputData,HttpServletResponse response){
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
	public void update(UserData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
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
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openPwd")
	public String openPwd(UserData data){
		
		return "user/pwd";
	}
	
	@RequestMapping("updatePwd")
	public void updatePwd(UserData inputData,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updatePwd(inputData);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
//			e.printStackTrace();
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("batchDel")
	public void batchDel(@RequestParam("ids")String ids,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String []arr=ids.split(",");
		try {
			service.delUserByIds(arr);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openRoleEdit")
	public void openRoleEdit(@RequestParam("id")String id,HttpServletResponse response){
		List<RoleData> list=service.getUserRoleTree(id);
		JSONArray jsonarr=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject json=new JSONObject();
			json.put("id", list.get(i).getId());
			json.put("text", list.get(i).getName());
			json.put("iconCls", "icon-ok");
			if(Util.isCon(list.get(i).getType())){
				json.put("checked", true);
			}else{
				json.put("checked", false);
			}
			jsonarr.add(json);
		}
		StringUtil.outPrintJsonArr(jsonarr, response);
	}
	
	@RequestMapping("updateUserRole")
	public void updateUserRole(@RequestParam("roleIds")String roleIds,@RequestParam("userId")String userId,HttpServletResponse response){
		JSONObject json=new JSONObject();
		String []arr=roleIds.split(",");
		try {
			service.updateUserRole(arr, userId);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
}
