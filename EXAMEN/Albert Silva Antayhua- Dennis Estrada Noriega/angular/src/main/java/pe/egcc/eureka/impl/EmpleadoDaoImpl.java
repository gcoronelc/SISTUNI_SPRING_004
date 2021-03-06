package pe.egcc.eureka.impl;


import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import pe.egcc.eureka.espec.EmpleadoDaoSpec;
import pe.egcc.eureka.modelo.Empleado;
import pe.egcc.eureka.util.Memoria;

@Service("empleadoDaoImpl")
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
      // Paso 2: Generar el c�digo
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
      e.printStackTrace();
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
  public boolean validate(Empleado bean) {
	   
	  String SQL_SELECT = "SELECT chr_emplcodigo, vch_emplpaterno, "
	          + "vch_emplmaterno, vch_emplnombre, vch_emplciudad, "
	          + "vch_empldireccion, vch_emplusuario FROM empleado ";
	      String sql = SQL_SELECT 
	              + " WHERE vch_emplusuario = ? AND vch_emplclave = ?";
	      SqlRowSet sqlRowSet =  getJdbcTemplate().queryForRowSet(sql,bean.getUsuario(),bean.getClave());
	      if(sqlRowSet.next()){
	    	  Map<String, Object> rs= jdbcTemplate.queryForMap(sql,bean.getUsuario(),bean.getClave());
		      bean=rowToBean(rs);
		      Memoria.put("usuario",bean);
		      System.out.println(bean.getCodigo());
	    	  return true;}
	        else return false;
	      
	      	          	    
  }
  @Override
  public Empleado rowToBean(Map<String, Object> rs) {
    Empleado bean = new Empleado();
    bean.setCodigo(rs.get("chr_emplcodigo").toString());
    bean.setPaterno(rs.get("vch_emplpaterno").toString());
    bean.setMaterno(rs.get("vch_emplmaterno").toString());
    bean.setNombre(rs.get("vch_emplnombre").toString());
    bean.setCiudad(rs.get("vch_emplciudad").toString());
    bean.setDireccion(rs.get("vch_empldireccion").toString());
    bean.setUsuario(rs.get("vch_emplusuario").toString());
    return bean;
  }

}
