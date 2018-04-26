package sy.serviceI;

import java.util.List;

import sy.model.TRoomConfirm;
import sy.model.TUser;
import sy.service.httprequest.HttpLessonData;

public interface HttpRequestServiceI {

	TUser userLogin(TUser data);
	
	List<HttpLessonData> getLessonList(String user_id);
	
	int isRoomConfirmByStudentId(String user_id);
	
	void updateUserDateNow(String user_id) throws Exception;
	
	List<TUser> getStudentListByLessonId(String lesson_id);
	
	boolean saveRoomConfirm(TRoomConfirm data) throws Exception;
	
	TRoomConfirm getRoomConfirmByStudentId(String student_id);
	
	void updateRoomConfirmByStudent(TRoomConfirm data) throws Exception;
	
	void userOffLine(String id) throws Exception;
}
