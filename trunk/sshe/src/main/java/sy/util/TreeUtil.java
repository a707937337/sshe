/**
 * 
 */
package sy.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoying
 *
 */
public class TreeUtil {
	public static void getRightList(List<String> list){
	  if(list!=null&&list.size()>0){
		  String temp=null;
		  int length=0;	
		  boolean find=false;
		  for(int i=0;i<list.size();i++){
			  find=false;
			  temp=list.get(i);					
			  if(temp!=null&&temp.length()%3==0){
				  length=temp.length();
				 for(int j=1;(j*3)<length;j++){
					if(list.contains(temp.substring(0, j*3))){
						list.remove(temp);	
						find=true;
						break;
					}
				 }	
				 if(find) i--;
			  }
		  }
	  }
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("001".substring(0,3));
          List<String> list=new ArrayList<String>();
          list.add("002002006");
          list.add("001");
         // list.add("002002");
         
          list.add("002003001");
          list.add("002003001007");
          list.add("002003");
         // list.add("002");
          TreeUtil.getRightList(list);
          for(int i=0;i<list.size();i++){
        	  System.out.println(list.get(i));
          }
          
	}

}
