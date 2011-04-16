package util.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;

import util.FileOutputUtil;
import util.Logger;
import xml.XmlParser;
import entity.Book;
import entity.BookFactory;


public class FileOutputUtilTest {
	@Test
	public void testOutput(){
		String path = null;
		try{
			Document doc = XmlParser.getNewDocument("test"); 
			List<Book> bookList = BookFactory.createBooks();
			XmlParser.insertObjectElement(doc, bookList.get(0), "book");
			path = FileOutputUtil.outputXmlFile(doc, "test" + Logger.getNowForFileTimeStamp() + ".xml");
		}catch(Exception e){
			fail();
		}
		
		assertEquals("xml/test", path.substring(0, 8));
		assertEquals(".xml", path.substring(22));
	}
}
