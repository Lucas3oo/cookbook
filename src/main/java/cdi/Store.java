package cdi;

/**
 * Some interface that has many implementations that should be able to be injected in an component.
 * 
 * @author lucas.persson
 *
 */
public interface Store {
  
  public int storeData(String data);

}
