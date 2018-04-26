/**
 * Copy Right Information   : lccx
 * JDK version used         : jdk1.6
 * Comments                 : 框架使用的一些公共操作
 * Version                  : 1.0
 * create date              : 2017.03.28
 * author                   ：刘硕
 */
package sy.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Util {
	public final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat sdfDate = new SimpleDateFormat(
			"yyyy-MM-dd");
	public final static SimpleDateFormat sdfDate_8b = new SimpleDateFormat(
			"yyyyMMdd");
	public final static SimpleDateFormat sdfTime_14b = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public static String nowDate() {
		return sdfDate.format(new Date());
	}

	public static String nowDate_8b() {
		return sdfDate_8b.format(new Date());
	}

	public static String nowTime() {
		return sdfTime.format(new Date());
	}

	public static String nowTime_14b() {
		return sdfTime_14b.format(new Date());
	}

	/**
	 * 根据value值判断是否添加单引号(如果value是null则不加单引号)
	 * 
	 * @param
	 * @return :insert语句用到的字段值
	 */
	public static String toSqlVal(Object value) {
		if (value == null ||(value != null && value.toString().equals("null"))){
			return null;
		}else{
			
			String tag = "'";
			String rep = "''";
			
			value = StringUtil.replaceAll(value.toString(),tag,rep);
			
			return "'" + value.toString() + "'";
		}
	}
	
	/**为对象加入'' 组成'对象'形式,如果是null则返回null
	 * param:value:具体条件,type:F表示前面加%,B表示后面加,ALL表示前后都加
	 * return:包装后的字符串
	 * */
	public static String toSqlValLike(Object value,String type){
		if(value == null){
			return null;
		}else{
			if(type.equals("F")){
		
				return toSqlVal("%" + value.toString());
			}else if(type.equals("B")){
				return toSqlVal( value.toString() + "%");
			}else if(type.equals("ALL")){
				return toSqlVal("%" + value.toString() + "%");
				
			}
			return "";
		}
	}
	
	/**对象的非空验证
	 * param:Object
	 * return:是或者否
	 * */
	public static boolean isCon(Object obj){
		if(obj != null && !obj.toString().equals("") && !obj.toString().equals("null")){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	

	/**判断对象是否可以做为sql的查询条件
	 * param:Object
	 * return:是或者否
	 * */
	public static String concatLike(String str,String style){
		if(isCon(str)){
			if("before".equals(style)){
				str = "%" + str;
			}else if("after".equals(style)){
				str += "%";
			}else if("all".equals(style)){
				str = "%" + str + "%" ;
			}
		}else{
			return "";
		}
		
		return str;
	}
	
	public static String list2String(List list){
		String str = "(";
		
		
		for(int i = 0;i < list.size();i++){
			str += toSqlVal(list.get(i));
			
			if((i+1) != list.size()){
				str +=",";
			}
		}
		
		str += ")";
		return str;
	}
	

	

	
	/**
	 * datestr 为yyyy-MM-dd 格式的日期字符串      
	 * bforafnum 为之后或之前的月数  如果是之前  就传负数
	 * 返回规定时间   之前或之后规定月数  的时间  也返回yyyy-MM-dd 格式的字符串
	 */
	public static String dateBfOrAfTime(String datestr,int bforafnum) {
		String reStr="";
		try {
			Date now  = sdfDate.parse(datestr);
			 Calendar ca = Calendar.getInstance();
				ca.setTime(now);
				ca.add(Calendar.MONTH, bforafnum);
				reStr = sdfDate.format(ca.getTime());
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return reStr;
	}
	/**
	 * 附件下载
	 * 
	 * @param fileName
	 *            原始文件名称
	 * @param path
	 *            文件路径（URL）
	 * @param response
	 */
	public void download(String fileName, String path,
			HttpServletResponse response) throws SocketException {
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		if (fileName != null && !"".equals(fileName)) {
			try {
				String disposition = "UploadFiles;filename="
						+ URLEncoder.encode(fileName, "UTF-8");// 注意(1)
				response.setContentType("application/x-msdownload;charset=GBK");// 注意(2)
				response.setHeader("Content-disposition", disposition);
				fis = new FileInputStream(path);
				bis = new BufferedInputStream(fis);
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buffer = new byte[2048];
				while (fis.read(buffer) != -1) {
					bos.write(buffer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
					}
				}
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e) {

					}
				}
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}
	  
		 /**
		  * 分转元
		  */
	     //public static final String CURRENCY_FEN_REGEX = "[0-9]+"; 
		 public static String changeF2Y(int amount) {    
		       /* if(!String.valueOf(amount).matches(CURRENCY_FEN_REGEX)) {    
		            throw new Exception("金额格式有误");    
		        }  */  
		            
		        int flag = 0;    
		        String amString = String.valueOf(amount);    
		        if(amString.charAt(0)=='-'){    
		            flag = 1;    
		            amString = amString.substring(1);    
		        }    
		        StringBuffer result = new StringBuffer();    
		        if(amString.length()==1){    
		            result.append("0.0").append(amString);    
		       }else if(amString.length() == 2){    
		            result.append("0.").append(amString);    
		        }else{    
		            String intString = amString.substring(0,amString.length()-2);    
		            for(int i=1; i<=intString.length();i++){    
		                if( (i-1)%3 == 0 && i !=1){    
		                    result.append(",");    
		                }    
		               result.append(intString.substring(intString.length()-i,intString.length()-i+1));    
		            }    
		            result.reverse().append(".").append(amString.substring(amString.length()-2));    
		        }    
		        if(flag == 1){    
		            return "-"+result.toString();    
		        }else{    
		            return result.toString();    
		        }    
		    }    
		 /**   
		      * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额  
		      *   
		      * @param amount  
		      * @return  
		      */  
		     public static String changeY2F(String amount){   
		         String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额   
		         int index = currency.indexOf(".");   
		        int length = currency.length();   
		        Long amLong = 0l;   
		         if(index == -1){   
		             amLong = Long.valueOf(currency+"00");   
		        }else if(length - index >= 3){   
		            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));   
		        }else if(length - index == 2){   
		            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);   
		        }else{   
		            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");   
		         }   
		        return amLong.toString();   
		    }   
		     /**
		      * 获得指定日期的后一天
		      * 
		      * @param specifiedDay
		      * @return
		      */
		     public static String getSpecifiedDayAfter(String specifiedDay) {
		         Calendar c = Calendar.getInstance();
		         Date date = null;
		         try {
		             date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		         } catch (ParseException e) {
		             e.printStackTrace();
		         }
		         c.setTime(date);
		         int day = c.get(Calendar.DATE);
		         c.set(Calendar.DATE, day + 1);

		         String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
		                 .format(c.getTime());
		         return dayAfter;
		     }
		     /**
		      * 获得指定日期的前一天
		      * 
		      * @param specifiedDay
		      * @return
		      * @throws Exception
		      */
		     public static String getSpecifiedDayBefore(String specifiedDay) {
		         Calendar c = Calendar.getInstance();
		         Date date = null;
		         try {
		             date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		         } catch (ParseException e) {
		             e.printStackTrace();
		         }
		         c.setTime(date);
		         int day = c.get(Calendar.DATE);
		         c.set(Calendar.DATE, day - 1);

		         String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
		                 .getTime());
		         return dayBefore;
		     }
		     
	//获取访问者的ip地址,2012-10-09 add by mafei
	public static  String getIpAddr(HttpServletRequest request)  
	{
		String ip  =  request.getHeader( " x-forwarded-for " );
		if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  
		{
			ip  =  request.getHeader( " Proxy-Client-IP " );
		} 
		if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  
		{
			ip  =  request.getHeader( " WL-Proxy-Client-IP " );
		} 
		if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  
		{
			ip  =  request.getRemoteAddr();
		} 
		return  ip;
	}	
	
	//判断是否为内网ip,2012-10-09 add by mafei
	public static  boolean isInnerIp(String ip)  
	{
	 	if(ip!=null && ip.startsWith("10.5.31"))
	 	{
	 		return true;
	 	}
	 	else
	 	{
	 		return false;
	 	}
	}
	
	
	//根据访问者ip获取文件服务器地址,2012-10-09 add by mafei
//	public static  String getFileServerUrlByIp(HttpServletRequest request)  
//	{
//		String ip = Util.getIpAddr(request);
//	 	if(ip!=null && ip.length()>0)
//	 	{
//	 		if(ip.startsWith("10.5.31"))
//		 	{
//		 		return ConstantClass.FILE_SERVICE_IP_INNER;
//		 	}
//		 	else
//		 	{
//		 		return ConstantClass.FILE_SERVICE_IP_OUTER;
//		 	}
//	 	}
//	 	else
//	 	{
//	 		return "";
//	 	}
//	}
		     

}
