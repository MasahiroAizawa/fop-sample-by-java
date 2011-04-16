package fop;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import exception.XmlCreateAppException;

public class PdfCreator {

	private static final String DEFAULT_PDF_DIRECTORY = "output/pdf/";

	private static String directoryPath = DEFAULT_PDF_DIRECTORY;
	private static FopFactory fopFactory = FopFactory.newInstance();
	private static TransformerFactory transformerFactory = TransformerFactory.newInstance();


	public static void outputPdf(String pdfName, String xmlPath, String templetePath) throws XmlCreateAppException{
		String pdfPath = directoryPath + pdfName;
		clearOldFile(pdfPath);

		OutputStream output = null;

		try{
			try{
				fopFactory.setUserConfig("config/fop.xconf");
			} catch(IOException e){
				e.printStackTrace();
				System.err.println("FOP�̐ݒ�t�@�C����������܂���B");
				System.err.println("���{�ꂪ�o�͏o���Ȃ��\��������܂��B");
			}
			output = new BufferedOutputStream(new FileOutputStream(pdfPath));

			FOUserAgent userAgent = fopFactory.newFOUserAgent();

			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, output);

			Source xmlSource = new StreamSource(xmlPath);
			Source xsltSource = new StreamSource(templetePath);

			Transformer transformer = transformerFactory.newTransformer(xsltSource);

			Result result = new SAXResult(fop.getDefaultHandler());

			transformer.transform(xmlSource, result);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("�o�͗p��PDF�t�@�C���������o���܂���B");
			throw new XmlCreateAppException();
		} catch(SAXException e){
			e.printStackTrace();
			System.err.println("FOP�̎g�p�Ɏ��s���܂����B");
			throw new XmlCreateAppException();
		} catch(TransformerException e){
			e.printStackTrace();
			System.err.println("PDF�̕ϊ��Ɏ��s���܂����B");
			throw new XmlCreateAppException();
		} finally{
			try{
				if(output != null){
					output.close();
				}
			}catch(IOException ioe){
				ioe.printStackTrace();
				System.err.println("�o�͂̃N���[�Y�Ɏ��s���܂����B");
				throw new XmlCreateAppException();
			}
		}
	}

	private static void clearOldFile(String filePath){
		File oldFile = new File(filePath);
		if(oldFile.exists() && oldFile.isFile())
			oldFile.delete();
	}
}
