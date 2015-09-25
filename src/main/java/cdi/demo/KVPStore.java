package cdi.demo;

import javax.enterprise.context.ApplicationScoped;

import cdi.Store;
import cdi.StoreName;

/**
 * Some Store impl for e.g key/value pair.
 * 
 * Instances will be created by the container so injection etc works.
 * 
 * @author lucas.persson
 *
 */
@ApplicationScoped
@StoreName("KVPStore")
public class KVPStore implements Store {

  public KVPStore() {
    // TODO Auto-generated constructor stub
  }
  
  

  @Override
  public int storeData(String data) {
    // TODO Auto-generated method stub
    return 0;
  }

}
