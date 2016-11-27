package pe.egcc.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.EmpleadoService;

@Controller
public class EmpleadoController {

  @Autowired
  private EmpleadoService empleadoService;
  
  @RequestMapping(value="/conEmpleado.htm", method=RequestMethod.GET)
  public String conEmpleado(){
    return "conEmpleado";
  }
  
  @RequestMapping(value="/conEmpleado.htm", method=RequestMethod.POST)
  public String conEmpleado
  (@RequestParam("codigo") String codigo, Model model){
    try {
      Empleado bean = empleadoService.read(codigo);
      if(bean == null){
        throw new Exception("Código " + codigo + " no existe");
      }
      model.addAttribute("bean", bean);
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "conEmpleado";
  }
  
  
}
