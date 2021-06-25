package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Service {
    void run(List<String> paramsm, Map<String, Object> user) throws SQLException;
}
