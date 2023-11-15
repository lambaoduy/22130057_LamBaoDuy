package Lab9_taks2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListBook {
	List<Book> list;

	public ListBook(List<Book> list) {
		super();
		this.list = list;
	}

	public String typeBook(Book book) {
		return book.typeBooks();
	}

	public boolean published10Year(Book book) {
		return book.published10Year();
	}

	public boolean sameTypeAndAuthor(Book book1, Book book2) {
		return book1.sameTypeAndAuthor(book2);
	}

	public double sumPrice() {
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).price;
		}
		return result;
	}

	public Book mostReferrenceBookPage() {
		Book result = null;
		int max = 0;
		for (Book book : list) {
			if (book.numPage > max && book.typeBooks().equals("ReferrenceBook")) {
				result = book;
				max = book.numPage;
			}
		}
		return result;
	}

	public Magazine findMagazine(String name) {
		Magazine result = null;
		for (Book book : list) {
			if (book.typeBooks().equals("Magazine") && book.getNameMagazine().equals(name)) {
				result = (Magazine) book;
			}
		}

		return result;
	}

	public List<Book> book1YearAgo(int year) {
		List<Book> result = new ArrayList<>();
		for (Book book : list) {
			if (book.getYear() == year&&book.typeBooks().equals("Magazine")) {
				result.add(book);
			}
		}
		return result;
	}

	public void sort() {
		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				if (!o1.getTitle().equals(o2.getTitle())) {
					return o1.getTitle().compareTo(o2.getTitle());
				} else {
					return -(o1.getYear() - o2.getYear());
				}
			}
		});
	}

	public Map<Integer, Integer> quantityStatistics() {
		Map<Integer, Integer> result = new HashMap<>();
		for (Book book : list) {
			if (result.containsKey(book.getYear())) {
				result.replace(book.getYear(), result.get(book.getYear()) + 1);
			} else {
				result.put(book.getYear(), 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		List<Chapter> chapsbook1 = new ArrayList<>();
		List<Chapter> chapsbook2 = new ArrayList<>();
		ListBook listbook = new ListBook(list);

		Book book1 = new Magazine("tiltle1", 10, 2020, "Author1", 500.1002, "magazine 1");
		Book book2 = new Magazine("tiltle2", 11, 2011, "Author2", 300.09, "magazine 2");
		Book book3 = new Magazine("tiltle3", 15, 2020, "Author3", 303, "magazine 3");

		Book book4 = new ReferrenceBook("title4", 50, 2011, "Author4", 600.0102, "ReferrenceBook1", chapsbook1);
		Book book5 = new ReferrenceBook("title5", 60, 2020, "Author4", 700, "ReferrenceBook2", chapsbook2);
		
		Book book6 = new Magazine("tiltle6", 10, 2010, "Author1", 500.1002, "magazine 4");
		Book book7 = new Magazine("tiltle7", 11, 2012, "Author2", 300.09, "magazine 5");
		Book book8 = new Magazine("tiltle8", 15, 2012, "Author3", 303, "magazine 6");

		Chapter chap1= new Chapter("chap1", 25);
		Chapter chap2= new Chapter("chap2", 25);
		Chapter chap3= new Chapter("chap1",30 );
		Chapter chap4= new Chapter("chap2", 30);
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book5);
		
		list.add(book6);
		list.add(book7);
		list.add(book8);
		
		chapsbook1.add(chap1);
		chapsbook1.add(chap2);
		chapsbook2.add(chap3);
		chapsbook2.add(chap4);
		//test 6)  xác định loại của ấn phẩm
//	System.out.println(listbook.typeBook(book1));//Magazine
//	System.out.println(listbook.typeBook(book4));//ReferrenceBook
		
		//test 7) kiểm tra ấn phẩm là tạp chí và có thời gian 
		//xuất bản cách đây (2021) 10 năm hay không
//		System.out.println(listbook.published10Year(book1));//false
//		System.out.println(listbook.published10Year(book2));//true
		
		//test 8) kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
//		System.out.println(listbook.sameTypeAndAuthor(book1, book2));//false
//		System.out.println(listbook.sameTypeAndAuthor(book4, book5));//true
		
		//test9) Tính tổng tiền của tất các ấn phẩm trong nhà sách
//		System.out.println(listbook.sumPrice());//2403.2004
		
		//test10) Tìm quyển sách tham khảo có chương sách nhiều trang nhất
//		System.out.println(listbook.mostReferrenceBookPage());
		
		//test11) Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước 
		//hay không?		
//		System.out.println(listbook.findMagazine("magazine 1"));//có
//		System.out.println(listbook.findMagazine("magazine 4"));//không
		
		//test12) Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
//		System.out.println(listbook.book1YearAgo(2020));
		
		//test13)Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử 
		//dụng interface Comparable hoặc Comparator)
//		listbook.sort();
//		System.out.println(list.toString());
		
		//test 14)Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, … 
		//năm 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.
//		System.out.println(listbook.quantityStatistics());
	}
}
