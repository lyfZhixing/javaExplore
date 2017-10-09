package staticProxy;
/**
 * 代理类
 * 黑脸是一个高冷的人，负责替白脸筛选帮助对象
 * 只有妹子能通过他的筛选
 * @author Administrator
 *
 */
public class BlackFace implements DoHelp {

	private WhiteFace wf = new WhiteFace();
	@Override
	public void buyMeal(String name) {
		
		if(name.equals("妹子")){
			wf.buyMeal(name);
		}
	}

	@Override
	public void fixPc(String name) {

		if(name.equals("妹子")){
			wf.fixPc(name);
		}
	}

}
