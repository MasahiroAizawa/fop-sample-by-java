package fop.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import fop.PdfCreator;


public class PdfCreatorTest {

	@Test
	public void testPdfOutput(){
		String xmlPath = "output/xml/fop-sample.xml";
		String xslPath = "output/xsl/fop-sample.xsl";
		
		try {
			PdfCreator.outputPdf("sample.pdf", xmlPath, xslPath);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
