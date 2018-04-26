package sy.frame.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.InitializingBean;

import sy.frame.ConfigCodesData;
import sy.frame.ConstantClass;


public class LoadListener implements InitializingBean{
	

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		String xml=ConstantClass.SYS_CONFIG_PATH;
        SAXReader reader = new SAXReader();  
        Document document = reader.read(new File(this.getClass().getResource("/").getPath()+"/"+xml));  
        Element root = document.getRootElement();
        Element sysNameNode=root.element("sys_name");
        ConstantClass.SYS_NAME=sysNameNode.getText();
        System.out.println("------------------------------------");
        System.out.println(ConstantClass.SYS_NAME);
        System.out.println("------------------------------------");
        
        System.out.println("------------加载下拉框----------");
		xml=ConstantClass.CONFIG_CODES_PATH;
        reader = new SAXReader();  
        document = reader.read(new File(this.getClass().getResource("/").getPath()+"/"+xml));  
        root = document.getRootElement();
        Element foo;
        ConstantClass.CODE_MAP =new HashMap<String, List>();
        for (Iterator i = root.elementIterator("Code"); i.hasNext();) {   
        	foo = (Element) i.next();  
        	ConfigCodesData data=new ConfigCodesData();
    		data.setCodeName(foo.elementText("codeName"));
    		data.setCodeType(foo.elementText("codeType"));
    		data.setCodeValue(foo.elementText("codeValue"));
    		List<ConfigCodesData> list;
        	if(ConstantClass.CODE_MAP.containsKey(foo.elementText("codeType"))){
        		//存在key
        		list=ConstantClass.CODE_MAP.get(foo.elementText("codeType"));
        		list.add(data);
        	}else{
        		list=new ArrayList<ConfigCodesData>();
        		list.add(data);
        	}
        	ConstantClass.CODE_MAP.put(foo.elementText("codeType"), list);
        }
	}
}
