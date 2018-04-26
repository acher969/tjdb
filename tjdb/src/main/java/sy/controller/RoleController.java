package sy.controller;

import java.util.List;
import java.util.Map;

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
import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;
import sy.service.module.ModuleData;
import sy.service.role.RoleData;
import sy.serviceI.RoleServiceI;

@Controller
@RequestMapping("/roleController")
public class RoleController {

	private RoleServiceI service;

	public RoleServiceI getService() {
		return service;
	}

	@Autowired
	public void setService(RoleServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getRolePageList(@ModelAttribute("data") RoleData data){
		data=service.getRolePageList(data);
		return "role/list";
	}
	
	@RequestMapping("moduleList")
	public void getModuleList(@RequestParam("id")String id,HttpServletResponse response){
		List<ModuleData> list=service.getModuleList(id);
		JSONArray jsonarr=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject json=new JSONObject();
            json.put("id", list.get(i).getId());
            json.put("text", list.get(i).getName());
            json.put("state", "closed");
            jsonarr.add(json);
		}
		StringUtil.outPrintJsonArr(jsonarr, response);
	}
	
	@RequestMapping("childModuleList")
	public void getChildModuleList(@RequestParam("parentId")String parentId,@RequestParam("roleId")String roleId,HttpServletResponse response){
		List<ModuleData> list=service.getChildModuleList(parentId,roleId);
		JSONArray jsonarr=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject json=new JSONObject();
            json.put("id", list.get(i).getId());
            json.put("text", list.get(i).getName());
            json.put("state", "closed");
            if(!Util.isCon(list.get(i).getChecked())){
            	json.put("checked", false);
            }else{
            	json.put("checked", true);
            }
            jsonarr.add(json);
		}
		StringUtil.outPrintJsonArr(jsonarr, response);
	}
	
	@RequestMapping("updateModuleRole")
	public void updateModuleRole(@RequestParam("ids")String ids,@RequestParam("roleId")String roleId,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			String []arr=ids.split(",");
			service.saveRoleModule(arr, roleId);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("updateState")
	public void updateState(RoleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updateState(data);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("deleteRole")
	public void deleteRole(RoleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.deleteRole(data);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openCreate")
	public String openCreate(Model model,RoleData data){
		System.out.println("---------------------------");
		List<ConfigCodesData> codeList=ConstantClass.CODE_MAP.get("type");
		model.addAttribute("list", codeList);
		model.addAttribute("data", data);
		return "role/create";
	}
	
	@RequestMapping("saveRole")
	public void saveRole(RoleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.saveRole(data);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
}
