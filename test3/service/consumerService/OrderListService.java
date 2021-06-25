package service.consumerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderListService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        List<Map<String, Object>> mapList = JdbcUtil.executeForMapList("select * from `order` where consumer_id = ?", params);
        System.out.println(mapList);
    }
}