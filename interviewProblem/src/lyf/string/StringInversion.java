package lyf.string;
/**
 * 字符串倒置输出
 * @author 	lyf
 * 日期：		2017年10月25日
 */
public class StringInversion {

	public static void main(String[] args) {
		reverse3();
	}
	
	/**
	 * 方法一：利用String和StringBuffer的reverse()方法
	 */
	public static void reverse1(){
		String str = "abcde";
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * 方法二：利用String的toCharArray()和StringBuffer的append()方法
	 */
	public static void reverse2(){
		String str = "abcde";
		char[] chars = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < chars.length;i++){
			sb.append(chars[chars.length-i-1]);
		}
	}
	/**
	 * 方法三：用String的toCharArray()和String的构造方法public String(char[] args);
	 * 注意：循环 char[]的长度的1/2
	 */
	public static void reverse3(){
		String str = "abcde";
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length/2;i++){
			char temp = chars[i];
			chars[i] = chars[chars.length-i-1];
			chars[chars.length-i-1] = temp;
		}
		String str2 = new String(chars);
		System.out.println(str2);
	}
}
