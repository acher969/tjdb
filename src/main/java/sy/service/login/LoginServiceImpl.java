package sy.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.LoginMapper;
import sy.model.SysModule;
import sy.model.SysRole;
import sy.model.SysUser;
import sy.serviceI.LoginServiceI;

@Service("loginService")
public class LoginServiceImpl implements LoginServiceI{

	private LoginMapper mapper;

	public LoginMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(LoginMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public SysUser loginSelect(SysUser user) {
		// TODO Auto-generated method stub
		SysUser data=mapper.loginSelect(user);
		return data;
	}
	@Override
	public List<SysRole> getUserRole(String id) {
		// TODO Auto-generated method stub
		return mapper.getUserRole(id);
	}
	@Override
	public List<SysModule> getUserTopModule(List<SysRole> list) {
		// TODO Auto-generated method stub
		return mapper.getUserTopModule(list);
	}
	@Override
	public List<SysModule> getLeftModules(LoginData data) {
		// TODO Auto-generated method stub
		return mapper.getLeftModules(data);
	}
}
