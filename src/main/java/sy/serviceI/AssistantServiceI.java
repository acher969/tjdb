package sy.serviceI;

import sy.service.assistant.AssistantData;

public interface AssistantServiceI {

	AssistantData getAssistantListPage(AssistantData data);
	void delAssistantByIds(String []str) throws Exception;
	boolean save(AssistantData data)throws Exception;
	void updateActive(AssistantData data) throws Exception;
	AssistantData getAssistantById(AssistantData data);
	boolean update(AssistantData data) throws Exception;
	void updatePwd(AssistantData data) throws Exception;
}
