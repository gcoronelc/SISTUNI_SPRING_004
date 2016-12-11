package pe.egcc.eureka.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import pe.egcc.eureka.service.CuentaService;


@Controller
public class CuentaController {

  @Autowired
  CuentaService cuentaDaoImpl;
  
  @RequestMapping(value="/conSaldo", method=RequestMethod.GET)
  public String conSaldo(){
    return "conSaldo";
  }
  
  @RequestMapping(value="/conSaldo", method=RequestMethod.POST)
  public String conSaldo
  (@RequestParam("cuenta") String cuenta, Model model){
    try{
      // Proceso
      double saldo = cuentaDaoImpl.traerSaldo(cuenta);
      // Reporte
      model.addAttribute("cuenta", cuenta);
      model.addAttribute("saldo", saldo);
    } catch(Exception e){
      model.addAttribute("error", e.getMessage());
    }
    return "conSaldo";
  }
  
  @RequestMapping(value="/conMovimientos1", method=RequestMethod.GET)
  public String conMovimientos1(){
    return "conMovimientos1";
  }
  
  
  @RequestMapping(value="/datosMovimientos1",method = {RequestMethod.GET ,RequestMethod.POST})
  @ResponseBody
  public String conMovimientos1(@RequestParam("cuenta") String cuenta ){    
    return cuentaDaoImpl.traerMovimientos(cuenta).toString();
  }
  ////////Deposito
  @RequestMapping(value="/getDeposito", method=RequestMethod.GET)
  public String deposito(){
    return "cuenDeposito";
  }
  
  @RequestMapping(value="/deposito",method={RequestMethod.GET ,RequestMethod.POST})
  public String deposito(@RequestParam("importe") String importe,@RequestParam("cuenta") String cuenta ){
	  double reimporte=Double.parseDouble(importe.toString());
	  cuentaDaoImpl.doDeposito(cuenta, reimporte);
	  return "home";
  }
  //////Retiro
  @RequestMapping(value="/getRetiro", method=RequestMethod.GET)
  public String retiro(){
    return "cuenRetiro";
  }
  
  @RequestMapping(value="/postRetiro",method={RequestMethod.GET ,RequestMethod.POST})
  public String retiro(@RequestParam("importe") String importe,@RequestParam("cuenta") String cuenta,@RequestParam("clave") String clave ){
	  double reimporte=Double.parseDouble(importe.toString());
	  cuentaDaoImpl.procRetiro(cuenta, reimporte, clave );
	  return "home";
  }
}
