package service.unloginService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ConsumerRegisterService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        JdbcUtil.update("insert into user(id, user_name, password) values (?, ?, ?);", params);
        JdbcUtil.update("insert into consumer(user_id) values (?);", params.subList(0, 1));
        JdbcUtil.update("insert into coupon(consumer_id, discount_amount) VALUES(?, 100);", params.subList(0, 1));
        JdbcUtil.update("insert into coupon(consumer_id, discount_amount) VALUES(?, 100);", params.subList(0, 1));
        JdbcUtil.update("insert into coupon(consumer_id, discount_amount) VALUES(?, 100);", params.subList(0, 1));
        System.out.println("注册成功！");
    }
}