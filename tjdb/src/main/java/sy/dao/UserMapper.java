package sy.dao;

import java.util.List;

import sy.model.SysUserRole;
import sy.service.role.RoleData;
import sy.service.user.UserData;

public interface UserMapper {

	List<UserData> getUserListPage(UserData data);
	void delUserByIds(String []str);
	void save(UserData data);
	int saveSelect(UserData data);
	void updateActive(UserData data);
	UserData getUserById(UserData data);
	void update(UserData data);
	void updatePwd(UserData data);
	List<RoleData> getUserRoleTree(String userId);
	void deleteUserRoleByUserId(String userId);
	void saveUserRole(List<SysUserRole> list);
}
