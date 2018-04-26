package sy.service.teacher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.Encrypt;
import sy.common.PrimaryId;
import sy.dao.TeacherMapper;
import sy.frame.HelperPage;
import sy.serviceI.TeacherServiceI;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherServiceI{

	SimpleDateFormat df = null;
	
	public TeacherServiceImpl() {
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	private TeacherMapper mapper;
	
	public TeacherMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(TeacherMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public TeacherData getTeacherListPage(TeacherData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<TeacherData> pageList=mapper.getTeacherListPage(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	
	@Override
	public boolean delTeacherByIds(String []str) throws Exception{
		// TODO Auto-generated method stub
		for(int i=0;i<str.length;i++){
			int count=mapper.getLesson(str[i]);
			if(count>0){
				return false;
			}else{
				mapper.delTeacherByIds(str);
			}
		}
		return true;
	}
	
	@Override
	public boolean save(TeacherData data)throws Exception{
		data.setId(PrimaryId.getId());
		int count=mapper.saveSelect(data);
		if(count>0){
			return false;
		}else{
			data.setPassword(Encrypt.EncryptString(data.getPassword()));
			data.setActive("1");
			data.setRole("1");
			data.setCreate_date(df.format(new Date()));
			mapper.save(data);
			return true;
		}
	}
	@Override
	public void updateActive(TeacherData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getActive().equals("1"))
			data.setActive("0");
		else
			data.setActive("1");
		mapper.updateActive(data);
	}
	
	@Override
	public TeacherData getTeacherById(TeacherData data) {
		// TODO Auto-generated method stub
		return mapper.getTeacherById(data);
	}
	@Override
	public boolean update(TeacherData data) throws Exception {
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
	public void updatePwd(TeacherData data) throws Exception {
		// TODO Auto-generated method stub
		data.setPassword(Encrypt.EncryptString(data.getPassword()));
		mapper.updatePwd(data);
	}

}
