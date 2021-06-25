package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AddServiceService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        JdbcUtil.update("insert into house_service values (?, ?);", params);
        System.out.println("新增成功！");
    }
}
