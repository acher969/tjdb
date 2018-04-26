package sy.service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.dao.RoomMapper;
import sy.frame.HelperPage;
import sy.serviceI.RoomServiceI;

@Service("roomService")
public class RoomServiceImpl implements RoomServiceI{
	
	private RoomMapper mapper;
	
	public RoomMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(RoomMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public RoomData getRoomListPage(RoomData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<RoomData> pageList=mapper.getRoomListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public boolean save(RoomData data)throws Exception{
			data.setId(PrimaryId.getId());
			mapper.save(data);
			return true;
	}
	
	@Override
	public boolean delRoomByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		for(int i=0;i<str.length;i++){
			int count=mapper.getLesson(str[i]);
			if(count>0){
				return false;
			}else{
				mapper.delRoomByIds(str);
			}
		}
		return true;
	}

	@Override
	public RoomData getRoomById(RoomData data) {
		// TODO Auto-generated method stub
		return mapper.getRoomById(data);
	}
	@Override
	public boolean update(RoomData data) throws Exception {
		// TODO Auto-generated method stub
			mapper.update(data);
			return true;
	}
}
