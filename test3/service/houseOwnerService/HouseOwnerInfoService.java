package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HouseOwnerInfoService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        params.add(String.valueOf(user.get("user_id")));
        Map map = JdbcUtil.executeForMap("select * from house_owner_info where house_owner_id = ?", params);
        System.out.println(map);
    }
}