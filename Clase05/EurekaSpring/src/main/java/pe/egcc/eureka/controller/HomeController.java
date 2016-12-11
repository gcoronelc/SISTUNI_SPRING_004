package pe.egcc.eureka.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.EmpleadoService;


@Controller
public class HomeController {
  
  @Autowired
  private EmpleadoService empleadoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "home";
	}
	
	@RequestMapping(value = "/logon.htm", method = RequestMethod.POST)
	public String home(HttpSession session, Model model,
	    @RequestParam("usuario") String usuario,
	    @RequestParam("clave") String clave) {	
	  String destino;
	  try {
      Empleado bean = empleadoService.validate(usuario, clave);
      session.setAttribute("usuario", bean);
      destino = "main";
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      destino = "home";
    }
	  return destino;
	}
	
	
	
	
}
