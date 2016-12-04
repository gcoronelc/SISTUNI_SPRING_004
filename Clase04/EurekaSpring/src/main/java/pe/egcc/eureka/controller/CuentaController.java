package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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
  
  @RequestMapping(value="/conMovimientos1.htm", method=RequestMethod.GET)
  public String conMovimientos1(){
    return "conMovimientos1";
  }
  
  
  @RequestMapping(value="/conMovimientos1", 
      method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
  @ResponseBody
  public String conMovimientos1(
      @RequestParam("cuenta") String cuenta ){
    List<Map<String,Object>> lista = cuentaService.traerMovimientos(cuenta);
    Gson gson = new Gson();
    String textoJson = gson.toJson(lista);
    return textoJson;
  }
  
  
  
  
}
