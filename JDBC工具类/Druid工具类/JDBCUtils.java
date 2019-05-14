package datasource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid的工具类
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        //加载配置文件

        try {
            Properties pro = new Properties();
            String path = JDBCUtils1.class.getClassLoader().getResource("druid.properties").getPath();
            pro.load(new FileReader(path));
            ds= DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getconnection() throws SQLException {
        return ds.getConnection();
    }
    public static  void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public static  void close(ResultSet rs,Statement stmt, Connection conn){
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
    }
    /**
     * 返回DataSource方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
