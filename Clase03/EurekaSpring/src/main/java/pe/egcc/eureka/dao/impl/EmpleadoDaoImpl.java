package pe.egcc.eureka.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.eureka.dao.spec.EmpleadoDaoSpec;
import pe.egcc.eureka.model.Empleado;

@Repository
public class EmpleadoDaoImpl extends AbstractDao implements EmpleadoDaoSpec {

  @Override
  public void insert(Empleado bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Empleado bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String codigo) {
    // TODO Auto-generated method stub

  }

  @SuppressWarnings("unchecked")
  @Override
  public Empleado read(String codigo) {
    Empleado bean = null;
    try {
      String sql = "select chr_emplcodigo codigo, "
          + "vch_emplpaterno paterno, "
          + "vch_emplmaterno materno, "
          + "vch_emplnombre nombre, "
          + "vch_emplciudad ciudad, "
          + "vch_empldireccion direccion, "
          + "vch_emplusuario usuario "
          + "from empleado "
          + "where chr_emplcodigo = ?";
      Object[] args = {codigo};
      System.out.println(sql);
      bean = jdbcTemplate.queryForObject(sql, args, 
          new BeanPropertyRowMapper(Empleado.class)); 
    } catch (Exception e) {
      e.printStackTrace();
      bean = null;
    }
    return bean;
  }

  @Override
  public List<Empleado> read(Empleado bean) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Empleado validate(String usuario, String clave) {
    // TODO Auto-generated method stub
    return null;
  }

}
