package pe.egcc.mvc01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.mvc01.dto.NotasDto;
import pe.egcc.mvc01.service.MateService;

@Controller
public class HomeController {
  
  @Autowired
  private MateService mateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
				
		return "panchito";
		
	}
	
	@RequestMapping(value="/sumar.uni", method=RequestMethod.GET)
	public String sumar(){
	  return "sumar";
	}
	
	@RequestMapping(value="/sumar.uni", method=RequestMethod.POST)
  public String sumar(HttpServletRequest request, Model model){
	  // Datos
	  int n1 = Integer.parseInt(request.getParameter("num1"));
	  int n2 = Integer.parseInt(request.getParameter("num2"));
	  // Proceso
	  int suma = mateService.sumar(n1, n2);
	  // Reporte
	  model.addAttribute("n1", n1);
	  model.addAttribute("n2", n2);
	  model.addAttribute("suma", suma);
	  // Vista
    return "sumar";
  }
	
	@RequestMapping(value="/sumar2.uni", method=RequestMethod.POST)
  public ModelAndView sumar2(
      @RequestParam("num1") int n1, 
      @RequestParam("num2") int n2){
	  // Creación del view
	  ModelAndView view = new ModelAndView("sumar");
    // Proceso
    int suma = mateService.sumar(n1, n2);
    // Reporte
    view.addObject("n1", n1);
    view.addObject("n2", n2);
    view.addObject("suma", suma);
    // Vista
    return view;
  }
	
	@RequestMapping(value="/promedio.uni", method=RequestMethod.GET)
  public String promedio(){
    return "promedio";
  }
	
	@RequestMapping(value="/promedio.uni", method=RequestMethod.POST)
  public ModelAndView promedio(@ModelAttribute NotasDto dto,
      @RequestParam("nombre") String nombre){
    // Creación del view
    ModelAndView view = new ModelAndView("promedio");
    // Proceso
    mateService.promediar(dto);;
    // Reporte
    view.addObject("nombre", nombre);
    view.addObject("dto", dto);
    // Vista
    return view;
  }
}
