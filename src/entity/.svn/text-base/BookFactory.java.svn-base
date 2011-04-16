package entity;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {
	
	public static List<Book> createBooks(){
		List<Book> bookList = new ArrayList<Book>();
		
		Book book1 = new Book();
		book1.setIdBook(new Integer(1));
		book1.setIsbn("978-4-8222-8423-7");
		book1.setTitle("Scala プログラミング入門");
		book1.setSummary("Scala言語の入門書。" +
				"内容は全部読み切っていないからわからない。" +
				"この本を一冊写経する予定。");
		book1.setPrice(new Integer(3200));
		
		bookList.add(book1);
		
		Book book2 = new Book();
		book2.setIdBook(new Integer(2));
		book2.setIsbn("978-4-478-01588-9");
		book2.setTitle("評価経済社会");
		book2.setSummary("岡田斗司夫の三冊同時刊行の一冊。" +
				"農業革命、産業革命に続く情報革命で社会のパラダイムが変わることを扱う。" +
				"毎回この人の本には非常に驚かされる。面白い。");
		book2.setPrice(new Integer(1500));
		
		bookList.add(book2);
		
		return bookList;
	}

}
