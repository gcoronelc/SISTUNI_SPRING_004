package caso02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    // Cargando el contexto
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext
        ("/caso02/contexto.xml");
    
    // Obteniendo el acceso a la instancia
    MateService ms = (MateService) beanFactory.getBean("mateService");
    // MateService ms = beanFactory.getBean("mateService",MateService.class);
    // MateService ms = beanFactory.getBean(MateService.class);
    
    // Usando la instancia
    System.out.println("6 + 7 = " + ms.sumar(6, 7));
  }
  
}
