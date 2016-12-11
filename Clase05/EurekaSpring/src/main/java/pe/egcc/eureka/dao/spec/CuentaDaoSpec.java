package pe.egcc.eureka.dao.spec;

import java.util.List;
import java.util.Map;

public interface CuentaDaoSpec {
  
  double traerSaldo(String cuenta);

  List<Map<String,Object>> traerMovimientos(String cuenta);
  
  void procRetiro(String cuenta, double importe, 
      String codEmp, String clave);
  
}
