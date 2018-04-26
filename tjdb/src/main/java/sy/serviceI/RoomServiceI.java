package sy.serviceI;

import sy.service.room.RoomData;

public interface RoomServiceI {
	
	RoomData getRoomListPage(RoomData data);
	boolean save(RoomData data)throws Exception;
	boolean delRoomByIds(String []str) throws Exception;
	RoomData getRoomById(RoomData data);
	boolean update(RoomData data) throws Exception;

}
