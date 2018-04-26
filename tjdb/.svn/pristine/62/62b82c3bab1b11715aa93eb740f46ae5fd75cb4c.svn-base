package sy.dao;

import java.util.List;
import java.util.Map;

import sy.service.lesson.LessonData;
import sy.service.room.RoomData;
import sy.service.teacher.TeacherData;

public interface LessonMapper {
	
	List<LessonData> getLessonListPage(LessonData data);
	void save(LessonData data);
	void delLessonByIds(String []str);
	LessonData getLessonById(LessonData data);
	void update(LessonData data);
	List<TeacherData> getTeacherList(LessonData data);
	List<RoomData> getRoomList(LessonData data);
	int haveStudent(String []str);
	int haveTeacher(LessonData data);
	int haveRoom(LessonData data);
	void delUserLesson(String []str);
}
