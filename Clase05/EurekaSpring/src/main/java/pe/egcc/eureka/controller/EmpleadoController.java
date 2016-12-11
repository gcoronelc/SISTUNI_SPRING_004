package pe.egcc.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.model.JsonBean;
import pe.egcc.eureka.service.EmpleadoService;

@Controller
public class EmpleadoController {

  @Autowired
  private EmpleadoService empleadoService;
  
  
  // Consulta empleado clasica
  
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

  // Consulta de empleado con JSON usando Jackson
  
  @RequestMapping(value="/conEmpleado2.htm", 
      method=RequestMethod.GET)
  public String conEmpleado2(){
    return "conEmpleado2";
  }
  
  @RequestMapping(value="/conEmpleado2.htm", 
      method=RequestMethod.POST, 
      produces="application/json; charset=utf-8")
  public @ResponseBody JsonBean conEmpleado2(
      @RequestParam("codigo") String codigo){
    JsonBean jsonBean = new JsonBean();
    try {
      Empleado bean = empleadoService.read(codigo);
      if( bean == null){
        throw new Exception("Código " + codigo + " no existe.");
      }
      jsonBean.setCode(1);
      Gson gson = new Gson();
      jsonBean.setText(gson.toJson(bean));
    } catch (Exception e) {
      jsonBean.setCode(-1);
      jsonBean.setText(e.getMessage());
    }
    return jsonBean;
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
