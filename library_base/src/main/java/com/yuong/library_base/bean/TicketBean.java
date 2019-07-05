package com.yuong.library_base.bean;

import java.util.List;

public class TicketBean {

    /**
     * count : 15
     * movies : [{"actorName1":"陈意涵","actorName2":"刘以豪","btnText":"","commonSpecial":"2018台湾票房冠军，强劲催泪弹","directorName":"林孝谦","img":"http://img5.mtime.cn/mt/2019/03/01/142658.85498591_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":105,"movieId":261561,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":16,"nearestShowDay":1553328000,"nearestShowtimeCount":228},"preferentialFlag":false,"rDay":14,"rMonth":3,"rYear":2019,"ratingFinal":6.3,"titleCn":"比悲伤更悲伤的故事","titleEn":"More than Blue","type":"爱情","wantedCount":374},{"actorName1":"索菲·范·德温","actorName2":"马克·弗罗斯特","btnText":"","commonSpecial":"凶狮伤人全城红色警戒","directorName":"迪克·麦斯","img":"http://img5.mtime.cn/mt/2019/02/19/095712.32430399_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":true,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":105,"movieId":262570,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":15,"nearestShowDay":1553328000,"nearestShowtimeCount":69},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":6.5,"titleCn":"狂暴凶狮","titleEn":"Prooi","type":"惊悚 / 喜剧 / 恐怖","wantedCount":118},{"actorName1":"于谦","actorName2":"汤孟佳","btnText":"","commonSpecial":"于谦变\u201c恶霸\u201d老师","directorName":"张栾","img":"http://img5.mtime.cn/mt/2019/02/21/095918.47882172_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":111,"movieId":261858,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":14,"nearestShowDay":1553328000,"nearestShowtimeCount":64},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":7.1,"titleCn":"老师·好","titleEn":"Song of Youth","type":"剧情","wantedCount":187},{"actorName1":"王景春","actorName2":"咏梅","btnText":"","commonSpecial":"两个家庭的三十年悲欢","directorName":"王小帅","img":"http://img5.mtime.cn/mt/2019/03/12/144121.86966182_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":175,"movieId":234975,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":15,"nearestShowDay":1553328000,"nearestShowtimeCount":60},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":8.1,"titleCn":"地久天长","titleEn":"So Long, My Son","type":"剧情","wantedCount":392},{"actorName1":"布丽·拉尔森","actorName2":"塞缪尔·杰克逊","btnText":"","commonSpecial":"漫威宇宙\u201c全村的希望\u201d","directorName":"安娜·波顿","img":"http://img5.mtime.cn/mt/2019/01/25/100901.82440600_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":124,"movieId":218087,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":15,"nearestShowDay":1553328000,"nearestShowtimeCount":67},"preferentialFlag":false,"rDay":8,"rMonth":3,"rYear":2019,"ratingFinal":7.1,"titleCn":"惊奇队长","titleEn":"Captain Marvel","type":"动作 / 冒险 / 科幻","wantedCount":5012},{"actorName1":"克里斯·帕拉特","actorName2":"伊丽莎白·班克斯","btnText":"","commonSpecial":"DC人气英雄开启吐槽模式","directorName":"迈克·米歇尔","img":"http://img5.mtime.cn/mt/2019/02/27/164533.80435476_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":106,"movieId":212573,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":17,"nearestShowDay":1553328000,"nearestShowtimeCount":61},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":7.1,"titleCn":"乐高大电影2","titleEn":"The Lego Movie 2: The Second Part","type":"动画 / 动作 / 冒险","wantedCount":479},{"actorName1":"拉米·马雷克","actorName2":"露西·宝通","btnText":"","commonSpecial":"还原皇后乐队恢宏现场","directorName":"布莱恩·辛格","img":"http://img5.mtime.cn/mt/2019/03/15/112524.40690457_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":131,"movieId":229843,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":6,"nearestShowDay":1553328000,"nearestShowtimeCount":42},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":8,"titleCn":"波西米亚狂想曲","titleEn":"Bohemian Rhapsody","type":"传记 / 剧情 / 音乐","wantedCount":1078},{"actorName1":"维果·莫腾森","actorName2":"马赫沙拉·阿里","btnText":"","commonSpecial":"跨越种族和阶级的感人故事","directorName":"彼得·法雷里","img":"http://img5.mtime.cn/mt/2019/02/27/171110.19655687_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":130,"movieId":258541,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":10,"nearestShowDay":1553328000,"nearestShowtimeCount":30},"preferentialFlag":false,"rDay":1,"rMonth":3,"rYear":2019,"ratingFinal":8.2,"titleCn":"绿皮书","titleEn":"Green Book","type":"剧情 / 喜剧 / 传记","wantedCount":1282},{"actorName1":"吴京","actorName2":"屈楚萧","btnText":"","commonSpecial":"吴京领衔国产硬科幻电影","directorName":"郭帆","img":"http://img5.mtime.cn/mt/2019/01/30/152305.14999287_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":125,"movieId":218707,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":5,"nearestShowDay":1553328000,"nearestShowtimeCount":16},"preferentialFlag":false,"rDay":5,"rMonth":2,"rYear":2019,"ratingFinal":7.9,"titleCn":"流浪地球","titleEn":"The Wandering Earth","type":"冒险 / 科幻 / 剧情","wantedCount":3605},{"actorName1":"阿德丽安娜·尤加特","actorName2":"奇诺·达林","btnText":"","commonSpecial":"15小时限时解谜惊心动魄","directorName":"奥利奥尔·保罗","img":"http://img5.mtime.cn/mt/2019/03/19/145149.38901626_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":128,"movieId":263202,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":1,"nearestShowDay":1553414400,"nearestShowtimeCount":1},"preferentialFlag":false,"rDay":28,"rMonth":3,"rYear":2019,"ratingFinal":7.4,"titleCn":"海市蜃楼","titleEn":"Durante la tormenta","type":"惊悚 / 剧情","wantedCount":167},{"actorName1":"刘昊然","actorName2":"杰伊·巴鲁切尔","btnText":"","commonSpecial":"小嗝嗝上演终极冒险","directorName":"迪恩·德布洛斯","img":"http://img5.mtime.cn/mt/2019/01/25/105549.53627008_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":104,"movieId":190574,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":7,"nearestShowDay":1553328000,"nearestShowtimeCount":13},"preferentialFlag":false,"rDay":1,"rMonth":3,"rYear":2019,"ratingFinal":7.5,"titleCn":"驯龙高手3","titleEn":"How to Train Your Dragon: The Hidden World","type":"动画 / 动作 / 冒险","wantedCount":2311},{"actorName1":"哈维尔·古铁雷斯","actorName2":"雅典娜·玛塔","btnText":"","commonSpecial":"失意教练遭遇菜鸟球员","directorName":"哈维尔·费舍尔","img":"http://img5.mtime.cn/mt/2019/03/12/095402.67092911_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":119,"movieId":247414,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":4,"nearestShowDay":1553328000,"nearestShowtimeCount":6},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":7,"titleCn":"篮球冠军","titleEn":"Campeones","type":"喜剧 / 剧情 / 运动","wantedCount":44},{"actorName1":"罗莎·萨拉扎尔","actorName2":"克里斯托弗·瓦尔兹","btnText":"","commonSpecial":"核能少女对决邪恶势力","directorName":"罗伯特·罗德里格兹","img":"http://img5.mtime.cn/mt/2019/01/09/171109.88229500_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":122,"movieId":25412,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":1,"nearestShowDay":1553328000,"nearestShowtimeCount":6},"preferentialFlag":false,"rDay":22,"rMonth":2,"rYear":2019,"ratingFinal":7.6,"titleCn":"阿丽塔：战斗天使","titleEn":"Alita: Battle Angel","type":"动作 / 冒险 / 爱情","wantedCount":5297},{"actorName1":"梅俪儿","actorName2":"李泽宇","btnText":"","commonSpecial":"","directorName":"陆诗雷","img":"http://img5.mtime.cn/mt/2019/02/02/160441.82330370_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":true,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":86,"movieId":263043,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":5,"nearestShowDay":1553328000,"nearestShowtimeCount":8},"preferentialFlag":false,"rDay":22,"rMonth":3,"rYear":2019,"ratingFinal":-1,"titleCn":"夜伴歌声","titleEn":"MIDNIGHT MELODY","type":"惊悚 / 恐怖","wantedCount":530},{"actorName1":"井柏然","actorName2":"宋佳","btnText":"","commonSpecial":"","directorName":"娄烨","img":"http://img5.mtime.cn/mt/2019/01/30/111206.25705073_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":126,"movieId":231968,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":4,"nearestShowDay":1554364800,"nearestShowtimeCount":8},"preferentialFlag":false,"rDay":4,"rMonth":4,"rYear":2019,"ratingFinal":-1,"titleCn":"风中有朵雨做的云","titleEn":"The Shadow Play","type":"剧情 / 悬疑 / 犯罪","wantedCount":605}]
     * totalCinemaCount : 30
     * totalComingMovie : 39
     * totalHotMovie : 24
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
         * actorName1 : 陈意涵
         * actorName2 : 刘以豪
         * btnText :
         * commonSpecial : 2018台湾票房冠军，强劲催泪弹
         * directorName : 林孝谦
         * img : http://img5.mtime.cn/mt/2019/03/01/142658.85498591_1280X720X2.jpg
         * is3D : false
         * isDMAX : false
         * isFilter : false
         * isHot : true
         * isIMAX : false
         * isIMAX3D : false
         * isNew : false
         * length : 105
         * movieId : 261561
         * nearestShowtime : {"isTicket":true,"nearestCinemaCount":16,"nearestShowDay":1553328000,"nearestShowtimeCount":228}
         * preferentialFlag : false
         * rDay : 14
         * rMonth : 3
         * rYear : 2019
         * ratingFinal : 6.3
         * titleCn : 比悲伤更悲伤的故事
         * titleEn : More than Blue
         * type : 爱情
         * wantedCount : 374
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
        private double ratingFinal;
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

        public double getRatingFinal() {
            return ratingFinal;
        }

        public void setRatingFinal(double ratingFinal) {
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
             * nearestCinemaCount : 16
             * nearestShowDay : 1553328000
             * nearestShowtimeCount : 228
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
