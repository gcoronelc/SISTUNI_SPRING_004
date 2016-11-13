package caso04;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    BeanFactory beanFactory = 
        new ClassPathXmlApplicationContext("/caso04/contexto.xml");
    
    MateController mc = beanFactory.getBean(MateController.class);
    
    System.out.println("6 + 7 = " + mc.sumar(6, 7));
  }

  
  
}
