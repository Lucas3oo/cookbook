package cdi2;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;

/**                                                                                                                                                                         
 * @author lucas.persson                                                                                                                                                         
 *                                                                                                                                                                          
 */
public class StartupExtension implements Extension {
  private List<Bean<?>> mStartupBeansList = new ArrayList<Bean<?>>();

  public <T> void collect(@Observes
  ProcessBean<T> event) {
    if (event.getAnnotated().isAnnotationPresent(Startup.class)
        && event.getAnnotated().isAnnotationPresent(ApplicationScoped.class)) {
      mStartupBeansList.add(event.getBean());
    }
  }

  public void load(@Observes
  AfterDeploymentValidation event, BeanManager beanManager) {
    for (Bean<?> bean : mStartupBeansList) {
      // note: toString() is important to instantiate the bean                                                                                                              
      beanManager.getReference(bean, bean.getBeanClass(),
          beanManager.createCreationalContext(bean)).toString();
    }
  }
}

