package Lab9_taks2;

import java.util.List;

public class ReferrenceBook extends Book {
	private String field;
	private List<Chapter> chapter;

	public ReferrenceBook(String title, int numPage, int year, String authorName, double price, String field,
			List<Chapter> chapter) {
		super(title, numPage, year, authorName, price);
		this.field = field;
		this.chapter = chapter;
	}

	@Override
	public String toString() {
		return "\n"+ "ReferrenceBook [field=" + field+" title ="+ title +" year= "+year;
	}
	
	

}
