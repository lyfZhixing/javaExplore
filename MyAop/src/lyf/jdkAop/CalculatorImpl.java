package lyf.jdkAop;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a+b);
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
