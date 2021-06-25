package utils;

/**
 * 常量类
 */
public class ConstUtil {
    public static final String GLOBAL_PATTERN = "^company_query –q [1-9] -p (?:((?:[a-zA-Z0-9_\\u4e00-\\u9fa5] *)+)[, ]*)*$";
    public static final String TYPE_PATTERN = "–q ([1-9])";
    public static final String PARAM_PATTERN = "((?:[a-zA-Z0-9_\\u4e00-\\u9fa5] *)+)[, ]*";

    public static final String SQL1 = "SELECT ESSN FROM WORKS_ON WHERE PNO = ?";
    public static final String SQL2 = "SELECT ENAME FROM EMPLOYEE EMPLOYEE NATURAL JOIN WORKS_ON NATURAL JOIN PROJECT WHERE PNAME = ?";
    public static final String SQL3 = "SELECT ENAME FROM EMPLOYEE EMPLOYEE NATURAL JOIN WORKS_ON NATURAL JOIN PROJECT WHERE PNAME = ?";
    public static final String SQL4 = "SELECT ENAME, ADDRESS FROM EMPLOYEE NATURAL JOIN DEPARTMENT WHERE DNAME = ? AND SALARY < ?";
    public static final String SQL5 = "SELECT ENAME FROM EMPLOYEE WHERE ESSN NOT IN (SELECT ESSN FROM WORKS_ON WHERE PNO = ?)";
    public static final String SQL6 = "SELECT E.ENAME, D.DNAME FROM EMPLOYEE E NATURAL JOIN DEPARTMENT D, EMPLOYEE M WHERE E.SUPERSSN = M.ESSN AND M.ENAME = ?";
    public static final String SQL7 = "SELECT ESSN FROM EMPLOYEE E WHERE NOT EXISTS (\n" +
            "SELECT * FROM PROJECT P WHERE NOT EXISTS (\n" +
            "SELECT * FROM WORKS_ON W WHERE E.ESSN = W.ESSN AND W.PNO = P.PNO ) AND PNO IN ( ?, ? ))";
    public static final String SQL8 = "SELECT DNAME FROM EMPLOYEE NATURAL JOIN DEPARTMENT GROUP BY (DNAME) HAVING AVG(SALARY) < ?";
    public static final String SQL9 = "SELECT ENAME FROM EMPLOYEE NATURAL JOIN WORKS_ON GROUP BY ESSN HAVING COUNT(PNO) > ? AND SUM(HOURS_PER_WEEK) >= ?";
    public static final String[] SQLS = {null, SQL1, SQL2, SQL3, SQL4, SQL5, SQL6, SQL7, SQL8, SQL9};
}
