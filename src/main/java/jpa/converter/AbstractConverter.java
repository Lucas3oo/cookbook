package jpa.converter;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

public abstract class AbstractConverter<E extends Enum<E> & Convertable<E, T>, T> implements
    Converter {

  private static final long serialVersionUID = 1L;

  public abstract Convertable<E, T> getConvertableEnum();

  /**
   * 
   * @return the type of the data used in the database, e.g. String.class, Integer.class
   */
  public abstract Class<?> getValueType();

  @SuppressWarnings("unchecked")
  @Override
  public Object convertDataValueToObjectValue(Object dataValue, Session session) {
    try {
      T theValue = (T) dataValue;
      Convertable<E, T> convertableEnum = getConvertableEnum().enumForValue(theValue);
      if (convertableEnum == null) {
        throw new IllegalArgumentException("Data not with a value suitable! Got ["
            + dataValue.getClass() + " : " + dataValue + "] expected a valid value of ["
            + getConvertableEnum().getClass() + "]");
      } else {
        return convertableEnum;
      }
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Data not with a value suitable! Got ["
          + dataValue.getClass() + " : " + dataValue + "] expected a valid value of ["
          + getConvertableEnum().getClass() + "]");
    }
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Object convertObjectValueToDataValue(Object objectValue, Session session) {
    assert objectValue != null : "objectValue is null";
    if (objectValue instanceof Convertable) {
      return ((Convertable) objectValue).getValue();
    }
    throw new IllegalArgumentException("objectValue not of correct type, got ["
        + objectValue.getClass() + "] expected [Convertable]");

  }

  @Override
  public void initialize(DatabaseMapping databaseMapping, Session session) {
    // set the type of the data value to getValueType() (e.g. Integer)
    // since it otherwise sometimes can be BigDecimal instead of Integer depending on the
    // EclipseLink or Oracle JDBC driver version?
    DirectToFieldMapping mapping = (DirectToFieldMapping) databaseMapping;
    mapping.setFieldClassification(getValueType());
  }

  @Override
  public boolean isMutable() {
    return false;
  }

}
