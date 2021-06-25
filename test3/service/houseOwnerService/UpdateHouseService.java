package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UpdateHouseService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        List<String> params1 = params.subList(1,5);
        params1.add(params.get(0));
        JdbcUtil.update("update house set house_name=?, house_abstract=?, address=?, is_rented=? where id = ?;", params1);
        System.out.println("更新成功！");
    }
}
