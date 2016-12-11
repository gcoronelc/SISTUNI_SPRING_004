package pe.egcc.eureka.espec;


import java.util.Map;


public interface RowMapper<T> {
  
  T rowToBean(Map<String, Object> rs);
  
  
}
