package sy.service.aboutclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.PrimaryId;
import sy.dao.AboutClassMapper;
import sy.frame.HelperPage;
import sy.serviceI.AboutClassServiceI;

@Service("aboutClassService")
public class AboutClassServiceImpl implements AboutClassServiceI{

	private AboutClassMapper mapper;

	public AboutClassMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(AboutClassMapper mapper) {
		this.mapper = mapper;
	}
	@Override
	public void save(AboutClassData data) throws Exception {
		// TODO Auto-generated method stub
		data.setId(PrimaryId.getId());
		data.setType("0");
		mapper.save(data);
	}
	
	@Override
	public AboutClassData getPageList(AboutClassData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<AboutClassData> pageList=mapper.getPageList(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	@Override
	public void updateType(AboutClassData data) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateType(data);
	}
	
	
}
