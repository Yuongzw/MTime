package com.yuong.library_base.router;

/**
 * 用于组件开发中，ARouter多Fragment跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 * Created by goldze on 2018/6/21
 */

public class RouterFragmentPath {
    /**
     * 首页组件
     */
    public static class Hot {
        private static final String HOT = "/hot";
        /*首页*/
        public static final String PAGER_HOT = HOT + "/Hot";
    }

    /**
     * 工作组件
     */
    public static class Ticket {
        private static final String TICKET = "/ticket";
        /*工作*/
        public static final String PAGER_TICKET = TICKET + "/Ticket";
    }

    /**
     * 消息组件
     */
    public static class Coming {
        private static final String COMING = "/coming";
        /*消息*/
        public static final String PAGER_COMING = COMING + "/Coming";
    }

    /**
     * 用户组件
     */
    public static class User {
        private static final String USER = "/user";
        /*我的*/
        public static final String PAGER_ME = USER + "/Me";
    }
}
