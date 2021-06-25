package service.houseOwnerService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DeleteHouseService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        JdbcUtil.update("delete from house where id = ?;", params);
        System.out.println("删除成功！");
    }
}
