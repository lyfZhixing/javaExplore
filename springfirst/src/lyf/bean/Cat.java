package lyf.bean;

public class Cat implements Pets {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("cat play......");
	}

}
