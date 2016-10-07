package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;

public abstract class DatabaseModel {
    private DriverManagerDataSource dataSource;


    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void setDataSource() {
        dataSource  = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");

        dataSource.setUrl("jdbc:h2:file:./src/main/resources/db");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DatabaseModel save(String tableName, HashMap<String, Object> params){
        String sql = buildSQLInsertStatement(tableName, params);
        setDataSource();
        jdbcTemplate.update(sql);
        return this;
    }

    private String buildSQLInsertStatement(String tableName, HashMap<String, Object> params){
        String sql = "INSERT INTO " + tableName + " (";

        for(String column: params.keySet()){
            sql += column + ", ";
        }

        sql += ") VALUES (";

        for (Object value: params.values()){
            sql += value +", ";
        }
        sql += ")";
        return sql;
    }


}
