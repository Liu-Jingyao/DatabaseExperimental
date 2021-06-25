package service.consumerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HouseListService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        List<Map<String, Object>> mapList = JdbcUtil.executeForMapList("select * from house_info where is_rented = 0", new ArrayList<>());
        for(Map m : mapList) {
            m.put("services", JdbcUtil.executeForMapList("select service_name, introduction from house_service hs join service s on hs.service_id=s.id and hs.house_id=?", Arrays.asList(String.valueOf(m.get("house_id")))));
        }
        System.out.println(mapList);
    }
}
