package service.consumerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ConsumerInfoService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        Map map = JdbcUtil.executeForMap("select * from consumer_info where consumer_id = ?", params);
        System.out.println(map);
    }
}
