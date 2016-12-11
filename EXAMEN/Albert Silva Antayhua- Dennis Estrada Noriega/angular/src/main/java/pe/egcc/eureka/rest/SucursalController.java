package pe.egcc.eureka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import pe.egcc.eureka.impl.SucursalDaoImpl;
@Controller
public class SucursalController {

	  @Autowired
	  SucursalDaoImpl sucursalDaoImpl;
	  
	  @RequestMapping(value="/sucursal", method=RequestMethod.GET)
	  public String conSuc(){
	    return "cuenSucursal";
	  }
	  
	  @RequestMapping(value="/datosSucursal",method = {RequestMethod.GET ,RequestMethod.POST})
	  @ResponseBody
	  public String conSuc(@RequestParam("cuenta") String cuenta ){    
	    return sucursalDaoImpl.traerCuentaSucursal(cuenta).toString();
	  }
}
