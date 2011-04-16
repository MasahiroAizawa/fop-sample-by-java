package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serializer.OutputPropertiesFactory;
import org.w3c.dom.Document;

import exception.XmlCreateAppException;

public class FileOutputUtil {
	private static final String DEFAULT_OUTPUT_DIRECTORY = "output/xml/";

	private static String directoryPath = DEFAULT_OUTPUT_DIRECTORY;
	private static TransformerFactory transFactory = TransformerFactory.newInstance();

	public static String outputXmlFile(Document xmlDocument, String fileName) throws XmlCreateAppException {
		Transformer transformer  = null;
		try {
			transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "2");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			System.err.println("出力設定に失敗しました。");
			throw new XmlCreateAppException();
		}

		DOMSource source = new DOMSource(xmlDocument);
		File xml = new File(directoryPath + fileName);
		try {
			FileOutputStream fos = new FileOutputStream(xml);
			StreamResult result = new StreamResult(fos);
			transformer.transform(source, result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("ファイルの作成に失敗しました。");
			throw new XmlCreateAppException();
		} catch (TransformerException e) {
			e.printStackTrace();
			System.err.println("XMLの出力に失敗しました。");
			throw new XmlCreateAppException();
		}

		return xml.getPath();
	}
}
