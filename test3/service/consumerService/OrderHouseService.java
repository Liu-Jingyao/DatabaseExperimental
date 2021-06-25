package service.consumerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderHouseService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        List params1 = new ArrayList();
        Collections.addAll(params1, params.get(0), params.get(5));
        params.remove(5);
        JdbcUtil.update("insert into `order`(id, start_date, end_date, people_num, house_id, consumer_id) values (?, ?, ?, ?, ?, ?);", params);
        JdbcUtil.update("insert into coupon_consume(order_id, coupon_id) values (?, ?)", params1);
        JdbcUtil.update("update coupon set is_used=1 where id=?", params1.subList(1,2));
        System.out.println("预定成功！");
    }
}