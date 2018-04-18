package log4jdemo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/*
 * 日志（log）
 * --主要用来记录系统运行中一些重要操作信息
 * --便于监视系统运行情况，帮助用户提前发现和避开可能出现的问题，或者出现问题后根据日志找到原因
 * 日志分类
 * --SQL日志、异常日志、业务日志
 * log4j
 * --控制日志的输出级别
 * --控制日志信息传送的目的地是控制台、文件等
 * --控制每一条日志的输出格式
 * 
 * 使用log4j记录日志步骤
 * --1、在项目中加入log4j的jar文件
 * --2、创建log4j.properties文件
 * --3、配置日志信息
 * --4、使用log4j记录日志信息
 */
public class Test {

	private static Logger logger = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("输入除数");
			int num1 = sc.nextInt();
			logger.info("输入了被除数"+num1);
			int num2 = sc.nextInt();
			logger.info("输入了除数"+num2);
			System.out.println(String.format("%d / %d = %d", num1, num2, num1/ num2));
			logger.debug("两数的结果是："+String.format("%d / %d = %d", num1, num2, num1/ num2));
		}catch(InputMismatchException e){
			e.printStackTrace();
			logger.error("输入的类型不匹配");
		}catch(ArithmeticException e){
			e.printStackTrace();
			logger.error("除数不能为零");
		}catch(Exception e){
			e.printStackTrace();
			logger.fatal("不可预知的异常");
		}finally{
			System.out.println("welcome");
		}
	}
}
