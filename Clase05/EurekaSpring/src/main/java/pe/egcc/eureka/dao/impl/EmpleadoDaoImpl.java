package pe.egcc.eureka.dao.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.SpringServletContainerInitializer;

import pe.egcc.eureka.dao.spec.EmpleadoDaoSpec;
import pe.egcc.eureka.model.Empleado;

@Repository
public class EmpleadoDaoImpl extends AbstractDao implements EmpleadoDaoSpec {

  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRES_NEW)
  @Override
  public void insert(Empleado bean) {
    try {
      // Paso 1: Leer contador
      String sql = "select int_contitem, int_contlongitud "
          + "from contador where vch_conttabla='Empleado' "
          + "for update ";
      Map<String, Object> rec = jdbcTemplate.queryForMap(sql);
      int item = Integer.parseInt(rec.get("int_contitem").toString());
      int size = Integer.parseInt(rec.get("int_contlongitud").toString());
      // Paso 2: Generar el código
      item++;
      String codigo = String.format("%0" + size + "d", item);
      //Thread.currentThread().sleep(1000);
      // Paso 3: Actualizar el contador
      sql = "update contador set int_contitem = ? "
          + "where vch_conttabla='Empleado'";
      Object[] args = new Object[]{item};
      int filas = jdbcTemplate.update(sql, args);
      if( filas != 1){
        throw new RuntimeException("No se ha podido actualizar el contador.");
      }
      // Paso 4: Insertar el nuevo empleado
      sql = "insert into empleado(chr_emplcodigo,"
          + "vch_emplpaterno,vch_emplmaterno,"
          + "vch_emplnombre,vch_emplciudad,"
          + "vch_empldireccion,vch_emplusuario,"
          + "vch_emplclave) values(?,?,?,?,?,?,?,?)";
      args = new Object[]{codigo,bean.getPaterno(),
          bean.getMaterno(),bean.getNombre(),
          bean.getCiudad(),bean.getDireccion(),
          bean.getUsuario(),bean.getClave()};
      jdbcTemplate.update(sql,args);
      bean.setCodigo(codigo);
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("No es ha encontrado el contador.");
    } /*catch (InterruptedException e) {
      throw new RuntimeException("Error en el hilo.");
    }*/
  }

  @Override
  public void update(Empleado bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String codigo) {
    // TODO Auto-generated method stub

  }

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
          new BeanPropertyRowMapper<Empleado>(Empleado.class)); 
    } catch (Exception e) {
      //e.printStackTrace();
      bean = null;
    }
    return bean;
  }

  /**
   * La consulta puede ser por paterno, materno o nombre.
   * 
   */
  @Override
  public List<Empleado> read(Empleado bean) {
    String sql = "select chr_emplcodigo codigo, "
        + "vch_emplpaterno paterno, "
        + "vch_emplmaterno materno, "
        + "vch_emplnombre nombre, "
        + "vch_emplciudad ciudad, "
        + "vch_empldireccion direccion, "
        + "vch_emplusuario usuario "
        + "from empleado "
        + "where upper(vch_emplpaterno) like concat(?,'%') "
        + "and upper(vch_emplmaterno) like concat(?,'%') "
        + "and upper(vch_emplnombre) like concat(?,'%') ";
    Object[] args = {
        bean.getPaterno().toUpperCase() + "%",
        bean.getMaterno().toUpperCase() + "%",
        bean.getNombre().toUpperCase() + "%" };
    List<Empleado> lista = jdbcTemplate.query(sql, args, 
        new BeanPropertyRowMapper<Empleado>(Empleado.class));
    return lista;
  }

  @Override
  public Empleado validate(String usuario, String clave) {
    // TODO Auto-generated method stub
    return null;
  }

}
