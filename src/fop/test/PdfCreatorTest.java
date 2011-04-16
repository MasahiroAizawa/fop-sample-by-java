package fop.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import fop.PdfCreator;


public class PdfCreatorTest {

	@Test
	public void testPdfOutput(){
		String xmlPath = "output/xml/aaa.xml";
		String xslPath = "output/xsl/aaa.xsl";
		
		try {
			PdfCreator.outputPdf("sample.pdf", xmlPath, xslPath);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
