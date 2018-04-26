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
import sy.common.Util;
import sy.model.SysModule;
import sy.service.module.ModuleData;
import sy.service.user.UserData;
import sy.serviceI.ModuleServiceI;

@Controller
@RequestMapping("/moduleController")
public class ModuleController {

	private ModuleServiceI service;

	public ModuleServiceI getService() {
		return service;
	}

	@Autowired
	public void setService(ModuleServiceI service) {
		this.service = service;
	}
	
	@RequestMapping("list")
	public String getList(){
		return "module/list";
	}
	
	@RequestMapping("tree")
	public void getTree(ModuleData data,HttpServletResponse response){
		if(!Util.isCon(data.getParentId())){
			data.setParentId("00");
		}
		List<ModuleData> list=service.getTreeByParentId(data);
		//model.addAttribute("list", list);
		JSONArray jsarr=new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject json=new JSONObject();
			json.put("id", list.get(i).getId());
			json.put("parentId", list.get(i).getParentId());
			json.put("name", list.get(i).getName());
			json.put("url", list.get(i).getUrl());
			json.put("state", "closed");
			jsarr.add(json);
		}
		StringUtil.outPrintJsonArr(jsarr, response);
	}
	
	@RequestMapping("create")
	public String openCreate(HttpServletRequest request,@ModelAttribute("data") ModuleData data){
		String createType=request.getParameter("createType");
		if(createType.equals("1")){
			//新增同级节点
			data.setParentId(service.getParentId(data));
		}else if(createType.equals("2")){
			//新增子级节点
			data.setParentId(data.getId());
		}
		return "module/create";
	}
	
	@RequestMapping("save")
	public void save(@ModelAttribute("data") ModuleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			boolean bool=service.save(data);
			if(bool)
				json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("delete")
	public void delete(ModuleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.delete(data);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
	
	@RequestMapping("openEdit")
	public String openEdit(Model model,ModuleData data){
		data=service.getModuleById(data);
		model.addAttribute("data", data);
		return "module/edit";
	}
	
	@RequestMapping("updateMoule")
	public void updateMoule(ModuleData data,HttpServletResponse response){
		JSONObject json=new JSONObject();
		try {
			service.updateModule(data);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json.put("success", false);
		}
		StringUtil.outPrintJson(json, response);
	}
}
