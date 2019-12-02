package com.longge.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author longge
 * @create 2019-12-02 下午4:23
 */
public class JdbcUtils {
    private static DataSource ds;
    static{
        try{
            Properties prop = new Properties();
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(in);
            ds = DruidDataSourceFactory.createDataSource(prop);
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
