package sy.dao;

import java.util.List;

import sy.service.assistant.AssistantData;

public interface AssistantMapper {

	List<AssistantData> getAssistantListPage(AssistantData data);
	void delAssistantByIds(String []str);
	void save(AssistantData data);
	int saveSelect(AssistantData data);
	void updateActive(AssistantData data);
	AssistantData getAssistantById(AssistantData data);
	void update(AssistantData data);
	void updatePwd(AssistantData data);
}
