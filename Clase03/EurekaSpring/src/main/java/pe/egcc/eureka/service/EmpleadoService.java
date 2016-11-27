package pe.egcc.eureka.service;

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
  
}
