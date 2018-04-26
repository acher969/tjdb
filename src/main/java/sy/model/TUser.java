package sy.model;

import java.util.List;

import sy.frame.BaseData;

public class TUser  extends BaseData{

	private String id;//` VARCHAR(50) NOT NULL,
	private String login_name;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '登录名',
	private String password;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '密码',
	private String name;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '姓名',
	private String sex;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '性别（0男，1女）',
	private String effective_date;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '生效日期',
	private String failure_date;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '失效日期',
	private String nickname;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '昵称',
	private String tel;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '电话',
	private String email;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	private String role;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '角色（0学生，1教师，2助教）',
	private String address;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '地址',
	private String online_type;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '在线状态',
	private String active;//` CHAR(2) NULL DEFAULT NULL COMMENT '状态（1启用，0停用）',
	private String create_date;//` VARCHAR(50) NULL DEFAULT NULL COMMENT '创建时间',
	//选课复选框
    private List<String> courses;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}
	public String getFailure_date() {
		return failure_date;
	}
	public void setFailure_date(String failure_date) {
		this.failure_date = failure_date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOnline_type() {
		return online_type;
	}
	public void setOnline_type(String online_type) {
		this.online_type = online_type;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
}
