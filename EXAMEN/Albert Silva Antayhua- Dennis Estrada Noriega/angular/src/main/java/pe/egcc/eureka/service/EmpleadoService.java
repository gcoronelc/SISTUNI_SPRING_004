package pe.egcc.eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.espec.EmpleadoDaoSpec;
import pe.egcc.eureka.modelo.Empleado;


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
  public boolean validate(Empleado bean) {
	  
	 
	  return empleadoDao.validate(bean);
	  
  }
}
