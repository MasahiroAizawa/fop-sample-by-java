package xml;

import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exception.XmlCreateAppException;

public class XmlParser {
	private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	public static Document getNewDocument(String rootTagName) throws XmlCreateAppException {
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.err.println("XMLの生成に失敗しました。");
			throw new XmlCreateAppException();
		}

		DOMImplementation domImpl = builder.getDOMImplementation();
		Document document = domImpl.createDocument("", rootTagName, null);

		return document;
	}

	public static void insertObjectElement(Document xmlDocument, Object obj, String objectElementName) throws XmlCreateAppException {
		Element objectElement = xmlDocument.createElement(objectElementName);

		Class<?> targetClass = obj.getClass();
		Field[] targetFields = targetClass.getDeclaredFields();
		for(Field field : targetFields){
			Element propertyElement = null;
			try {
				propertyElement = createPropertyElement(xmlDocument, field, obj);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("XMLの編集に失敗しました。");
				throw new XmlCreateAppException();
			}
			objectElement.appendChild(propertyElement);
		}

		Element root = xmlDocument.getDocumentElement();
		root.appendChild(objectElement);
	}

	private static Element createPropertyElement(Document doc, Field field, Object obj) throws XmlCreateAppException{
		Element propertyElement = doc.createElement(field.getName());
		try{
			try {
				field.setAccessible(true);
				propertyElement.appendChild(doc.createTextNode(field.get(obj).toString()));
			} catch (DOMException e) {
				e.printStackTrace();
				System.err.println("XML要素へのプロパティの追加に失敗しました。");
				throw new XmlCreateAppException();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				System.err.println("対象Objectのフィールドの取得に失敗しました。");
				throw new XmlCreateAppException();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.err.println("対象Objectのフィールドへのアクセスに失敗しました。");
				throw new XmlCreateAppException();
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("XML要素の追加に失敗しました。");
			throw new XmlCreateAppException();
		}

		return propertyElement;
	}
}
