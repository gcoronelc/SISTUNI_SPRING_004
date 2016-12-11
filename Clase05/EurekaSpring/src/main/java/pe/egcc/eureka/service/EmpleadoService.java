package pe.egcc.eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.dao.spec.EmpleadoDaoSpec;
import pe.egcc.eureka.model.Empleado;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoDaoSpec empleadoDao;
  
  public Empleado read(String codigo){
    return empleadoDao.read(codigo);
  }
  
  public List<Empleado> read(Empleado bean) {
    bean.setFiledsEmpty();
    return empleadoDao.read(bean);
  }
  
  public void insert(Empleado bean) {
    empleadoDao.insert(bean);
  }
  
  public Empleado validate(String usuario, String clave){
    Empleado bean = empleadoDao.validate(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Datos incorrectos.");
    }
    return bean;
  }
}
