package menu.Impl;

import menu.Menu;
import service.Service;
import service.houseOwnerService.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static utils.ConstUtil.unLoginMenu;

public class HouseOwnerMenu implements Menu {
    static private final Supplier[] suppliers = {HouseOwnerInfoService::new, OwnerHouseListService::new, AddHouseService::new,
    UpdateHouseService::new, DeleteHouseService::new, OwnerOrdersService::new, ConfirmOrderService::new, ServiceListService::new,
    AddServiceService::new, null};

    @Override
    public void show() {
        System.out.println("请输入指令：\n" +
                "0 个人信息\n" +
                "1 我的民宿\n" +
                "2 [id],[name],[abstract],[address] 新增民宿\n" +
                "3 [id],[name],[abstract],[address],[is_rented] 编辑民宿\n" +
                "4 [id] 删除民宿\n" +
                "5 订单列表\n" +
                "6 [id] 确认订单\n" +
                "7 服务列表\n" +
                "8 [huoseId],[serviceId] 添加服务\n"+
                "9 返回");
    }

    @Override
    public Menu serve(int type, List<String> params, Map<String, Object> user) throws SQLException {
        if(type == 9) {
            user.clear();
            return unLoginMenu;
        }
        Service registerService = (Service) suppliers[type].get();
        registerService.run(params, user);
        return this;
    }
}