package pe.egcc.eureka.service;

import java.util.List;
import java.util.Map;

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
  
  public List<Map<String, Object>> traerMovimientos(String cuenta) {
    return cuentaDao.traerMovimientos(cuenta);
  }
}
