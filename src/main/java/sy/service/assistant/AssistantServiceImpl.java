package sy.service.assistant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.Encrypt;
import sy.common.PrimaryId;
import sy.dao.AssistantMapper;
import sy.frame.HelperPage;
import sy.serviceI.AssistantServiceI;

@Service("assistantService")
public class AssistantServiceImpl implements AssistantServiceI{

	SimpleDateFormat df = null;
	
	public AssistantServiceImpl() {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	private AssistantMapper mapper;
	
	public AssistantMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(AssistantMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public AssistantData getAssistantListPage(AssistantData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<AssistantData> pageList=mapper.getAssistantListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public void delAssistantByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		mapper.delAssistantByIds(str);
	}
	
	@Override
	public boolean save(AssistantData data)throws Exception{
		data.setId(PrimaryId.getId());
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			data.setPassword(Encrypt.EncryptString(data.getPassword()));
			data.setActive("1");
			data.setRole("2");
			data.setCreate_date(df.format(new Date()));
			mapper.save(data);
			return true;
		}
	}
	@Override
	public void updateActive(AssistantData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getActive().equals("1"))
			data.setActive("0");
		else
			data.setActive("1");
		mapper.updateActive(data);
	}
	
	@Override
	public AssistantData getAssistantById(AssistantData data) {
		// TODO Auto-generated method stub
		return mapper.getAssistantById(data);
	}
	@Override
	public boolean update(AssistantData data) throws Exception {
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
	public void updatePwd(AssistantData data) throws Exception {
		// TODO Auto-generated method stub
		data.setPassword(Encrypt.EncryptString(data.getPassword()));
		mapper.updatePwd(data);
	}

}
