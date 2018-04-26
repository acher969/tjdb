package sy.model;

import sy.frame.BaseData;

public class TRoomConfirm extends BaseData{

	private String id;//` VARCHAR(50) NOT NULL,
	private String lesson_id;//` VARCHAR(50) NOT NULL COMMENT '课程id',
	private String student_id;//` VARCHAR(50) NOT NULL COMMENT '学生id',
	private String teacher_id;//` VARCHAR(50) NOT NULL COMMENT '教师id',
	private int class_hour;//` VARCHAR(50) NOT NULL COMMENT '本次课时',
	private String begin_time;//` VARCHAR(50) NOT NULL COMMENT '开始时间',
	private String end_time;//` VARCHAR(50) NOT NULL COMMENT '结束时间',
	private String student_confirm;//` CHAR(2) NOT NULL COMMENT '学生确认(0未确认，1已确认)',
	private String date;
	private String room_id;
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(String lesson_id) {
		this.lesson_id = lesson_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getClass_hour() {
		return class_hour;
	}
	public void setClass_hour(int class_hour) {
		this.class_hour = class_hour;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStudent_confirm() {
		return student_confirm;
	}
	public void setStudent_confirm(String student_confirm) {
		this.student_confirm = student_confirm;
	}
}
