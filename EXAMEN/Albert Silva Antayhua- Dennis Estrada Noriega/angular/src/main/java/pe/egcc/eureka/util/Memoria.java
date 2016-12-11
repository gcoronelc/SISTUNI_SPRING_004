package pe.egcc.eureka.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de tipo final para que no se pueda heredar.
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public final class Memoria {

  /**
   * El constructor es privado para que no se pueda instancias.
   */
  private Memoria() {
  }

  private static final Map<String, Object> datos;

  static {
    datos = new HashMap<>();
  }

  public static void put(String key, Object value) {
    datos.put(key, value);
  }

  public static Object get(String key) {
    return datos.get(key);
  }

}
