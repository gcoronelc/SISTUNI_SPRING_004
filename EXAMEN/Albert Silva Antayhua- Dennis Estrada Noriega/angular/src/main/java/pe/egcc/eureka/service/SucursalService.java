package pe.egcc.eureka.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.egcc.eureka.impl.SucursalDaoImpl;

@Service
public class SucursalService {
	@Autowired
	private SucursalDaoImpl sucursalDaoImpl;
	
	public JSONArray traerMovimientos(String cuenta) {
	    return sucursalDaoImpl.traerCuentaSucursal(cuenta);
	  }
}
