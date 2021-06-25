package service.unloginService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PInfoUpdateService implements Service {

    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        params.add(params.get(0));
        JdbcUtil.update("update user set `user_name`=?, `password`=?, `name`=?, sex=?, age=?, id_card=?, phone=?, address=? where user_name=?", params);
        System.out.println("修改成功！");
    }
}
