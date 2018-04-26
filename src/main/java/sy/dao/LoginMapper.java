package sy.dao;

import java.util.List;

import sy.model.SysModule;
import sy.model.SysRole;
import sy.model.SysUser;
import sy.service.login.LoginData;

public interface LoginMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);
    
    SysUser loginSelect(SysUser user);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    List<SysRole> getUserRole(String id);
    
    List<SysModule> getUserTopModule(List<SysRole> list);
    
    List<SysModule> getLeftModules(LoginData data);
}