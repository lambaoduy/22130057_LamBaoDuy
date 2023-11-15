package Lab9_taks2;

public class Magazine extends Book {
	private String name;

	public Magazine(String title, int numPage, int year, String authorName, double price, String name) {
		super(title, numPage, year, authorName, price);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n"+"Magazine [name=" + name + "]"+" "+ title +" year= "+year;
	}

}
