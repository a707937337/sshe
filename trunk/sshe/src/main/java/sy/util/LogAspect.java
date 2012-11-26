package sy.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-20 上午11:38:21
 */

@Aspect
public class LogAspect {
	/**
	 * 捕捉所有操作
	 * 
	 * 2012-11-20 上午11:39:29
	 */
	@Pointcut("execution(public * sy.service..*Impl.*(..))")
	public void allMethod(){
		
	}
//	/**
//	 * 捕捉所有添加操作
//	 */
//	@Pointcut("execution(public *sy.service.*.*.add*(..))")
//	public void addPointcut() {
//    }
//	
//	/**
//	 * 捕捉所有修改操作
//	 */
//	@Pointcut("execution(public * sy.service.*.*.update*(..))")
//	public void updatePointcut() {
//    }
//	
//	/**
//	 * 捕捉所有删除操作
//	 */
//	@Pointcut("execution(public * sy.service.*.*.delete*(..))")
//	public void deletePointcut() {
//    }
//	/**
//	 * 捕捉测试操作
//	 */
//	@Pointcut("execution(public * sy.service.*.*.test*(..))")
//	public void testPointcut() {
//    }
	
//	@Around("allMethod()")
//	public void test(ProceedingJoinPoint pjp) throws Exception{
//		System.out.println("方法执行前");
//		Object obj=null;
//		try {
//			obj=pjp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("方法执行后");
//		System.out.println(pjp.getSignature().getName());
//		System.out.println(pjp.getTarget().getClass().getName());
//	}
//	
	@Around("allMethod()")
	public void test2(ProceedingJoinPoint jp) throws Exception{
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(jp.getSignature().getName()+"~~~~~~~~~~~~");
		//throw new RuntimeException();
	}
}
