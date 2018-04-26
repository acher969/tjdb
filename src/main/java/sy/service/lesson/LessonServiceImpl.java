package sy.service.lesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.dao.LessonMapper;
import sy.frame.HelperPage;
import sy.service.room.RoomData;
import sy.service.teacher.TeacherData;
import sy.serviceI.LessonServiceI;

@Service("lessonService")
public class LessonServiceImpl implements LessonServiceI{
	
	private LessonMapper mapper;
	
	public LessonMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(LessonMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public LessonData getLessonListPage(LessonData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<LessonData> pageList=mapper.getLessonListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public boolean save(LessonData data)throws Exception{
			data.setId(PrimaryId.getId());
			data.setOline_type("0");
			mapper.save(data);
			return true;
	}
	
	@Override
	public boolean delLessonByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		int count=mapper.haveStudent(str);
		if(count>0){
			return false;
		}else{
			mapper.delUserLesson(str);
			mapper.delLessonByIds(str);
			return true;
		}
	}

	@Override
	public LessonData getLessonById(LessonData data) {
		// TODO Auto-generated method stub
		return mapper.getLessonById(data);
	}
	@Override
	public boolean update(LessonData data) throws Exception {
		// TODO Auto-generated method stub
			mapper.update(data);
			return true;
	}
	
	@Override
	public Map<String,String> getTeacherList(LessonData data){
		List<TeacherData> teacherData=mapper.getTeacherList(data);
		Map<String,String> TeacherList=new HashMap<String, String>();
		for(TeacherData td:teacherData){
			TeacherList.put(td.getId(), td.getName());
		}
		return TeacherList;
	}
	@Override
	public Map<String,String> getRoomList(LessonData data){
		List<RoomData> roomData=mapper.getRoomList(data);
		Map<String,String> RoomList=new HashMap<String, String>();
		for(RoomData td:roomData){
			RoomList.put(td.getId(), td.getName());
		}
		return RoomList;
	}
	@Override
	public boolean haveTeacher(LessonData data){
		int count=mapper.haveTeacher(data);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean haveRoom(LessonData data){
		int count=mapper.haveRoom(data);
		if(count>0){
			return true;
		}
		return false;
	}
	
}
