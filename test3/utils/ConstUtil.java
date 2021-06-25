package utils;

import menu.Impl.ConsumerMenu;
import menu.Impl.HouseOwnerMenu;
import menu.Impl.UnLoginMenu;

/**
 * 常量类
 */
public class ConstUtil {
    public static final String GLOBAL_PATTERN = "exit|^[0-9] *(?:((?:[-a-zA-Z0-9_\\u4e00-\\u9fa5] *)+)[, ]*)*$";
    public static final String PARAM_PATTERN = "((?:[-a-zA-Z0-9_\\u4e00-\\u9fa5] *)+)[, ]*";

    public static final UnLoginMenu unLoginMenu = new UnLoginMenu();
    public static final HouseOwnerMenu houseOwnerMenu = new HouseOwnerMenu();
    public static final ConsumerMenu consumerMenu = new ConsumerMenu();
}
