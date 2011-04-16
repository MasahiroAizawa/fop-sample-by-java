package entity;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {
	
	public static List<Book> createBooks(){
		List<Book> bookList = new ArrayList<Book>();
		
		Book book1 = new Book();
		book1.setIdBook(new Integer(1));
		book1.setIsbn("978-4-8222-8423-7");
		book1.setTitle("Scala �v���O���~���O����");
		book1.setSummary("Scala����̓��发�B" +
				"���e�͑S���ǂݐ؂��Ă��Ȃ�����킩��Ȃ��B" +
				"���̖{������ʌo����\��B");
		book1.setPrice(new Integer(3200));
		
		bookList.add(book1);
		
		Book book2 = new Book();
		book2.setIdBook(new Integer(2));
		book2.setIsbn("978-4-478-01588-9");
		book2.setTitle("�]���o�ώЉ�");
		book2.setSummary("���c�l�i�v�̎O���������s�̈���B" +
				"�_�Ɗv���A�Y�Ɗv���ɑ������v���ŎЉ�̃p���_�C�����ς�邱�Ƃ������B" +
				"���񂱂̐l�̖{�ɂ͔��ɋ��������B�ʔ����B");
		book2.setPrice(new Integer(1500));
		
		bookList.add(book2);
		
		return bookList;
	}

}
