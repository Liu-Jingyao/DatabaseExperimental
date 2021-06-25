package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ConfirmOrderService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        JdbcUtil.update("update `order` set status = '确认' where id = ?;", params);
        System.out.println("确认成功！");
    }
}

