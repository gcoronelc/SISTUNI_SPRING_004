package pe.egcc.eureka.impl;

import java.util.List;

import org.json.JSONArray;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import pe.egcc.eureka.espec.SucursalDaoSpec;
import pe.egcc.eureka.modelo.Sucursal;

@Service("sucursalDaoImpl")
public class SucursalDaoImpl extends AbstractDao implements SucursalDaoSpec {

	@Override
	public void insert(Sucursal bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Sucursal bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Sucursal read(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sucursal> read(Sucursal bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray traerCuentaSucursal(String cuenta) {
		String sql = "select * from SUCURSAL s "
				+ "inner join CUENTA c on S.CHR_SUCUCODIGO = C.CHR_SUCUCODIGO "
				+ "where S.CHR_SUCUCODIGO = ?";
		 SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, cuenta);
		 return SqlRowSetToJson(sqlRowSet);
	}

}
