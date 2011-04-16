<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format">
  <xsl:output method="xml" indent="yes"/>

  <xsl:template match="/colmun">

    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
    <fo:simple-page-master master-name="A4-portrait"
                   page-height="29.7cm" page-width="21.0cm" margin="2cm">
      <fo:region-body margin-top="1cm"/>
    </fo:simple-page-master>
      </fo:layout-master-set>

      <fo:page-sequence master-reference="A4-portrait">
    <fo:flow flow-name="xsl-region-body">
      <fo:block font-size="14pt" color="red" margin="0.5cm" font-family="IPAMincho">
            <xsl:value-of select="title"/>
      </fo:block>
      <fo:block font-size="12pt" margin="0.5cm"  font-family="IPAMincho">
            <xsl:value-of select="abstract"/>
      </fo:block>
    </fo:flow>
      </fo:page-sequence>
    </fo:root>

  </xsl:template>

</xsl:stylesheet>