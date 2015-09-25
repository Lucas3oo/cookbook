package cdi;

import javax.enterprise.util.AnnotationLiteral;

/**
 * @author lucas.persson
 *
 */
public class StoreNameLiteral extends AnnotationLiteral<StoreName> implements
    StoreName {

  private static final long serialVersionUID = 1L;
  final String mExpectedName;

  StoreNameLiteral(String expectedName) {
    mExpectedName = expectedName;
  }

  @Override
  public String value() {
    return mExpectedName;
  }
}
