package sy.serviceI;

import java.util.List;

import sy.model.SysUserRole;
import sy.service.role.RoleData;
import sy.service.user.UserData;

public interface UserServiceI {

	UserData getUserListPage(UserData data);
	void delUserByIds(String []str) throws Exception;
	boolean save(UserData data)throws Exception;
	void updateActive(UserData data) throws Exception;
	UserData getUserById(UserData data);
	boolean update(UserData data) throws Exception;
	void updatePwd(UserData data) throws Exception;
	List<RoleData> getUserRoleTree(String userId);
	void updateUserRole(String []arr,String userId) throws Exception;
}
