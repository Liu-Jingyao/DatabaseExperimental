package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OwnerOrdersService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        params.add(String.valueOf(user.get("user_id")));
        List<Map<String, Object>> mapList = JdbcUtil.executeForMapList("select * from `order` o join house h on o.house_id = h.id where owner_id = ?", params);
        System.out.println(mapList);
    }
}
