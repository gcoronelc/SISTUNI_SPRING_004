package pe.egcc.eureka.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.espec.CuentaDaoSpec;
import pe.egcc.eureka.modelo.Empleado;
import pe.egcc.eureka.util.Memoria;

import org.json.JSONArray;


@Service
public class CuentaService {

  @Autowired
  private CuentaDaoSpec cuentaDao;
  
  public double traerSaldo(String cuenta){
    return cuentaDao.traerSaldo(cuenta);
  }
  
  public JSONArray traerMovimientos(String cuenta) {
    return cuentaDao.traerMovimientos(cuenta);
  }
  
  public void doDeposito(String cuenta, double importe){
	  Empleado bean = (Empleado) Memoria.get("usuario");
	  System.out.println(bean.getCodigo());
	  cuentaDao.doDeposito(cuenta, importe, bean.getCodigo());
  }
  public void procRetiro(String cuenta,double importe, String clave){
	  Empleado bean = (Empleado) Memoria.get("usuario");
	  System.out.println(bean.getCodigo());
	  cuentaDao.procRetiro(cuenta, importe, clave, bean.getCodigo());
  }
}
