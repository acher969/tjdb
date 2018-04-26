package sy.service.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.dao.RoleMapper;
import sy.frame.HelperPage;
import sy.model.SysRoleModule;
import sy.service.module.ModuleData;
import sy.serviceI.RoleServiceI;

@Service("roleService")
public class RoleServiceImpl implements RoleServiceI{

	private RoleMapper mapper;

	public RoleMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(RoleMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public RoleData getRolePageList(RoleData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<RoleData> pageList=mapper.getRolePageList(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}

	@Override
	public List<ModuleData> getModuleList(String id) {
		// TODO Auto-generated method stub
		return mapper.getModuleById(id);
	}

	@Override
	public List<ModuleData> getChildModuleList(String parentId,String roleId) {
		// TODO Auto-generated method stub
		return mapper.getModuleByParentId(parentId,roleId);
	}

	@Override
	public void saveRoleModule(String[] arr, String roleId) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteRoleModuleByRoleId(roleId);
		List<SysRoleModule> list=new ArrayList<SysRoleModule>();
		for(int i=0;i<arr.length;i++){
			SysRoleModule data=new SysRoleModule();
			data.setId(PrimaryId.getId());
			data.setModuleId(arr[i]);
			data.setRoleId(roleId);
			list.add(data);
		}
		mapper.insertRoleModule(list);
	}

	@Override
	public void updateState(RoleData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getState().equals("1"))
			data.setState("0");
		else
			data.setState("1");
		mapper.updateState(data);
	}

	@Override
	public void deleteRole(RoleData data) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteRoleModuleByRoleId(data.getId());
		mapper.deleteRoleById(data);
	}

	@Override
	public void saveRole(RoleData data) throws Exception {
		// TODO Auto-generated method stub
		data.setId(PrimaryId.getId());
		mapper.saveRole(data);
	}
}
