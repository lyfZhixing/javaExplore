package lyf.AOP.JDKProxy;
/**
 * 测试类
 * @author lyf
 *
 */
public class JDKProxyTest {

	public static void main(String[] args) {
		ProductDao pd = (ProductDao) new LogProxy().bind(new ProductDaoImpl()) ;
		pd.delete("ben");
	}

}
