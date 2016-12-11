package pe.egcc.eureka.impl;


import java.util.Map;

import org.json.JSONArray;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import pe.egcc.eureka.espec.CuentaDaoSpec;


@Service("cuentaDaoImpl")
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
	public JSONArray traerMovimientos(String cuenta) {
		 String sql = "select sucucodigo, sucunombre, cliecodigo, "
			        + "cliepaterno, cliematerno, clienombre, cuencodigo,"
			        + "cuensaldo, cuenestado, movinumero, movifecha,"
			        + "moviimporte, cuenreferencia, tipocodigo, tiponombre,"
			        + "tipoaccion, monecodigo, monenombre from v_movimiento "
			        + "where cuencodigo = ?";
			    
		 SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, cuenta);
	 return SqlRowSetToJson(sqlRowSet);
	}
	
	@Transactional(
		      rollbackFor=Exception.class, 
		      propagation=Propagation.REQUIRES_NEW)
	@Override
	public void doDeposito(String cuenta, double importe, String codEmp) {
	  
	    try {
	      
	      String sql = "select int_cuencontmov "
	              + "from cuenta where chr_cuencodigo = ? "
	              + "for update";
	      Object[] args = new Object[]{cuenta};
	      Map<String, Object> rec = jdbcTemplate.queryForMap(sql,args);
	      int cont=Integer.parseInt(rec.get("int_cuencontmov").toString()); 
	      // Actualizar cuenta
	      cont++;
	      sql = "update cuenta "
	              + "set dec_cuensaldo = dec_cuensaldo + ?, "
	              + "int_cuencontmov = int_cuencontmov + 1 "
	              + "where chr_cuencodigo = ? ";
	      args=new Object[]{importe,cuenta};
	      int filas=jdbcTemplate.update(sql,args);
	      if(filas !=1){
	    	  throw new RuntimeException("No se ha podido actualizar el contador.");
	      }
	      // Insertar el movimiento
	      sql = "insert into movimiento(chr_cuencodigo, "
	              + "int_movinumero,dtt_movifecha, "
	              + "chr_emplcodigo,chr_tipocodigo, "
	              + "dec_moviimporte)  "
	              + "values(?,?,SYSDATE,?,'003',?)";
	      args=new Object[]{cuenta,cont,codEmp,importe};
	      jdbcTemplate.update(sql,args);
	      
	    } catch (EmptyResultDataAccessException e) {
	        throw new RuntimeException("No es ha encontrado el contador.");
	      }
	  }
	@Transactional(
		      rollbackFor=Exception.class, 
		      propagation=Propagation.REQUIRES_NEW)
	@Override
	public void procRetiro(String cuenta,double importe, String clave,String codEmp) {
	   
	    try {
	      String sql = "select DEC_CUENSALDO, INT_CUENCONTMOV "
	              + "from cuenta where CHR_CUENCODIGO = ? and CHR_CUENCLAVE= ? "
	              + "for update";
	      Object[] args = new Object[]{cuenta,clave};
	      Map<String, Object> rec = jdbcTemplate.queryForMap(sql,args);
	      double saldo=Double.parseDouble(rec.get("DEC_CUENSALDO").toString()); 
	      int cont=Integer.parseInt(rec.get("INT_CUENCONTMOV").toString()); 
	      	    
	      // Verificar saldo
	      saldo -= importe;
	      if (saldo >= 0) {
	    	// Actualizar tabla CUENTA
		      cont++;
		      sql = "update cuenta set DEC_CUENSALDO = ?,"
		              + "INT_CUENCONTMOV = ? "
		              + "where CHR_CUENCODIGO = ?";
		      args=new Object[]{saldo,cont,cuenta};
		      int filas=jdbcTemplate.update(sql,args);
		      if(filas !=1){
		    	  throw new RuntimeException("Cuenta no es correcta.");
		      }	      	     
		      // Registrar movimiento
		      sql = "insert into movimiento(CHR_CUENCODIGO,"
		              + "INT_MOVINUMERO,DTT_MOVIFECHA,"
		              + "CHR_EMPLCODIGO,CHR_TIPOCODIGO,"
		              + "DEC_MOVIIMPORTE) "
		              + "values(?, ?, SYSDATE, ?, '004', ?)";
		      args=new Object[]{cuenta,cont,codEmp,importe};
		      jdbcTemplate.update(sql,args);
	      }
	      
	      
	    } catch (EmptyResultDataAccessException e) {
	        throw new RuntimeException("No es ha encontrado el contador.");
	      }
	  }

}
