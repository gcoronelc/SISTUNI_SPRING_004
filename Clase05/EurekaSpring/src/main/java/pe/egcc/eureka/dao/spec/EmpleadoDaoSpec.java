package pe.egcc.eureka.dao.spec;

import pe.egcc.eureka.model.Empleado;

/**
 *
 * @author Gustavo Coronel
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @github github.com/gcoronelc
 */
public interface EmpleadoDaoSpec 
        extends CrudDaoSpec<Empleado>{
  
  Empleado validate(String usuario, String clave);
  
}
