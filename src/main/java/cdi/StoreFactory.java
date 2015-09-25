package cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author lucas.persson
 *
 */
@ApplicationScoped
public class StoreFactory {

  @Inject
  @Any
  private Instance<Store> mStores;

  public Store getStoreForName(String humanName) {
    Store selected = null;
    Instance<Store> selectedStores = mStores.select(new StoreNameLiteral(humanName));
    for (Store store : selectedStores) {
      selected = store;
    }
    return selected;
  }

  @Produces
  public List<String> getAvailableNames() {

    List<String> names = new ArrayList<String>();
    for (Store store : mStores) {
      String name = store.getClass().getAnnotation(StoreName.class).value();
      names.add(name);
    }
    return names;
  }
}
