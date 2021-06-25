package service.consumerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CouponListService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        List<Map<String, Object>> mapList = JdbcUtil.executeForMapList("select * from coupon where consumer_id = ? and is_used=0", params);
        System.out.println(mapList);
    }
}