package main;

import java.util.List;

import org.w3c.dom.Document;

import util.FileOutputUtil;
import util.Logger;
import xml.XmlParser;
import entity.Book;
import entity.BookFactory;
import exception.XmlCreateAppException;
import fop.PdfCreator;

public class CreateXml {

	public static void main(String[] args){
		Document xml = null;
		try {
			xml = XmlParser.getNewDocument("bookList");
		} catch (XmlCreateAppException e) {
			System.err.println("�v���O�����������I�����܂��B");
			return;
		}

		List<Book> bookList = BookFactory.createBooks();
		for(Book book : bookList){
			try {
				XmlParser.insertObjectElement(xml, book, "book");
			}catch(XmlCreateAppException e){
				System.err.println("�v���O�����������I�����܂��B");
				return;
			}
		}

		String xmlPath = null;
		try {
			xmlPath = FileOutputUtil.outputXmlFile(xml, "bookList" + Logger.getNowForFileTimeStamp() + ".xml");
		} catch (XmlCreateAppException e) {
			System.err.println("�v���O�����������I�����܂��B");
			return;
		}

		String xslPath = "output/xsl/book.xsl";
		
		try {
			PdfCreator.outputPdf("book.pdf", xmlPath, xslPath);
		} catch (XmlCreateAppException e) {
			System.err.println("�v���O�����������I�����܂��B");
			return;
		}
		
		System.out.println("PDF�o�͂��������܂����B");
	}
}
