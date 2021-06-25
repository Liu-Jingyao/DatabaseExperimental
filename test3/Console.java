import menu.Impl.ConsumerMenu;
import menu.Impl.HouseOwnerMenu;
import menu.Impl.UnLoginMenu;
import menu.Menu;
import utils.JdbcUtil;
import utils.RegexUtil;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import static utils.ConstUtil.*;

public class Console {
    static final Scanner inp =  new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = unLoginMenu;
        String cmd;
        Map<String, Object> user = new HashMap<>();
        do {
            try {
                menu.show();

                cmd  = inp.nextLine();
                if("exit".equals(cmd)) {
                    break;
                }
                if (!RegexUtil.matches(GLOBAL_PATTERN, cmd)) {
                    System.out.println("input error");
                    continue;
                }

                int type = Integer.parseInt(cmd.substring(0, 1));
                String paramStr;
                if(cmd.length() > 1)  paramStr = cmd.substring(2);
                else paramStr = "";
                List<String> params = RegexUtil.matchAll(PARAM_PATTERN, paramStr);

                menu = menu.serve(type, params, user);
            } catch (SQLIntegrityConstraintViolationException e) {
                e.printStackTrace();
                System.out.println("违反完整性约束！");
            } catch (SQLSyntaxErrorException e) {
                e.printStackTrace();
                System.out.println("参数输入错误！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while(true);
        JdbcUtil.release();
    }
}
