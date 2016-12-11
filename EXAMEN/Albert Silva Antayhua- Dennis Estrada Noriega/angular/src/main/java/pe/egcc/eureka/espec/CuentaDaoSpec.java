package pe.egcc.eureka.espec;



import org.json.JSONArray;

public interface CuentaDaoSpec {
  
  double traerSaldo(String cuenta);

  JSONArray traerMovimientos(String cuenta);
  
  void doDeposito(String cuenta, double importe, String codEmp);
  
  void procRetiro(String cuenta,double importe, String clave,String codEmp);
}
