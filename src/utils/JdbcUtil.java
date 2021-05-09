package utils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * Jdbc工具类
 */
public class JdbcUtil {
    private static String url = "jdbc:mysql://rm-bp1oo27t8762xhlob0o.mysql.rds.aliyuncs.com:3306/hitwh2191110514";
    private static String username = "lab_1731225747";
    private static String password = "b9b6caf04f7d_#@Aa";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> executeForMapList(String sql, List<String> params) throws SQLException{
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = null;
        List<Map<String, Object>> mapList = null;

        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1, params.get(i));
            }
        }

        resultSet = statement.executeQuery();
        mapList = convertList(resultSet);
        close(connection, statement, resultSet);

        return mapList;
    }

    public static List<Map<String, Object>> convertList(ResultSet rs) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                Object tmp = rs.getObject(i);
                if(rs.getObject(i) instanceof Long){
                    tmp = rs.getInt(i);
                }
                if(rs.getObject(i) instanceof BigDecimal) {
                    tmp = rs.getString(i);
                }
                rowData.put(md.getColumnName(i), tmp);
            }
            list.add(rowData);
        }
        return list;
    }
}