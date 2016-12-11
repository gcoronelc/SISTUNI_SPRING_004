package pe.egcc.eureka.impl;



import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	
	
	protected JdbcTemplate jdbcTemplate;

	  @Autowired
	  public final void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	  }

 
  protected static JSONArray SqlRowSetToJson(SqlRowSet sqlRowSet)
  {
      JSONArray list = new JSONArray();


      SqlRowSetMetaData sqlRowSetMetaData = sqlRowSet.getMetaData();
      while(sqlRowSet.next())
      {
          JSONObject obj = new JSONObject();
          for(int i = 1;i <= sqlRowSetMetaData.getColumnCount(); i++)
          {
              obj.put(sqlRowSetMetaData.getColumnName(i), sqlRowSet.getString(i)==null?"":sqlRowSet.getString(i));
          }
          list.put(obj);

      }

      return list;

  }
	
  public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
	
  /*protected static JSONArray SqlRowSetToJson(SqlRowSet sqlRowSet)
    {
        JSONArray list = new JSONArray();


        SqlRowSetMetaData sqlRowSetMetaData = sqlRowSet.getMetaData();
        while(sqlRowSet.next())
        {
            JSONObject obj = new JSONObject();
            for(int i = 1;i <= sqlRowSetMetaData.getColumnCount(); i++)
            {
                obj.put(sqlRowSetMetaData.getColumnName(i), sqlRowSet.getString(i)==null?"":sqlRowSet.getString(i));
            }
            list.put(obj);

        }

        return list;

    }*/

}



