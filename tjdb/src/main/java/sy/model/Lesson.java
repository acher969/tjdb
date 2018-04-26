package sy.model;

import sy.frame.BaseData;

public class Lesson extends BaseData{
	
	private String id;
	//课堂名称
	private String name;
	//教师id
	private String teacher_id;
	//直播间id
	private String room_id;
	//课时
	private String class_hour;
	//课程状态(0关闭，1直播中)
	private String oline_type;
	
	public String getId() {
		
		return id;
		
	}
	
	public void setId(String id) {
		
		this.id = id == null ? null : id.trim();
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name == null ? null : name.trim();
		
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id == null ? null : teacher_id.trim();
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id == null ? null : room_id.trim();
	}

	public String getClass_hour() {
		return class_hour;
	}

	public void setClass_hour(String class_hour) {
		this.class_hour = class_hour == null ? null : class_hour.trim();
	}

	public String getOline_type() {
		return oline_type;
	}

	public void setOline_type(String oline_type) {
		this.oline_type = oline_type == null ? null : oline_type.trim();
	}
	
}
