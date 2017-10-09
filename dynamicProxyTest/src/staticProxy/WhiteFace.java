package staticProxy;

/**
 * 委托类
 * 白脸是一个乐于助人，不懂得拒绝的老好人，但是他不希望每个人都叫他帮忙
 * 于是找了黑脸来帮他筛选谁能找他帮忙
 * @author Administrator
 *
 */
public class WhiteFace implements DoHelp {

	@Override
	public void buyMeal(String name) {

		System.out.println("好的，帮你打饭");
	}

	@Override
	public void fixPc(String name) {

		System.out.println("好的，帮你修电脑");
	}

}
