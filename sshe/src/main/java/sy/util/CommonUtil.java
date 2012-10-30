package sy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("unchecked")
public class CommonUtil {
	
	private static final String BUSINESSMG="businessMg";
	private static final String PICMG="picMg";
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public static Date getDate(long str){
		Date date=new Date(str*1000);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
		return date;
	}
	public static Integer contain(String str,char ch) {
		int count=0;
		for(int i=0;i<str.length();i++){
			if(ch==str.charAt(i))
				count++;
		}
		return count;
	}
	/**
	 * 将Date 转换成Long
	* @Title: getLongByDate
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param date
	* @param @return
	* @return long
	* @author 周张豹
	* @throws long
	 */
	public static long getLongByDate(Date date){
		long lSysTime = date.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		return lSysTime;
	}
	/**
	 * 获取N天时间段的时间  （返回格式String类型 2012-08-27 00:00:00）
	* @Title: getSectionTime
	* @Description: TODO 使用方法：n 表示查询天数，例如 今天时间段 n=0;昨天n=1;近一周n=7；取值的时 开始时间 map.get("startTime")；截止时间map.get("endTime")
	* @param @param n
	* @param @return
	* @return Map<String,String>
	* @author 周张豹
	* @throws Map<String,String>
	 */
	public static Map<String, String> getSectionTimeStr(Integer n){
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal=Calendar.getInstance();
		Calendar cale=Calendar.getInstance();
        cal.add(Calendar.DATE,-n);
        if (n== 0) {
        	 cale.add(Calendar.DATE,-0);
		} else {
			 cale.add(Calendar.DATE,-1);
		}
       
        Date s=cal.getTime();
        Date e = cale.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        map.put("startTime", sp.format(s)+" 00:00:00");//开始时间
        map.put("endTime", sp.format(e)+" 23:59:59");//截止时间
        return map;
        
	}
	/**
	 * 获取N天时间段的时间  （返回格式Long类型 ）
	* @Title: getSectionTimeLong
	* @Description: TODO(使用方法：n 表示查询天数，例如 今天时间段 n=0;昨天n=1;近一周n=7；取值的时 开始时间 map.get("startTime")；截止时间map.get("endTime")
	* @param @param n
	* @param @return
	* @return Map<String,Long>
	* @author 周张豹
	* @throws Map<String,Long>
	 */
	public static Map<String,Long> getSectionTimeLong(Integer n){
		Map<String, Long> map = new HashMap<String, Long>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, String> mapstr = CommonUtil.getSectionTimeStr(n);
			Date startTime = sdf.parse(mapstr.get("startTime"));//获取开始时间
			Date endTime = sdf.parse(mapstr.get("endTime"));//获取截止时间
			map.put("startTime", CommonUtil.getLongByDate(startTime));
			map.put("endTime", CommonUtil.getLongByDate(endTime));
		} catch (ParseException e) {
			System.err.println("获取时间段出现问题");
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 将实体属性值转换成报表xml
	* @Title: convertCharts
	* @Description: TODO 将实体属性值转换成报表xml
	* @param pojo
	* @return
	* @return String
	* @author 周张豹
	 */
	public static  String convertCharts(Object pojo,Map<String, String> map){; 
		String xml = "";
		Class temp = pojo.getClass();
		try{  
		    Field[] fa = temp.getDeclaredFields(); 	 
		    for(int j=0;j<fa.length;j++){ 
				String cn = fa[j].getName();
				Object value=null;
				Method m3 = temp.getDeclaredMethod(getMethod(cn),null);
				value=m3.invoke(pojo,null)==null?"0":m3.invoke(pojo, null);	
				if (map.get(cn) != null) {
					xml =xml+ "<set name='"+map.get(cn)+"' value='"+value+"' />";
				}
			} 
		}catch(Exception e){ 
			System.err.println("实体"+pojo+"生成报表xml出现错误！");
			e.printStackTrace(); 
		} 
		System.out.println(xml);
		return xml;
	}
	
	private static String getMethod(String field){
		String method ="get";
		if(field!=null && field!=""){
			field  = field.substring(0,1).toUpperCase()+field.substring(1);
        }
		method = method+field;
		return method;
	}
	/**
	 *  获取当月第一天,返回字符串
	 *  @author wangmei
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}
	/**
	 *  获取当月最后一天,返回字符串
	 *  @author wangmei
	 * @return
	 */
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}
	/**
	 *  获取上月第一天的日期
	 *  @author wangmei
	 * @return
	 */
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}
	/**
	 *  获得上月最后一天的日期
	 *  @author wangmei
	 * @return
	 */
	public static String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}
	/**
	 *  生成6位随机数
	 *  @author wangmei
	 * @return
	 */
	public static String getRandomNumber(int lenght)
	{
		String[] randomValues = new String[]{"0","1","2","3","4","5","6","7","8","9"};
		StringBuffer str = new StringBuffer();
		for(int i = 0;i < lenght; i++)
		{
			Double number=Math.random()*(randomValues.length-1);
			str.append(randomValues[number.intValue()]);
		}
	  return str.toString();
	}
	public static Long getDateStrToLong(String str){
		Long lSysTime1 = null ;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = sdf.parse(str);
			lSysTime1 = date1.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lSysTime1;
	}
	public static int getDateNow(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		//Date date = new Date();
		long lSysTime = new Date().getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
	    return 0;
	}
	public static String changePath(String str){
		str=str.replaceAll(BUSINESSMG, PICMG);
		return str;
	}
	/**
	 *  将字符串时间转换长Long时间
	* @Title: getDateLong
	* @Description: TODO 将字符串时间转换长Long时间
	* @param str
	* @return
	* @return Long
	* @author 周张豹
	 */
	public static List<Long> getDateLong(String str){
		List<Long> time = new ArrayList<Long>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = sdf.parse(str+" 00:00:00");
			Date date2 = sdf.parse(str+" 59:59:59");
			Long lSysTime1 = date1.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
			Long lSysTime2 = date2.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
			time.add(lSysTime1);
			time.add(lSysTime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	
	/**
	 * 返回不重复的11位数
	 */
	public static String getUnRepeatNum(){
		String temp=System.currentTimeMillis()+"";
		temp=temp.substring(5, temp.length())+Math.round(Math.random()*1000);
		return temp;
	}
	
	
	public static void urlConnectionPost(String test_url) {
	    StringBuilder responseBuilder = null;
	    BufferedReader reader = null;
	    OutputStreamWriter wr = null;

	    URL url;
	    try {
	        url = new URL(test_url);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        conn.setConnectTimeout(1000 * 5);
	        wr = new OutputStreamWriter(conn.getOutputStream());
	        wr.write("");
	        wr.flush();

	        // Get the response
	        reader = new BufferedReader(new InputStreamReader(conn
	                .getInputStream()));
	        responseBuilder = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            responseBuilder.append(line + "\n");
	        }
	        wr.close();
	        reader.close();
	        System.out.println(responseBuilder.toString());
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	}
	

	public static void main(String[] args) {
		urlConnectionPost("http://demo2.test.com/api/unserialize.php?data=a:3:{s:4:%22spec%22;a:2:{s:1:%228%22;s:2:%2243%22;s:2:%2211%22;s:9:%22%E6%B5%85%E8%93%9D%E8%89%B2%22;}s:13:%22spec_value_id%22;a:2:{s:1:%228%22;s:3:%22119%22;s:2:%2211%22;s:3:%22144%22;}s:21:%22spec_private_value_id%22;a:2:{s:1:%228%22;s:11:%2287175758783%22;s:2:%2211%22;s:11:%2287175758784%22;}}");
	}
}
