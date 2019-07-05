package com.yuong.library_base.bean;

import java.util.List;

public class TicketingBean {

    /**
     * count : 15
     * movies : [{"actorName1":"吴京","actorName2":"屈楚萧","btnText":"","commonSpecial":"吴京领衔国产硬科幻电影","directorName":"郭帆","img":"http://img5.mtime.cn/mt/2019/01/30/152305.14999287_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":125,"movieId":218707,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":108,"nearestShowDay":1550131200,"nearestShowtimeCount":1945},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":8,"titleCn":"流浪地球","titleEn":"The Wandering Earth","type":"冒险 / 科幻 / 剧情","wantedCount":3104},{"actorName1":"王大陆","actorName2":"林允","btnText":"","commonSpecial":"王大陆林允上演甜蜜\u201c女追男\u201d","directorName":"陈玉珊","img":"http://img5.mtime.cn/mt/2019/01/24/095735.15787277_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":true,"length":122,"movieId":261355,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":117,"nearestShowDay":1550131200,"nearestShowtimeCount":829},"preferentialFlag":false,"rDay":14,"rMonth":2,"rYear":2019,"ratingFinal":-1,"titleCn":"一吻定情","titleEn":"Fall in Love at First Kiss","type":"爱情 / 喜剧","wantedCount":261},{"actorName1":"黄渤","actorName2":"沈腾","btnText":"","commonSpecial":"黄渤沈腾遭外星\u201c大佬\u201d绑架","directorName":"宁浩","img":"http://img5.mtime.cn/mt/2019/01/25/112700.66692130_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":116,"movieId":230385,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":106,"nearestShowDay":1550131200,"nearestShowtimeCount":786},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":6.8,"titleCn":"疯狂的外星人","titleEn":"Crazy Alien","type":"喜剧 / 剧情 / 科幻","wantedCount":3321},{"actorName1":"绫濑遥","actorName2":"坂口健太郎","btnText":"","commonSpecial":"绫濑遥坂口健太郎书写爱情童话","directorName":"武内英树","img":"http://img5.mtime.cn/mt/2019/02/02/171256.17684023_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":true,"length":109,"movieId":249811,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":89,"nearestShowDay":1550131200,"nearestShowtimeCount":318},"preferentialFlag":false,"rDay":14,"rMonth":2,"rYear":2019,"ratingFinal":6.7,"titleCn":"今夜在浪漫剧场","titleEn":"Tonight, at the Movies","type":"奇幻 / 爱情","wantedCount":129},{"actorName1":"谢楠","actorName2":"方力申","btnText":"","commonSpecial":"","directorName":"李依理","img":"http://img5.mtime.cn/mt/2019/01/29/093512.33552026_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":true,"length":92,"movieId":249886,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":70,"nearestShowDay":1550131200,"nearestShowtimeCount":112},"preferentialFlag":false,"rDay":14,"rMonth":2,"rYear":2019,"ratingFinal":-1,"titleCn":"五十米之恋","titleEn":"Love in 50 Meters","type":"爱情 / 剧情","wantedCount":245},{"actorName1":"许凯","actorName2":"赵露思","btnText":"","commonSpecial":"","directorName":"王才涛","img":"http://img5.mtime.cn/mt/2019/01/28/161118.90571268_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":true,"length":104,"movieId":240446,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":38,"nearestShowDay":1550131200,"nearestShowtimeCount":77},"preferentialFlag":false,"rDay":14,"rMonth":2,"rYear":2019,"ratingFinal":-1,"titleCn":"蓝色生死恋","titleEn":"Autumn fairy tale","type":"爱情","wantedCount":50},{"actorName1":"沈腾","actorName2":"黄景瑜","btnText":"","commonSpecial":"韩寒联手沈腾再战赛车题材","directorName":"韩寒","img":"http://img5.mtime.cn/mt/2019/01/07/141550.78907967_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":98,"movieId":254868,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":106,"nearestShowDay":1550131200,"nearestShowtimeCount":664},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":7.2,"titleCn":"飞驰人生","titleEn":"Pegasus","type":"喜剧","wantedCount":2457},{"actorName1":"","actorName2":"","btnText":"","commonSpecial":"熊二光头强误入原始森林大冒险","directorName":"丁亮","img":"http://img5.mtime.cn/mt/2018/11/27/084318.51885265_1280X720X2.jpg","is3D":true,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":91,"movieId":262215,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":96,"nearestShowDay":1550131200,"nearestShowtimeCount":279},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":6.8,"titleCn":"熊出没·原始时代","titleEn":"Boonie Bears: Blast into the Past","type":"动画 / 冒险 / 喜剧","wantedCount":479},{"actorName1":"罗莎·萨拉扎尔","actorName2":"克里斯托弗·瓦尔兹","btnText":"","commonSpecial":"","directorName":"罗伯特·罗德里格兹","img":"http://img5.mtime.cn/mt/2019/01/09/171109.88229500_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":122,"movieId":25412,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":45,"nearestShowDay":1550736000,"nearestShowtimeCount":60},"preferentialFlag":false,"rDay":22,"rMonth":2,"rYear":2019,"ratingFinal":7.2,"titleCn":"阿丽塔：战斗天使","titleEn":"Alita: Battle Angel","type":"科幻 / 动作 / 冒险","wantedCount":4957},{"actorName1":"王宝强","actorName2":"鄂靖文","btnText":"","commonSpecial":"周星驰合作\u201c龙套巨星\u201d王宝强","directorName":"周星驰","img":"http://img5.mtime.cn/mt/2019/02/02/113216.53857992_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":91,"movieId":135808,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":37,"nearestShowDay":1550131200,"nearestShowtimeCount":62},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":6.9,"titleCn":"新喜剧之王","titleEn":"The New King of Comedy","type":"喜剧","wantedCount":2182},{"actorName1":"成龙","actorName2":"阮经天","btnText":"","commonSpecial":"成龙演绎\"大忽悠\"蒲松龄","directorName":"严嘉","img":"http://img5.mtime.cn/mt/2019/01/15/164810.47339653_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":108,"movieId":247293,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":42,"nearestShowDay":1550131200,"nearestShowtimeCount":74},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":6,"titleCn":"神探蒲松龄","titleEn":"The Knight of Shadows: Between Yin and Yang","type":"动作 / 奇幻 / 喜剧","wantedCount":957},{"actorName1":"朱亚文","actorName2":"刘芸","btnText":"","commonSpecial":"小猪佩奇过中国年","directorName":"张大鹏","img":"http://img5.mtime.cn/mt/2019/01/14/141351.59784100_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":81,"movieId":259886,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":38,"nearestShowDay":1550131200,"nearestShowtimeCount":54},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":5.3,"titleCn":"小猪佩奇过大年","titleEn":"Peppa Pig","type":"动画 / 家庭 / 喜剧","wantedCount":452},{"actorName1":"刘青云","actorName2":"张家辉","btnText":"","commonSpecial":"刘青云林嘉欣领衔反腐抓\"大老虎\"","directorName":"麦兆辉","img":"http://img5.mtime.cn/mt/2019/01/10/153736.10615279_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":114,"movieId":255704,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":22,"nearestShowDay":1550131200,"nearestShowtimeCount":34},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":6,"titleCn":"廉政风云","titleEn":"Integrity","type":"犯罪 / 悬疑","wantedCount":987},{"actorName1":"刘昊然","actorName2":"杰伊·巴鲁切尔","btnText":"","commonSpecial":"","directorName":"迪恩·德布洛斯","img":"http://img5.mtime.cn/mt/2019/01/25/105549.53627008_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":104,"movieId":190574,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":4,"nearestShowDay":1550908800,"nearestShowtimeCount":4},"preferentialFlag":false,"rDay":1,"rMonth":3,"rYear":2019,"ratingFinal":-1,"titleCn":"驯龙高手3","titleEn":"How to Train Your Dragon: The Hidden World","type":"动画 / 动作 / 冒险","wantedCount":1632},{"actorName1":"张喆","actorName2":"杨天翔","btnText":"","commonSpecial":"一场跨越千年的人妖虐恋","directorName":"黄家康","img":"http://img5.mtime.cn/mt/2019/01/02/091653.71482132_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":95,"movieId":260666,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":13,"nearestShowDay":1550131200,"nearestShowtimeCount":29},"preferentialFlag":false,"rDay":11,"rMonth":1,"rYear":2019,"ratingFinal":7.7,"titleCn":"白蛇：缘起","titleEn":"White Snake","type":"动画 / 爱情 / 奇幻","wantedCount":620}]
     * totalCinemaCount : 217
     * totalComingMovie : 30
     * totalHotMovie : 43
     */

    private int count;
    private int totalCinemaCount;
    private int totalComingMovie;
    private int totalHotMovie;
    private List<MoviesBean> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCinemaCount() {
        return totalCinemaCount;
    }

    public void setTotalCinemaCount(int totalCinemaCount) {
        this.totalCinemaCount = totalCinemaCount;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public int getTotalHotMovie() {
        return totalHotMovie;
    }

    public void setTotalHotMovie(int totalHotMovie) {
        this.totalHotMovie = totalHotMovie;
    }

    public List<MoviesBean> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesBean> movies) {
        this.movies = movies;
    }

    public static class MoviesBean {
        /**
         * actorName1 : 吴京
         * actorName2 : 屈楚萧
         * btnText :
         * commonSpecial : 吴京领衔国产硬科幻电影
         * directorName : 郭帆
         * img : http://img5.mtime.cn/mt/2019/01/30/152305.14999287_1280X720X2.jpg
         * is3D : true
         * isDMAX : true
         * isFilter : false
         * isHot : true
         * isIMAX : false
         * isIMAX3D : true
         * isNew : false
         * length : 125
         * movieId : 218707
         * nearestShowtime : {"isTicket":true,"nearestCinemaCount":108,"nearestShowDay":1550131200,"nearestShowtimeCount":1945}
         * preferentialFlag : false
         * rDay : 5
         * rMonth : 2
         * rYear : 2019
         * ratingFinal : 8
         * titleCn : 流浪地球
         * titleEn : The Wandering Earth
         * type : 冒险 / 科幻 / 剧情
         * wantedCount : 3104
         */

        private String actorName1;
        private String actorName2;
        private String btnText;
        private String commonSpecial;
        private String directorName;
        private String img;
        private boolean is3D;
        private boolean isDMAX;
        private boolean isFilter;
        private boolean isHot;
        private boolean isIMAX;
        private boolean isIMAX3D;
        private boolean isNew;
        private int length;
        private int movieId;
        private NearestShowtimeBean nearestShowtime;
        private boolean preferentialFlag;
        private int rDay;
        private int rMonth;
        private int rYear;
        private int ratingFinal;
        private String titleCn;
        private String titleEn;
        private String type;
        private int wantedCount;

        public String getActorName1() {
            return actorName1;
        }

        public void setActorName1(String actorName1) {
            this.actorName1 = actorName1;
        }

        public String getActorName2() {
            return actorName2;
        }

        public void setActorName2(String actorName2) {
            this.actorName2 = actorName2;
        }

        public String getBtnText() {
            return btnText;
        }

        public void setBtnText(String btnText) {
            this.btnText = btnText;
        }

        public String getCommonSpecial() {
            return commonSpecial;
        }

        public void setCommonSpecial(String commonSpecial) {
            this.commonSpecial = commonSpecial;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public boolean isIs3D() {
            return is3D;
        }

        public void setIs3D(boolean is3D) {
            this.is3D = is3D;
        }

        public boolean isIsDMAX() {
            return isDMAX;
        }

        public void setIsDMAX(boolean isDMAX) {
            this.isDMAX = isDMAX;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsHot() {
            return isHot;
        }

        public void setIsHot(boolean isHot) {
            this.isHot = isHot;
        }

        public boolean isIsIMAX() {
            return isIMAX;
        }

        public void setIsIMAX(boolean isIMAX) {
            this.isIMAX = isIMAX;
        }

        public boolean isIsIMAX3D() {
            return isIMAX3D;
        }

        public void setIsIMAX3D(boolean isIMAX3D) {
            this.isIMAX3D = isIMAX3D;
        }

        public boolean isIsNew() {
            return isNew;
        }

        public void setIsNew(boolean isNew) {
            this.isNew = isNew;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public NearestShowtimeBean getNearestShowtime() {
            return nearestShowtime;
        }

        public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
            this.nearestShowtime = nearestShowtime;
        }

        public boolean isPreferentialFlag() {
            return preferentialFlag;
        }

        public void setPreferentialFlag(boolean preferentialFlag) {
            this.preferentialFlag = preferentialFlag;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public int getRatingFinal() {
            return ratingFinal;
        }

        public void setRatingFinal(int ratingFinal) {
            this.ratingFinal = ratingFinal;
        }

        public String getTitleCn() {
            return titleCn;
        }

        public void setTitleCn(String titleCn) {
            this.titleCn = titleCn;
        }

        public String getTitleEn() {
            return titleEn;
        }

        public void setTitleEn(String titleEn) {
            this.titleEn = titleEn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public static class NearestShowtimeBean {
            /**
             * isTicket : true
             * nearestCinemaCount : 108
             * nearestShowDay : 1550131200
             * nearestShowtimeCount : 1945
             */

            private boolean isTicket;
            private int nearestCinemaCount;
            private int nearestShowDay;
            private int nearestShowtimeCount;

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public int getNearestCinemaCount() {
                return nearestCinemaCount;
            }

            public void setNearestCinemaCount(int nearestCinemaCount) {
                this.nearestCinemaCount = nearestCinemaCount;
            }

            public int getNearestShowDay() {
                return nearestShowDay;
            }

            public void setNearestShowDay(int nearestShowDay) {
                this.nearestShowDay = nearestShowDay;
            }

            public int getNearestShowtimeCount() {
                return nearestShowtimeCount;
            }

            public void setNearestShowtimeCount(int nearestShowtimeCount) {
                this.nearestShowtimeCount = nearestShowtimeCount;
            }
        }
    }
}
