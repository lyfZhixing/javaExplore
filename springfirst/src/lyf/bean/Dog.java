package lyf.bean;

public class Dog implements Pets {

	private String name;
	
	
	public String getName() {
		return name;
	}

	public Dog() {
		super();
	}

	public Dog(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name+"777";
	}

	@Override
	public void play() {
		System.out.println("dog play......");
	}

}
