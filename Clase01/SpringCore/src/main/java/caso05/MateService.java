package caso05;

import java.util.Arrays;
import java.util.stream.Stream;

public class MateService {

  public int sumar(int n1, int n2){
    return (n1 + n2);
  }
  
  public void promediar(Model model){
    // Proceso
    double prom = promedio(model.getNota1(), model.getNota2(), model.getNota3(), model.getNota4());
    String estado = "Desaprobado";
    if(prom >= 14.0){
      estado = "Aprobado";
    }
    // Reporte
    model.setProm(prom);
    model.setEstado(estado);
  }

  private double promedio(double ... notas) {
    Arrays.sort(notas);
    double me = notas[0];
    double suma = 0.0;
    for(double n: notas){
      suma +=n;
    }
    suma -= me;
    return (suma / 3);
  }
  
}
