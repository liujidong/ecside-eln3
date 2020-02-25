package com.fjt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonUtils {
	/** 日志对象 */
	private static Log log = LogFactory.getLog(CommonUtils.class);
	
	/** 值是否为�? true: 空�?? false: 有�??*/
	public static boolean isNullValue(String value){
		boolean flag = false;
		if(null == value || value.trim().length() == 0){
			flag = true;
		}
		return flag;
	}
	
	/** yyyy-MM-dd HH:mm:ss格式日期转化成字符串 */
	public static String convertDateToString(Date date){
		String value = null;
		if(null != date){
			try{
				SimpleDateFormat sdf = new SimpleDateFormat(AspConstants.SIMPLE_DATE_FORMAT);
				value = sdf.format(date);
			}catch(Exception e){
				if(log.isDebugEnabled()){
					e.printStackTrace();
				}
			}
		}
		
		return value;
	}
	
	public static String convertIntegerToString(Integer value){
		String str = null;
		if(null != value){
			str = value.toString();
		}
		return str;
	}
	
	/**
	 * 转义部分特殊HTML字符
	 * @param str
	 * @return
	 */
	public static String htmlTextEncoder(String str){
		String str_tem = null;
		if(null != str){
			str_tem = str.replaceAll("<", "&lt;");   
			str_tem = str.replaceAll(">", "&rt;");   
			str_tem = str.replaceAll("\"", "&quot;");   
			str_tem = str.replaceAll("'", "&#039;");   
			str_tem = str.replaceAll(" ", "&nbsp;");   
			str_tem = str.replaceAll("\r\n", "<br>");   
			str_tem = str.replaceAll("\r", "<br>");   
			str_tem = str.replaceAll("\n", "<br>");   
		}
		
		return str_tem;
	}
	
	/**
	 * 双引号转单引�?
	 * @param str
	 * @return
	 */
	public static String convertDoubleQuToSingleQu(String str){
		return str.replaceAll("\"", "&#39;");
	}
	
	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		String resPrimkey = uuid.toString();
		String[] tempStrArray = resPrimkey.split("-");
		String pk = "";
		for (int a = 0; a < tempStrArray.length; a++) {
			pk = pk + tempStrArray[a];
		}
		return pk;
	}
}
