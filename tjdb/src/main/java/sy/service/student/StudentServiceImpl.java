package sy.service.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.Encrypt;
import sy.common.PrimaryId;
import sy.dao.StudentMapper;
import sy.frame.HelperPage;
import sy.model.TUser;
import sy.model.UserLesson;
import sy.service.lesson.LessonData;
import sy.serviceI.StudentServiceI;

@Service("studentService")
public class StudentServiceImpl implements StudentServiceI{

	SimpleDateFormat df = null;
	
	public StudentServiceImpl() {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	private StudentMapper mapper;
	
	public StudentMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(StudentMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public StudentData getStudentListPage(StudentData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<StudentData> pageList=mapper.getStudentListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public boolean delStudentByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		for(int i=0;i<str.length;i++){
			int count=mapper.getClassHour(str[i]);
			if(count>0){
				return false;
			}else{
				UserLesson data=new UserLesson();
				data.setUser_id(str[i]);
				mapper.delUserLesson(data);
				mapper.delStudentByIds(str);
			}
		}
		return true;
	}
	
	@Override
	public boolean save(StudentData data)throws Exception{
		data.setId(PrimaryId.getId());
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			data.setPassword(Encrypt.EncryptString(data.getPassword()));
			data.setActive("1");
			data.setRole("0");
			data.setCreate_date(df.format(new Date()));
			mapper.save(data);
			return true;
		}
	}
	@Override
	public void updateActive(StudentData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getActive().equals("1"))
			data.setActive("0");
		else
			data.setActive("1");
		mapper.updateActive(data);
	}
	
	@Override
	public StudentData getStudentById(StudentData data) {
		// TODO Auto-generated method stub
		return mapper.getStudentById(data);
	}
	@Override
	public boolean update(StudentData data) throws Exception {
		// TODO Auto-generated method stub
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			mapper.update(data);
			return true;
		}
	}
	@Override
	public void updatePwd(StudentData data) throws Exception {
		// TODO Auto-generated method stub
		data.setPassword(Encrypt.EncryptString(data.getPassword()));
		mapper.updatePwd(data);
	}
	
	@Override
	public Map<String,String> getLessonList(StudentData data){
		List<LessonData> lessonData=mapper.getLessonList(data);
		Map<String,String> lessonList=new HashMap<String, String>();
		for(LessonData ld:lessonData){
			lessonList.put(ld.getId(), ld.getName());
		}
		return lessonList;
	}
	
	@Override
	public Map<String,String> getLessonById(StudentData data){
		List<LessonData> lessonData= mapper.getLessonById(data);
		Map<String,String> lessonList=new HashMap<String, String>();
		for(LessonData ld:lessonData){
			lessonList.put(ld.getId(), ld.getName());
		}
		return lessonList;
	}
	
	@Override
	public boolean saveLesson(StudentData data)throws Exception{
		if(data.getStr()!=null&&!"".equals(data.getStr())){
			String []arr=data.getStr().split(",");
			UserLesson userLessonData=new UserLesson(); 
			userLessonData.setUser_id(data.getId());
			List<LessonData> lessons=mapper.getLessonById(data);
			for(int i=0;i<arr.length;i++){
				boolean b=true;
				for(LessonData l:lessons){
					if(arr[i].equals(l.getId())){
						b=false;
					}
				}
				if(b){
					userLessonData.setId(Integer.parseInt(mapper.getOrderNumber()));
					userLessonData.setLesson_id(arr[i]);
					String class_Hour=mapper.selectClassHour(arr[i]);
					userLessonData.setRemainder_class_hour(Integer.parseInt(class_Hour));
					mapper.saveLesson(userLessonData);
				}
			}
			for(LessonData l:lessons){
				boolean b=true;
				for(int i=0;i<arr.length;i++){
					if(l.getId().equals(arr[i])){
						b=false;
					}
				}
				if(b){
					UserLesson ul=new UserLesson();
					ul.setLesson_id(l.getId());
					ul.setUser_id(data.getId());
					mapper.delUserLessonByUserIdAndLessonId(ul);
				}
			}
		}else{
				UserLesson ul=new UserLesson();
				ul.setUser_id(data.getId());
				mapper.delUserLesson(ul);
		}
			return true;
	}
}
