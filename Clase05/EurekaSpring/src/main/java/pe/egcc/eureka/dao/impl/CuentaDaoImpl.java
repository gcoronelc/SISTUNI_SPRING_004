package pe.egcc.eureka.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.eureka.dao.spec.CuentaDaoSpec;

@Repository
public class CuentaDaoImpl extends AbstractDao implements CuentaDaoSpec {

  @Override
  public double traerSaldo(String cuenta) {
    double saldo = 0.0;
    try{
      String sql = "select dec_cuensaldo from cuenta "
          + "where chr_cuencodigo=?";
      Object[] args = {cuenta};
      saldo = jdbcTemplate
          .queryForObject(sql, args, Double.class) ;
    } catch(EmptyResultDataAccessException e){
      throw new RuntimeException("Cuenta no existe.");
    }
    return saldo;
  }

  @Override
  public List<Map<String, Object>> traerMovimientos(String cuenta) {
    String sql = "select sucucodigo, sucunombre, cliecodigo, "
        + "cliepaterno, cliematerno, clienombre, cuencodigo,"
        + "cuensaldo, cuenestado, movinumero, movifecha,"
        + "moviimporte, cuenreferencia, tipocodigo, tiponombre,"
        + "tipoaccion, monecodigo, monenombre from v_movimiento "
        + "where cuencodigo = ?";
    Object[] args = {cuenta};
    List<Map<String,Object>> lista = 
        jdbcTemplate.queryForList(sql, args);
    return lista;
  }
  
}
