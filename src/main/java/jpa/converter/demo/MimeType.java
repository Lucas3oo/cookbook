package jpa.converter.demo;

import jpa.converter.Convertable;
import jpa.converter.ReverseEnumMap;

/**
 * Enumerates standard Mime Types
 */
public enum MimeType implements Convertable<MimeType, String> {

  /* text types */
  TEXT_PLAIN("text/plain", false), TEXT_HTML("text/html", false), TEXT_XML("text/xml", false), TEXT_VXML(
      "text/vxml", false), TEXT_X_VXML("text/x-vxml", false), URL("text/x-url", false), TEXT_RTF(
      "text/rtf", false);

  private String mType;

  private boolean mIsBinary;

  private static ReverseEnumMap<MimeType, String> sMap = new ReverseEnumMap<MimeType, String>(
      MimeType.class);

  MimeType(String type, boolean isBinary) {
    mType = type;
    mIsBinary = isBinary;
  }

  /**
   * Indicates if this MIME type implies binary content.
   * 
   * @return returns the isBinary.
   */
  public boolean isBinary() {
    return mIsBinary;
  }

  /**
   * The literal value of this MIME Type. For example,
   * MimeType.TEXT_PLAIN.toString() would return "text/plain".
   * 
   * @return the literal value of this MIME Type.
   */
  public String toString() {
    return mType;
  }

  @Override
  public String getValue() {
    return mType;
  }

  @Override
  public MimeType enumForValue(String value) {
    return sMap.get(value);
  }

}