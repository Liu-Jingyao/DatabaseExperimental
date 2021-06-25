package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OwnerHouseListService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        params.add(String.valueOf(user.get("user_id")));
        List<Map<String, Object>> mapList = JdbcUtil.executeForMapList("select * from house_info where owner_id = ?", params);
        for(Map m : mapList) {
            m.put("services", JdbcUtil.executeForMapList("select service_name, introduction from house_service hs join service s on hs.service_id=s.id and hs.house_id=?", Arrays.asList(String.valueOf(m.get("house_id")))));
        }
        System.out.println(mapList);
    }
}