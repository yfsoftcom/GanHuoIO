package ren.solid.ganhuoio.constant;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import ren.solid.ganhuoio.GanHuoIOApplication;
import ren.solid.library.utils.Logger;
import ren.solid.library.utils.PrefUtils;

/**
 * Created by _SOLID
 * Date:2016/5/16
 * Time:16:13
 */
public class Apis {

    public static String[] GanHuoCateGory = new String[]{"all", "休息视频", "福利", "Android", "iOS", "拓展资源", "前端", "瞎推荐"};

    public static List<String> getGanHuoCateGory() {

        List<String> list = new ArrayList<>();
        String prefCategory = PrefUtils.getString(GanHuoIOApplication.getInstance(), "HomeCategory", "");
        if (TextUtils.isEmpty(prefCategory)) {

            for (int i = 0; i < GanHuoCateGory.length; i++) {
                list.add(GanHuoCateGory[i]);
            }
        } else {
            String[] str = prefCategory.split("\\|");
            for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
            }
        }
        return list;
    }

    public static class Urls {
        /**
         * 获取发布过干货的日期
         */
        public static String GanHuoDates = "http://gank.io/api/day/history";
        /**
         * 获取特定日期网站数据
         * <p/>
         * http://gank.io/api/history/content/day/2016/05/11
         */
        public static String GanHuoContent = "http://gank.io/api/history/content/day/";

        /**
         * http://gank.io/api/data/福利/10/1
         * <p/>
         * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
         */
        public static String GanHuoData = "http://gank.io/api/data/";

        /**
         * 每日数据： http://gank.io/api/day/年/月/日
         */
        public static String GanHuoDataByDay = "http://gank.io/api/day/";
    }
}
