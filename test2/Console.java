import utils.JdbcUtil;
import utils.RegexUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static utils.ConstUtil.*;

/**
 * 控制台主程序
 */
public class Console {
    public static void main(String[] args) {
        Scanner inp =  new Scanner(System.in);
        String cmd;
        do {
            // 数据读入
            cmd  = inp.nextLine();
            if (!RegexUtil.matches(GLOBAL_PATTERN, cmd)) {
                System.out.println("input error");
                return;
            }
            int type = Integer.parseInt(RegexUtil.matchOne(TYPE_PATTERN, cmd));
            String paramStr = cmd.substring(cmd.indexOf("-p")+3);
            List<String> params = RegexUtil.matchAll(PARAM_PATTERN, paramStr);

            // JDBC查询
            try {
                List<Map<String, Object>> result = JdbcUtil.executeForMapList(SQLS[type], params);
                System.out.println(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while(true);
    }
}