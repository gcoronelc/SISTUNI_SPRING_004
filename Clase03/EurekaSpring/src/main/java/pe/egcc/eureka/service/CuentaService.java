package pe.egcc.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.dao.spec.CuentaDaoSpec;

@Service
public class CuentaService {

  @Autowired
  private CuentaDaoSpec cuentaDao;
  
  public double traerSaldo(String cuenta){
    return cuentaDao.traerSaldo(cuenta);
  }
  
}
