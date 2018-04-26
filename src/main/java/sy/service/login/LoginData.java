package sy.service.login;

import java.util.List;

import sy.model.SysRole;
import sy.model.SysUser;

public class LoginData extends SysUser{

	private String moduleParentId;
	private List<SysRole> roleList;
	public String getModuleParentId() {
		return moduleParentId;
	}
	public void setModuleParentId(String moduleParentId) {
		this.moduleParentId = moduleParentId;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	
	
}
