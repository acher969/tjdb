package sy.dao;

import java.util.List;

import sy.model.UserLesson;
import sy.service.lesson.LessonData;
import sy.service.student.StudentData;

public interface StudentMapper {

	List<StudentData> getStudentListPage(StudentData data);
	void delStudentByIds(String []str);
	void save(StudentData data);
	int saveSelect(StudentData data);
	void updateActive(StudentData data);
	StudentData getStudentById(StudentData data);
	void update(StudentData data);
	void updatePwd(StudentData data);
	List<LessonData> getLessonList(StudentData data);
	List<LessonData> getLessonById(StudentData data);
	void saveLesson(UserLesson data);
	String selectClassHour(String lessonId);
	String getOrderNumber();
	void delUserLesson(UserLesson data);
	void delUserLessonByUserIdAndLessonId(UserLesson data);
	int getClassHour(String str);
}
