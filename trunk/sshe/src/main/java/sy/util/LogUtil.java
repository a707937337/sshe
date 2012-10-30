package sy.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {
  private static boolean lock=true;
  
  private static Log log = LogFactory.getLog(LogUtil.class.getClass());
  private static Log log_error = LogFactory.getLog("error");
  private static Log log_LongTime = LogFactory.getLog("LongTime");
  
  public static void log(String src){
	  if(lock){
		log.info(src);  
	  }
  }
 public static void error(String src,Exception e){
	 if(lock){
		 log_error.error(src,e);
	  }
  }
 public static void error(String src){
	 if(lock){
		 log_error.error(src);
	  }
  }
  public static void longtime(String src){
     if(lock){
    	 log_LongTime.fatal(src);
	  }
 }
  
  
  
  
  
  
}
