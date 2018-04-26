package sy.service.classhour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.ClassHourMapper;
import sy.frame.HelperPage;
import sy.service.lesson.LessonData;
import sy.serviceI.ClassHourServiceI;

@Service("ClassHourService")
public class ClassHourServiceImpl implements ClassHourServiceI{

	private ClassHourMapper mapper;

	public ClassHourMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(ClassHourMapper mapper) {
		this.mapper = mapper;
	}
	@Override
	public ClassHourData getStudentPageList(ClassHourData data) {
		// TODO Auto-generated method stub
		HelperPage.getPage(data);//开始分页
		List<ClassHourData> pageList=mapper.getStudentPageList(data);
		HelperPage.setPageMessage(data, pageList);//装入分页信息
		data.setPageList(pageList);
		return data;
	}
	@Override
	public List<ClassHourData> getStudentLessonList(String id) {
		// TODO Auto-generated method stub
		
		return mapper.getStudentLessonList(id);
	}
	
	
}
