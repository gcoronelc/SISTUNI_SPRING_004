package caso05;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MateController {

  @Inject
  private MateService mateService;
   
  public int sumar(int n1, int n2){
    return mateService.sumar(n1, n2);
  }
  
  public void promediar(Model model){
    mateService.promediar(model);
  }
  
}
