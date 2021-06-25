package menu.Impl;

import menu.Menu;
import service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import service.unloginService.*;

import static utils.ConstUtil.*;

public class UnLoginMenu implements Menu {
    static private final Supplier[] suppliers = {loginService::new, HouseOwnerRegisterService::new, ConsumerRegisterService::new, PInfoUpdateService::new};

    @Override
    public void show() {
        System.out.println("请输入指令：\n" +
                "0 [user_name],[password] 登录\n" +
                "1 [id],[user_name],[password] 注册为房东\n" +
                "2 [id],[user_name],[password] 注册为消费者\n" +
                "3 [user_name],[password],[name],[sex],[age],[id_card],[phone],[address] 个人信息修改\n" +
                "exit 退出");
    }

    @Override
    public Menu serve(int type, List<String> params, Map<String, Object> user) throws SQLException {
        Service registerService = (Service) suppliers[type].get();
        registerService.run(params, user);
        if(user.isEmpty())  return this;
        if("house_owner".equals(user.get("type"))) {
            return houseOwnerMenu;
        } else {
            return consumerMenu;
        }
    }
}