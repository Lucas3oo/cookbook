package cdi.demo;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import cdi.Store;
import cdi.StoreFactory;

/**
 * Bean that acts as a proxy for the actual store impl
 * 
 * @author lucas.persson
 *
 */
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Local(Store.class)
@Singleton(name = "StoreBean", mappedName = "ejb/StoreBean")
public class StoreBean implements Store {

  private Store mStore;

  @Inject
  private StoreFactory mStoreFactory;

  @PostConstruct
  public void init() {
    // gets the store impl to use from some configuration property.
    // the store will be created by the CDI container
    // sLogger.finer("Store configured to use KVPStore.");
    mStore = mStoreFactory.getStoreForName("KVPStore");
  }

  @Override
  public int storeData(String data) {
    return mStore.storeData(data);
  }
}
