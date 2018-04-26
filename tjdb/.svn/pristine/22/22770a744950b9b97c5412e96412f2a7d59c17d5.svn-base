package sy.serviceI;

import java.util.List;

import sy.model.SysModule;
import sy.model.SysRole;
import sy.model.SysUser;
import sy.service.login.LoginData;

public interface LoginServiceI {

	SysUser loginSelect(SysUser user);
	
	List<SysRole> getUserRole(String id);
	
	List<SysModule> getUserTopModule(List<SysRole> list);
	
	List<SysModule> getLeftModules(LoginData data);
	
}
 