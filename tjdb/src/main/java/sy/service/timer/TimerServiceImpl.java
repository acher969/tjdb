package sy.service.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.HttpRequestMapper;
import sy.serviceI.TimerServiceI;

@Service("timerService")
public class TimerServiceImpl implements TimerServiceI{

	private HttpRequestMapper mapper;

	public HttpRequestMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(HttpRequestMapper mapper) {
		this.mapper = mapper;
	}
	
	/**
	 * 定时任务入口
	 */
	public void timer(){
		System.out.println("---------------定时任务执行--------------");
		userOnlineCheck();
	}
	
	public void userOnlineCheck(){
		mapper.updateOnlineTimeout();//将在线超时用户强制下线
	}
}
