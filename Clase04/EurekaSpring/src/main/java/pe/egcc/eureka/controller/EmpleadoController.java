package pe.egcc.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
  
  @RequestMapping(value="/conEmpleados.htm", method=RequestMethod.GET)
  public String conEmpleados(){
    return "conEmpleados";
  }
  
  @RequestMapping(value="/conEmpleados.htm", method=RequestMethod.POST)
  public String conEmpleados
  (@ModelAttribute Empleado bean, Model model){
    try {
      List<Empleado> lista = empleadoService.read(bean);
      model.addAttribute("lista", lista);
      model.addAttribute("bean", bean);
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "conEmpleados";
  }
  
  @RequestMapping(value="/proInsEmpleado.htm", method=RequestMethod.GET)
  public String proInsEmpleado(){
    return "proInsEmpleado";
  }
  
  @RequestMapping(value="/proInsEmpleado.htm", method=RequestMethod.POST)
  public String proInsEmpleado
  (@ModelAttribute Empleado bean, Model model){
    try {
      empleadoService.insert(bean);
      model.addAttribute("mensaje", "Proceso ok. Código " + bean.getCodigo() + ".");
      model.addAttribute("bean", new Empleado());
    } catch (Exception e) {
      model.addAttribute("bean", bean);
      model.addAttribute("error", e.getMessage());
    }
    return "proInsEmpleado";
  }
  
}
