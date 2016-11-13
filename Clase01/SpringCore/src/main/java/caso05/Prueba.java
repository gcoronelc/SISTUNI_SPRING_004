package caso05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    BeanFactory beanFactory = 
        new ClassPathXmlApplicationContext("/caso05/contexto.xml");
    
    MateController mc = beanFactory.getBean(MateController.class);
    
    // Datos
    Model model = new Model();
    model.setNota1(13.0);
    model.setNota2(10.0);
    model.setNota3(8.0);
    model.setNota4(16.0);
    
    // Proceso
    mc.promediar(model);
    
    // Reporte
    System.out.println("Promedio = " + model.getProm());
    System.out.println("Estado = " + model.getEstado());
  }

  
  
}
