package sy.dao;

import java.util.List;

import sy.model.TRoomConfirm;
import sy.model.TUser;
import sy.service.httprequest.HttpLessonData;

public interface HttpRequestMapper {

	TUser getUser(TUser data);
	void updateUserCreateDate(String user_id);
	List<HttpLessonData> getLessonListByUserId(String user_id);
	int isRoomConfirmByStudentId(String user_id);//是否有需要确认的申请单
	TRoomConfirm getRoomConfirmByNow(String user_id);//根据现在时间查询某用户的确认单
	List<TUser> getStudentUserListByLessonId(String lesson_id);//根据课程id,查询该课程下所有课上课学生
	
	void saveRoomConfirm(TRoomConfirm data);
	int ifAllowedToAddFirst(TRoomConfirm data);//查询是否创建上课申请单第一步
	int ifAllowedToAddSecond(TRoomConfirm data);//第二步
	TRoomConfirm getRoomConfirmByStudentId(String user_id);//根据学生id查询当前需要确认的申请单
	
	void updateRoomConfirmByStudent(TRoomConfirm data);//学生确认，根据单子id
	void updateClassHour(TRoomConfirm data);
	String getUserRoleById(String id);//根据用户id，查询用户所属角色
	List<HttpLessonData> getAssistantLessonList();//助教获得课程列表
	
	void updateUserOnlineType(String id);//
	
	void updateOnlineTimeout();//timer调用，在线超时用户强制下线
	
	int getStudentRemainderClassHour(TRoomConfirm data);//根据课程和学生，查询剩余课时
}
