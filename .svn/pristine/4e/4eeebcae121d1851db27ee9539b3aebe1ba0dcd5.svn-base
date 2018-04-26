package sy.serviceI;

import java.util.Map;

import sy.service.lesson.LessonData;

public interface LessonServiceI {
	
	LessonData getLessonListPage(LessonData data);
	boolean save(LessonData data)throws Exception;
	boolean delLessonByIds(String []str) throws Exception;
	LessonData getLessonById(LessonData data);
	boolean update(LessonData data) throws Exception;
	Map<String,String> getTeacherList(LessonData data) throws Exception;
	Map<String,String> getRoomList(LessonData data) throws Exception;
	boolean haveTeacher(LessonData data);
	boolean haveRoom(LessonData data);

}
