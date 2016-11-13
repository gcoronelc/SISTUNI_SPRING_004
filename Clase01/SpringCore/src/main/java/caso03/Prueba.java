package caso03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    BeanFactory beanFactory = 
        new ClassPathXmlApplicationContext("/caso03/contexto.xml");
    
    MateService ms = beanFactory.getBean(MateService.class);
    
    System.out.println("6 + 7 = " + ms.sumar(6, 7));
  }

  
  
}
