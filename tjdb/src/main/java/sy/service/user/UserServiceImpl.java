package sy.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.Encrypt;
import sy.common.PrimaryId;
import sy.dao.UserMapper;
import sy.frame.HelperPage;
import sy.model.SysUserRole;
import sy.service.role.RoleData;
import sy.serviceI.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI{

	private UserMapper mapper;
	
	public UserMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public UserData getUserListPage(UserData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<UserData> pageList=mapper.getUserListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public void delUserByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		mapper.delUserByIds(str);
		for(int i=0;i<str.length;i++){
			mapper.deleteUserRoleByUserId(str[i]);
		}
	}
	
	@Override
	public boolean save(UserData data)throws Exception{
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			data.setPassword(Encrypt.EncryptString(data.getPassword()));
			data.setId(PrimaryId.getId());
			data.setActive("1");
			mapper.save(data);
			return true;
		}
	}
	@Override
	public void updateActive(UserData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getActive().equals("1"))
			data.setActive("0");
		else
			data.setActive("1");
		mapper.updateActive(data);
	}
	
	@Override
	public UserData getUserById(UserData data) {
		// TODO Auto-generated method stub
		return mapper.getUserById(data);
	}
	@Override
	public boolean update(UserData data) throws Exception {
		// TODO Auto-generated method stub
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			mapper.update(data);
			return true;
		}
	}
	@Override
	public void updatePwd(UserData data) throws Exception {
		// TODO Auto-generated method stub
		data.setPassword(Encrypt.EncryptString(data.getPassword()));
		mapper.updatePwd(data);
	}
	@Override
	public List<RoleData> getUserRoleTree(String userId) {
		// TODO Auto-generated method stub
		return mapper.getUserRoleTree(userId);
	}
	@Override
	public void updateUserRole(String []arr,String userId) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteUserRoleByUserId(userId);//删除原来权限
		List<SysUserRole> list=new ArrayList<SysUserRole>();
		for(int i=0;i<arr.length;i++){
			SysUserRole data=new SysUserRole();
			data.setId(PrimaryId.getId());
			data.setRoleId(arr[i]);
			data.setUserId(userId);
			list.add(data);
		}
		mapper.saveUserRole(list);
	}

}
