package sy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMain {


	@Test
	public void test1() {
//		SysUser user=loginService.getNameById("admin");
//		System.out.println(user.getName());
//		System.out.println(Class.class.getClass().getResource("/").getPath());
		System.out.println("123123");
	}
//	
//	@Test
//	public void test2(){
//		List<SysUser> list=userService.getAll();
//		logger.info(JSON.toJSONString(list));
//	}
//	
//	@Test
//	public void testPageHelper(){
//		Page<SysUser> page = PageHelper.startPage(2, 5);
//		List<SysUser> list=userService.getAll();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getUserName());
//		}
//		System.out.println(page.getPages());
//	}
@Test
public void test666() {
	System.out.println("kdkdkdkd");
}
}
