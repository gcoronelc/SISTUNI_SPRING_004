package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.eureka.service.CuentaService;

@Controller
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;
  
  @RequestMapping(value="/conSaldo.htm", method=RequestMethod.GET)
  public String conSaldo(){
    return "conSaldo";
  }
  
  @RequestMapping(value="/conSaldo.htm", method=RequestMethod.POST)
  public String conSaldo
  (@RequestParam("cuenta") String cuenta, Model model){
    try{
      // Proceso
      double saldo = cuentaService.traerSaldo(cuenta);
      // Reporte
      model.addAttribute("cuenta", cuenta);
      model.addAttribute("saldo", saldo);
    } catch(Exception e){
      model.addAttribute("error", e.getMessage());
    }
    return "conSaldo";
  }
  
  
  
}
