package pe.egcc.eureka.dao.spec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public interface CrudDaoSpec<T> {
  
  void insert(T bean);
  
  void update(T bean);
  
  void delete(String codigo);
  
  T read(String codigo);
  
  List<T> read(T bean);
  
}
