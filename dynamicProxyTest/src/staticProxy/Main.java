package staticProxy;

public class Main {

	public static void main(String[] args) {
		BlackFace bf = new BlackFace();
		bf.buyMeal("汉子");//汉子的请求无法送给WhiteFace
		bf.buyMeal("妹子");//妹子的请求可以送给WhiteFace
	}
	
	
}
