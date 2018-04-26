package sy.dao;

import java.util.List;

import sy.service.room.RoomData;

public interface RoomMapper {
	
	List<RoomData> getRoomListPage(RoomData data);
	void save(RoomData data);
	void delRoomByIds(String []str);
	RoomData getRoomById(RoomData data);
	void update(RoomData data);
	int getLesson(String str);
}
