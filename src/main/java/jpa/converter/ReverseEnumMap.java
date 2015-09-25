package jpa.converter;

import java.util.HashMap;
import java.util.Map;

/**                                                                                                                                                                         
 * Inspired by Dr. Heinz M. Kabutz                                                                                                                                       
 * http://www.javaspecialists.eu/archive/Issue113.html                                                                                                                      
 *                                                                                                                                                                          
 * The generic must implement both Enum and Convertable                                                                                                                     
 *
 * @author lucas.persson                                                                                                                                                         
 */
public class ReverseEnumMap<E extends Enum<E> & Convertable<E, T>, T> {
  private Map<T, E> mMap = new HashMap<T, E>();

  public ReverseEnumMap(Class<E> valueType) {
    for (E theEnum : valueType.getEnumConstants()) {
      mMap.put(theEnum.getValue(), theEnum);
    }
  }

  public E get(T key) {
    return mMap.get(key);
  }
}
