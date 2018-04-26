package sy.serviceI;

import java.util.List;

import sy.model.SysRoleModule;
import sy.service.module.ModuleData;
import sy.service.role.RoleData;

public interface RoleServiceI {

	RoleData getRolePageList(RoleData data);
	List<ModuleData> getModuleList(String id);
	List<ModuleData> getChildModuleList(String parentId,String roleId);
	void saveRoleModule(String []arr,String roleId) throws Exception;
	void updateState(RoleData data) throws Exception;
	void deleteRole(RoleData data) throws Exception;
	void saveRole(RoleData data) throws Exception;
}
