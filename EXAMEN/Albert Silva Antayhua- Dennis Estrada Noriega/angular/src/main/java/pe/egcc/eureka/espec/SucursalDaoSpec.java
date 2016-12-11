package pe.egcc.eureka.espec;

import org.json.JSONArray;

import pe.egcc.eureka.modelo.Sucursal;

public interface SucursalDaoSpec extends CrudDaoSpec<Sucursal>{
	JSONArray traerCuentaSucursal(String cuenta);
}
