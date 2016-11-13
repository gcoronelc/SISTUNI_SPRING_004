package caso05;

public class MateController {

  private MateService mateService;
  
  public void setMateService(MateService mateService) {
    this.mateService = mateService;
  }
  
  public int sumar(int n1, int n2){
    return mateService.sumar(n1, n2);
  }
  
  public void promediar(Model model){
    mateService.promediar(model);
  }
  
}
