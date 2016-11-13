package caso01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext
        ("/caso01/contexto.xml");
    MateService ms = (MateService) beanFactory.getBean("mateService");
    System.out.println("6 + 7 = " + ms.sumar(6, 7));
  }
  
}
