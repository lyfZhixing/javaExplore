package lyf.Fibonacci;
/**
 * 0,1,1,2,3,5,8,13找出这个数列的通项公式，编程实现其前50项，每行显示5项，每项用Tab隔开，行尾不要分隔符
 * 菲波那切数列：F(n+2) = F(n) + F(n+1)
 * @author 	lyf
 * 日期：		2017年10月31日
 */
public class Fibonacci {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fibonacci2(8));
		for(int i = 1 ; i <= 50 ; i++){
			
			if(i%5 == 0){
				System.out.println();
			}else{
				if(i%5 == 1){
					System.out.print(fibonacci2(i));
				}
				System.out.print("\t"+fibonacci2(i));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
			
	}
	
	public static int fibonacci(int n){
		int result = 0;
		if(n == 1){
			result = 0;
		}else if(n == 3 || n == 2){
			result = 1;
		}else{
			result = fibonacci(n-2) + fibonacci(n-1);
		}
		
		return result;
	}
	
	public static int fibonacci2(int n){
		int[] arry = new int[n+1];
		arry[0] = 0;
		arry[1] = 1;
		for(int i = 2 ; i <= n ; i++){
			arry[i] = arry[i-1] + arry[i-2];
		}
		return arry[n-1];
	}
}
