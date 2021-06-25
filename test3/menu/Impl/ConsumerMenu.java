package menu.Impl;

import menu.Menu;
import service.Service;
import service.consumerService.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static utils.ConstUtil.*;

public class ConsumerMenu implements Menu {
    static private final Supplier[] suppliers = {ConsumerInfoService::new, HouseListService::new, OrderHouseService::new,
    OrderListService::new, CouponListService::new, null};

    @Override
    public void show() {
        System.out.println("请输入指令：\n" +
                "0 个人信息\n" +
                "1 民宿列表\n" +
                "2 [id],[startDate],[endDate],[peopleNum],[houseId],[couponId] 预订民宿\n" +
                "3 我的订单\n" +
                "4 我的优惠券\n" +
                "5 返回");
    }

    @Override
    public Menu serve(int type, List<String> params, Map<String, Object> user) throws SQLException {
        if(type == 5) {
            user.clear();
            return unLoginMenu;
        }
        Service registerService = (Service) suppliers[type].get();
        params.add(String.valueOf(user.get("user_id")));
        registerService.run(params, user);
        return this;
    }
}