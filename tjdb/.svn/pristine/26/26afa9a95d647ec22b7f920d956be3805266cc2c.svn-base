/**
 * JDK version used         : jdk1.6
 * Comments                 : 本controller内的方法将不被全局拦截器拦截
 * Version                  : 1.0
 * create date              : 2017.09.26
 * author                   ：刘硕             
*/
package sy.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.common.DES;
import sy.common.StringUtil;
import sy.common.Util;
import sy.frame.ConstantClass;
import sy.model.TRoomConfirm;
import sy.model.TUser;
import sy.service.httprequest.HttpLessonData;
import sy.service.teacher.TeacherData;
import sy.serviceI.HttpRequestServiceI;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/excludeInterceptorController")
public class ExcludeInterceptorController {

	private HttpRequestServiceI service;
	
	public HttpRequestServiceI getService() {
		return service;
	}
	@Autowired
	public void setService(HttpRequestServiceI service) {
		this.service = service;
	}

	
	/**
	 * 登录请求
	 * @throws Exception 
	 */
	@RequestMapping("clientLogin")
	public void clientLogin(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			TUser data=new TUser();
			data.setLogin_name(json.getString("login_name"));
			data.setPassword(json.getString("password"));
			data=service.userLogin(data);
			if(Util.isCon(data)){
				//查询到用户
				
				json=JSONObject.parseObject(JSON.toJSONString(data));
				json.put("success", true);
			}else{
				json.put("success", false);
			}
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json=new JSONObject();
			json.put("success", "err");
			try {
				returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	/**
	 * 获取课程列表
	 */
	@RequestMapping("clientLessonList")
	public void clientLessonList(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			List<HttpLessonData> list=service.getLessonList(json.getString("Id"));
			
			String jarr=JSONObject.toJSONString(list);
			
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(jarr.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			json=new JSONObject();
			json.put("success", false);
		}
		
		StringUtil.outPrintStr(returnStr, response);
	}
	
	/**
	 * 学生无课监听（10秒一次）
	 * @param request
	 * @param response
	 */
	@RequestMapping("studentListener")
	public void studentListener(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			
			int count=service.isRoomConfirmByStudentId(json.getString("student_id"));
			if(count==1){
				json.put("success", true);
			}else if(count>1){
				json.put("success", "more");
			}else{
				json.put("success", false);
			}
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json=new JSONObject();
			json.put("success", "err");
			try {
				returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	/**
	 * 用户在线监听
	 */
	@RequestMapping("clientOnlineListener")
	public void clientOnlineListener(HttpServletRequest request,HttpServletResponse response){
		String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
		str=str.replaceAll(" ", "");
		JSONObject json=null;
		String returnStr=null;
		/**
		 * 业务处理
		 */
		
		try {
			String decStr=DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			String user_id=json.getString("Id");
			service.updateUserDateNow(user_id);
			json.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			json.put("success", false);
		}
		/**
		 * 加密返回
		 */
		try {
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	/**
	 * 根据课程id获取学生列表(教师使用)
	 * @param request
	 * @param response
	 */
	@RequestMapping("getStudentsBySubjectId")
	public void getStudentsBySubjectId(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 * 模拟数据
			 */
			
			String lesson_id=json.getString("lesson_id");
			List<TUser> list=service.getStudentListByLessonId(lesson_id);
			String jarr=JSONObject.toJSONString(list);
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(jarr,ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//json=new JSONObject();
			//json.put("success", false);
			//returnStr=DES.encrypt(json,ConstantClass.ENC_DEC_KEY);//加密返回数据
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	
	
	/**
	 * 学生打开上课申请单
	 * @param request
	 * @param response
	 */
	@RequestMapping("studentOpenConfirm")
	public void studentOpenConfirm(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 * 模拟数据
			 */
			
			String student_id=json.getString("student_id");
			TRoomConfirm data=service.getRoomConfirmByStudentId(student_id);
			String j=JSONObject.toJSONString(data);
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(j,ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//json=new JSONObject();
			//json.put("success", false);
			//returnStr=DES.encrypt(json,ConstantClass.ENC_DEC_KEY);//加密返回数据
		}
		StringUtil.outPrintStr(returnStr, response);
		
	}
	
	/**
	 * 学生确认上课申请单
	 * @param request
	 * @param response
	 */
	@RequestMapping("studentSubConfirm")
	public void studentSubConfirm(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			TRoomConfirm data=new TRoomConfirm();
			data.setId(json.getString("Id"));
			data.setLesson_id(json.getString("Lesson_id"));
			data.setStudent_id(json.getString("Student_id"));
//			data.setTeacher_id(json.getString("Teacher_id"));
			data.setClass_hour(json.getInteger("Class_hour"));
//			data.setBegin_time(json.getString("Begin_time"));
//			data.setEnd_time(json.getString("End_time"));
//			data.setStudent_confirm(json.getString("Student_confirm"));
			service.updateRoomConfirmByStudent(data);
			json.clear();
			
			json.put("success", true);
			
				
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json=new JSONObject();
			json.put("success", false);
			try {
				returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	/**
	 * 教师提交上课申请单
	 * @param request
	 * @param response
	 */
	@RequestMapping("teachserSubConfirm")
	public void teachserSubConfirm(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		String returnStr=null;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			TRoomConfirm data=new TRoomConfirm();
			data.setLesson_id(json.getString("Lesson_id"));
			data.setStudent_id(json.getString("Student_id"));
			data.setTeacher_id(json.getString("Teacher_id"));
			data.setClass_hour(json.getInteger("Class_hour"));
			data.setBegin_time(json.getString("Begin_time"));
			data.setEnd_time(json.getString("End_time"));
			data.setStudent_confirm(json.getString("Student_confirm"));
			boolean bool=service.saveRoomConfirm(data);
			json.clear();
			if(bool)
				json.put("success", true);
			else
				json.put("success", false);
			/**
			 * 加密返回
			 */
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);//加密返回数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json=new JSONObject();
			json.put("success", "err");
			try {
				returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	@RequestMapping("userOffLine")
	public void userOffLine(HttpServletRequest request,HttpServletResponse response){
		JSONObject json;
		try {
			String str=request.getParameter(ConstantClass.REQUEST_PARAM_NAME);//获取数据
			str=str.replaceAll(" ", "");
			String decStr = DES.decrypt(str, ConstantClass.ENC_DEC_KEY);//解密数据
			json=JSONObject.parseObject(decStr);//转换json
			/**
			 * 业务处理
			 */
			String id=json.getString("id");
			service.userOffLine(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
	}
	
	@RequestMapping("checkSystemUpdate")
	public void checkSystemUpdate(HttpServletRequest request,HttpServletResponse response){
		JSONObject json=new JSONObject();
		json.put("version", "1.2");
		String returnStr=null;
		try {
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	@RequestMapping("updateSystemUrl")
	public void updateSystemUrl(HttpServletRequest request,HttpServletResponse response){
		JSONObject json1=new JSONObject();
		json1.put("name", "tjdb.exe");
		json1.put("url","http://118.190.205.18/tjdb/update_system_download/1.2/tjdb.exe");
//		JSONObject json2=new JSONObject();
//		json2.put("name", "tjdb.pdb");
//		json2.put("url","http://118.190.205.18/tjdb/update_system_download/1.2/tjdb.pdb");
		JSONObject json3=new JSONObject();
		json3.put("name", "test.txt");
		json3.put("url","http://118.190.205.18/tjdb/update_system_download/1.2/test.txt");
		JSONArray jarr=new JSONArray();
//		jarr.add(json2);
		jarr.add(json1);
		jarr.add(json3);
		JSONObject json=new JSONObject();
		json.put("download_url","http://118.190.205.18/tjdb/download/setup.exe");
		json.put("updateList", jarr);
		String returnStr=null;
		try {
			returnStr=DES.encrypt(json.toString(),ConstantClass.ENC_DEC_KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		StringUtil.outPrintStr(returnStr, response);
	}
	
	
	
	
}
