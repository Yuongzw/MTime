package com.yuong.library_base.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class ComingBean {

    private List<AttentionBean> attention;
    private List<MoviecomingsBean> moviecomings;

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public List<MoviecomingsBean> getMoviecomings() {
        return moviecomings;
    }

    public void setMoviecomings(List<MoviecomingsBean> moviecomings) {
        this.moviecomings = moviecomings;
    }

    public static class AttentionBean {
        /**
         * actor1 : 罗莎·萨拉扎尔
         * actor2 : 克里斯托弗·瓦尔兹
         * director : 罗伯特·罗德里格兹
         * id : 25412
         * image : http://img5.mtime.cn/mt/2019/01/09/171109.88229500_1280X720X2.jpg
         * isFilter : false
         * isTicket : true
         * isVideo : true
         * locationName : 美国
         * rDay : 22
         * rMonth : 2
         * rYear : 2019
         * releaseDate : 2月22日上映
         * title : 阿丽塔：战斗天使
         * type : 科幻 / 动作 / 冒险
         * videoCount : 3
         * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2018/11/13/223007.56444081.jpg","length":160,"title":"阿丽塔：战斗天使 中文预告片2","url":"http://vfx.mtime.cn/Video/2018/11/13/mp4/181113225325404977.mp4","videoId":72630},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2018/07/24/000033.14427082.jpg","length":148,"title":"阿丽塔：战斗天使 中文预告片","url":"http://vfx.mtime.cn/Video/2018/07/24/mp4/180724000059236071.mp4","videoId":71339},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/12/11/151752.13871098.jpg","length":107,"title":"阿丽塔：战斗天使 中文先行版预告片","url":"http://vfx.mtime.cn/Video/2017/12/11/mp4/171211151602013413.mp4","videoId":68803}]
         * wantedCount : 4956
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<VideosBean> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean {
            /**
             * hightUrl :
             * image : http://img5.mtime.cn/mg/2018/11/13/223007.56444081.jpg
             * length : 160
             * title : 阿丽塔：战斗天使 中文预告片2
             * url : http://vfx.mtime.cn/Video/2018/11/13/mp4/181113225325404977.mp4
             * videoId : 72630
             */

            private String hightUrl;
            private String image;
            private int length;
            private String title;
            private String url;
            private int videoId;

            public String getHightUrl() {
                return hightUrl;
            }

            public void setHightUrl(String hightUrl) {
                this.hightUrl = hightUrl;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }
    }

    public static class MoviecomingsBean {
        /**
         * actor1 :
         * actor2 :
         * director : 邓海
         * id : 262995
         * image : http://img5.mtime.cn/mt/2019/01/30/115424.33519295_1280X720X2.jpg
         * isFilter : false
         * isTicket : false
         * isVideo : false
         * locationName : 中国
         * rDay : 16
         * rMonth : 2
         * rYear : 2019
         * releaseDate : 2月16日上映
         * title : 参娃与天池怪兽之瑞雪兆丰年
         * type : 动画
         * videoCount : 0
         * videos : []
         * wantedCount : 9
         */

        private String actor1;
        private String actor2;
        private String director;
        private int id;
        private String image;
        private boolean isFilter;
        private boolean isTicket;
        private boolean isVideo;
        private String locationName;
        private int rDay;
        private int rMonth;
        private int rYear;
        private String releaseDate;
        private String title;
        private String type;
        private int videoCount;
        private int wantedCount;
        private List<?> videos;

        public String getActor1() {
            return actor1;
        }

        public void setActor1(String actor1) {
            this.actor1 = actor1;
        }

        public String getActor2() {
            return actor2;
        }

        public void setActor2(String actor2) {
            this.actor2 = actor2;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsTicket() {
            return isTicket;
        }

        public void setIsTicket(boolean isTicket) {
            this.isTicket = isTicket;
        }

        public boolean isIsVideo() {
            return isVideo;
        }

        public void setIsVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public List<?> getVideos() {
            return videos;
        }

        public void setVideos(List<?> videos) {
            this.videos = videos;
        }
    }
}
