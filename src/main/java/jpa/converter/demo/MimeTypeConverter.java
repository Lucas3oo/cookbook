package jpa.converter.demo;



import jpa.converter.AbstractConverter;
import jpa.converter.Convertable;

/**
 * In the META-INF/eclipselink-orm.xml have the following:
 * 
 * 
 * 
<?xml version="1.0"?>
<entity-mappings xmlns="http://www.eclipse.org/eclipselink/xsds/persistence/orm"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.eclipse.org/eclipselink/xsds/persistence/orm http://www.eclipse.org/eclipselink/xsds/eclipselink_orm_2_1.xsd"
  version="2.1">

  <converter name="MimeTypeConverter"
    class="jpa.converter.demo.MimeTypeConverter" />
    
    
  <entity class="demo.TemplatePart" name="TemplatePart" access="PROPERTY">
    <table name="Template_Part" />
    <attributes>
      <id name="Id">
        <!-- http://wiki.eclipse.org/EclipseLink/Examples/JPA/PrimaryKey -->
      </id>
      <basic name="ApplicationName" >
        <column name="APPLICATION_NAME"/>
      </basic>
      <basic name="TemplatePartName" >
        <column name="TEMPLATE_PART_NAME"/>
      </basic>
      <basic name="MimeType">
        <column name="MIME_TYPE"/>
        <convert>MimeTypeConverter</convert>
      </basic>
      <basic name="LastModified">
        <column name="LAST_MODIFIED"/>
        <temporal>TIMESTAMP</temporal>
      </basic>
      <basic name="TemplatePartSource">
        <column name="TEMPLATE_PART_SOURCE"/>
        <lob/>
      </basic>
    </attributes>
  </entity>

 * 
 * @author lucas.persson
 *
 */
public class MimeTypeConverter extends AbstractConverter<MimeType, String> {

  private static final long serialVersionUID = 1L;

  @Override
  public Convertable<MimeType, String> getConvertableEnum() {
    // Just return any enum value, we need just an instance so enumForValue could be called                                                                                 
    return MimeType.TEXT_PLAIN;
  }

  @Override
  public Class<?> getValueType() {
    return String.class;
  }

}


