package menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Menu {
    void show();

    Menu serve(int type, List<String> params, Map<String, Object> user) throws SQLException;
}
