package jpa.converter;

/**
 * @author lucas.persson
 * 
 */
public interface Convertable<E extends Enum<E> & Convertable<E, T>, T> {
  /**
   * 
   * @return the internal value of this enum
   */
  T getValue();

  /**
   * 
   * @param value
   * @return the enum that matches the value
   */
  E enumForValue(T value); 
  
}
