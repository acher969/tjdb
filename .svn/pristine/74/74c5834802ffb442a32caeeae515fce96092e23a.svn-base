package sy.serviceI;

import java.util.List;
import java.util.Map;

import sy.service.lesson.LessonData;
import sy.service.student.StudentData;

public interface StudentServiceI {

	StudentData getStudentListPage(StudentData data);
	boolean delStudentByIds(String []str) throws Exception;
	boolean save(StudentData data)throws Exception;
	void updateActive(StudentData data) throws Exception;
	StudentData getStudentById(StudentData data);
	boolean update(StudentData data) throws Exception;
	void updatePwd(StudentData data) throws Exception;
	Map<String,String> getLessonList(StudentData data) throws Exception;
	Map<String,String> getLessonById(StudentData data) throws Exception;
	boolean saveLesson(StudentData data)throws Exception;
}
