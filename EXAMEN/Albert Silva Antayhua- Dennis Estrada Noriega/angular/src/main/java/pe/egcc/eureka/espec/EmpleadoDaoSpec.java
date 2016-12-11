package pe.egcc.eureka.espec;

import pe.egcc.eureka.modelo.Empleado;


public interface EmpleadoDaoSpec extends CrudDaoSpec<Empleado>, RowMapper<Empleado>{
  
  boolean validate(Empleado bean);
  
}
