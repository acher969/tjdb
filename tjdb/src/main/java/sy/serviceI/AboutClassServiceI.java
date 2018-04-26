package sy.serviceI;

import sy.service.aboutclass.AboutClassData;

public interface AboutClassServiceI {

	public void save(AboutClassData data) throws Exception;
	public AboutClassData getPageList(AboutClassData data);
	public void updateType(AboutClassData data) throws Exception; 
}
