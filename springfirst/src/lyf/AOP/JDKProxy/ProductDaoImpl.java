package lyf.AOP.JDKProxy;

public class ProductDaoImpl implements ProductDao {

	
	@Override
	public void delete(String name) {
		System.out.println("delete "+name+"...");
	}

}
