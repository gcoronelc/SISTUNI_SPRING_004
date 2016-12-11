package pe.egcc.eureka.rest;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by ALBERT on 6/12/2016.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndexPage(){
        return "ingreso";
    }
    
    
}