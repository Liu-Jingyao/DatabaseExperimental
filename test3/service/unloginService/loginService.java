package service.unloginService;

import service.Service;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class loginService implements Service {
    @Override
    public void run(List<String> params, Map<String, Object> user) throws SQLException {
        if(!user.isEmpty()) {
            user.clear();
        }
        Map map = JdbcUtil.executeForMap("select * from account where user_name = ? and password = ?", params);
        if(!map.isEmpty()) {
            user.putAll(map);
            System.out.println("登录成功！" + user.get("type"));
        } else {
            System.out.println("用户名或密码错误！");
        }
    }
}
