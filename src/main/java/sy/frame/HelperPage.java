package sy.frame;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class HelperPage{

	public static void getPage(BaseData data){
		PageHelper.startPage(data.getPageNumber(),data.getPageRows());
	}
	
	public static void setPageMessage(BaseData data,List list){
		Page<BaseData> page = (Page<BaseData>)list;
		data.setPageTotal(page.getTotal());
		data.setPageCountRows(page.getPages());
	}
}
