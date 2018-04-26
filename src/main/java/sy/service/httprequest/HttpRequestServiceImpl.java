package sy.service.httprequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.common.Util;
import sy.dao.HttpRequestMapper;
import sy.model.TRoomConfirm;
import sy.model.TUser;
import sy.serviceI.HttpRequestServiceI;

@Service("httpRequestService")
public class HttpRequestServiceImpl implements HttpRequestServiceI{

	private HttpRequestMapper mapper;

	public HttpRequestMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(HttpRequestMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public TUser userLogin(TUser data) {
		// TODO Auto-generated method stub
		data=mapper.getUser(data);
		if(Util.isCon(data))
			mapper.updateUserCreateDate(data.getId());
		return data;
	}

	@Override
	public List<HttpLessonData> getLessonList(String user_id) {
		// TODO Auto-generated method stub
		String role=mapper.getUserRoleById(user_id);
		if(role.equals("2")){
			//助教角色
			List<HttpLessonData> list=mapper.getAssistantLessonList();
			return list;
		}else{
			List<HttpLessonData> list=mapper.getLessonListByUserId(user_id);
			TRoomConfirm data=mapper.getRoomConfirmByNow(user_id);
			if(Util.isCon(data)){
				//有已经确认的课程
				for(int i=0;i<list.size();i++){
					if(list.get(i).getLesson_id().equals(data.getLesson_id())){
						list.get(i).setStudent_confirm("1");
						break;
					}
				}
			}
			return list;
		}

	}

	/**
	 * 返回1代表有待确认
	 * 返回大于1说明数据有问题
	 * 返回0说明没有待确认
	 */
	@Override
	public int isRoomConfirmByStudentId(String user_id) {
		// TODO Auto-generated method stub
		int count=mapper.isRoomConfirmByStudentId(user_id);
		return count;
	}
	
	/**
	 * 修改用户在线时间
	 */
	@Override
	public void updateUserDateNow(String user_id) throws Exception{
		mapper.updateUserCreateDate(user_id);
	}

	@Override
	public List<TUser> getStudentListByLessonId(String lesson_id) {
		// TODO Auto-generated method stub
		return mapper.getStudentUserListByLessonId(lesson_id);
	}

	@Override
	public boolean saveRoomConfirm(TRoomConfirm data) throws Exception {
		// TODO Auto-generated method stub
		int count=mapper.ifAllowedToAddFirst(data);
		count+=mapper.ifAllowedToAddSecond(data);
		if(count>0){
			return false;//直播间不空闲
		}else{
			int remainder_class_hour=mapper.getStudentRemainderClassHour(data);
			if(remainder_class_hour<data.getClass_hour()){
				return false;
			}else{
				data.setId(PrimaryId.getId());
				mapper.saveRoomConfirm(data);
				return true;
			}
		}
		//int count=mapper.ifAllowedToAdd(data);
	}

	@Override
	public TRoomConfirm getRoomConfirmByStudentId(String student_id) {
		// TODO Auto-generated method stub
		return mapper.getRoomConfirmByStudentId(student_id);
	}

	@Override
	public void updateRoomConfirmByStudent(TRoomConfirm data) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateRoomConfirmByStudent(data);
		mapper.updateClassHour(data);
	}

	@Override
	public void userOffLine(String id) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateUserOnlineType(id);
	}

}
