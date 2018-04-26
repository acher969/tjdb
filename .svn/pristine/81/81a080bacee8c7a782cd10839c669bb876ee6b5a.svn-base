package sy.service.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.dao.ModuleMapper;
import sy.serviceI.ModuleServiceI;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleServiceI{

	private ModuleMapper mapper;

	public ModuleMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(ModuleMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ModuleData> getTreeByParentId(ModuleData data) {
		// TODO Auto-generated method stub
		return mapper.getTreeByParentId(data);
	}

	@Override
	public String getParentId(ModuleData data) {
		// TODO Auto-generated method stub
		return mapper.getParentId(data);
	}

	@Override
	public boolean save(ModuleData data){
		// TODO Auto-generated method stub
		if(data.getParentId().equals("root")){
			//创建模块
			data.setType("0");
		}else{
			data.setId(data.getParentId());
			String parentId=getParentId(data);
			if(parentId.equals("root")){
				//创建的是一级菜单
				data.setType("1");
			}
		}
		data.setId(PrimaryId.getId());
		mapper.save(data);
		return true;
	}

	@Override
	public void delete(ModuleData data) throws Exception{
		// TODO Auto-generated method stub
		mapper.deleteById(data);
	}

	@Override
	public ModuleData getModuleById(ModuleData data) {
		// TODO Auto-generated method stub
		return mapper.getModuleById(data);
	}

	@Override
	public void updateModule(ModuleData data) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateModule(data);
	}
	
	
	
	
}
