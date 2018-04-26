package sy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sy.model.SysRoleModule;
import sy.service.module.ModuleData;
import sy.service.role.RoleData;

public interface RoleMapper {

	public List<RoleData> getRolePageList(RoleData data);
	public List<ModuleData> getModuleById(String id);
	public List<ModuleData> getModuleByParentId(@Param("parentId")String parentId,@Param("roleId")String roleId);
	public void deleteRoleModuleByRoleId(String roleId);
	public void insertRoleModule(List<SysRoleModule> list);
	public void updateState(RoleData data);
	public void deleteRoleById(RoleData data);
	public void deleteRoleModule(RoleData data);
	public void saveRole(RoleData data);
}
