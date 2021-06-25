package utils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;


public class JdbcUtil {
    private static String url = "jdbc:mysql://rm-bp1oo27t8762xhlob0o.mysql.rds.aliyuncs.com:3306/hitwh2191110514?tinyInt1isBit=false";
    private static String username = "lab_1731225747";
    private static String password = "b9b6caf04f7d_#@Aa";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = getConnection();
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

    private static void close(Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void update(String sql, List<String> params) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = null;

        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1, params.get(i));
            }
        }

        statement.executeUpdate();
        close(statement, resultSet);
    }
    public static Map<String, Object> executeForMap(String sql, List<String> params) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = null;
        Map<String, Object> map = null;

        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1, params.get(i));
            }
        }

        resultSet = statement.executeQuery();
        map = convertMap(resultSet);
        close(statement, resultSet);

        return map;
    }

    public static List<Map<String, Object>> executeForMapList(String sql, List<String> params) throws SQLException{
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
        close(statement, resultSet);

        return mapList;
    }

    public static Map<String, Object> convertMap(ResultSet rs) throws SQLException {
        Map<String, Object> map = new TreeMap<String, Object>();
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object rsObject = rs.getObject(i);
                if(rsObject instanceof Long){
                    rsObject = rs.getInt(i);
                }
                if(rsObject instanceof BigDecimal) {
                    rsObject = rs.getString(i);
                }
                map.put(md.getColumnName(i), rsObject);
            }
        }
        return map;
    }

    public static List<Map<String, Object>> convertList(ResultSet rs) throws SQLException{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            Map<String, Object> rowData = new HashMap<String, Object>();
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
