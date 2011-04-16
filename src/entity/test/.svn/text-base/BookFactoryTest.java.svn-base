package entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import entity.Book;
import entity.BookFactory;

public class BookFactoryTest {
	@Test
	public void testCreate(){
		List<Book> bookList = BookFactory.createBooks();
		assertEquals(2, bookList.size());
		
		assertEquals(new Integer(1), bookList.get(0).getIdBook());
		assertEquals(new Integer(2), bookList.get(1).getIdBook());
	}
	
	@Test
	public void testBookNo1(){
		List<Book> bookList = BookFactory.createBooks();
		Book book = bookList.get(0);
		
		assertEquals(new Integer(1), book.getIdBook());
		assertEquals("978-4-8222-8423-7", book.getIsbn());
		assertEquals("Scala プログラミング入門", book.getTitle());
		assertEquals("Scala言語の入門書\n" +
				"内容は全部読み切っていないからわからない。\n" +
				"この本を一冊写経する予定。\n", book.getSummary());
		assertEquals(new Integer(3200), book.getPrice());
	}
	
	@Test
	public void testBookSetter(){
		List<Book> bookList = BookFactory.createBooks();
		Book num1Book = bookList.get(0);
		
		Book book = new Book();
		book.setIdBook(num1Book.getIdBook());
		book.setIsbn(num1Book.getIsbn());
		book.setTitle(num1Book.getTitle());
		book.setSummary(num1Book.getSummary());
		book.setPrice(num1Book.getPrice());
		
		assertTrue(book.equals(num1Book));
		assertEquals(book.hashCode(), num1Book.hashCode());
		assertEquals(book.toString(), num1Book.toString());
	}
}
