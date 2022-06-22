package 课设.Dao;

public class StringUtils {
    public static boolean isEmpty(String str) {
        if(str==null ||"".equals(str.trim())) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断是否不是空
     * @param str
     * @return
     */

    public static boolean isNotEmpty(String str) {
        if(str!=null&&!"".equals(str.trim())) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNotEmpty(int id) {
        // TODO 自动生成的方法存根
        if(id!=0) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isSame(String str1,String str2) {
        if (str1.equals(str2)) {
            return true;
        }else {
            return false;
        }
    }

}
