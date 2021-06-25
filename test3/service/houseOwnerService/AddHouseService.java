package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AddHouseService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        params.add(String.valueOf(user.get("user_id")));
        JdbcUtil.update("insert into house(id, house_name, house_abstract, address, owner_id) values (?, ?, ?, ?, ?);", params);
        System.out.println("新增成功！");
    }
}
