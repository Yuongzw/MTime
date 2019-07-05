package com.yuong.library_base.bean;

import java.util.List;

public class VideoBean {

    /**
     * totalPageCount : 1
     * totalCount : 10
     * videoList : [{"id":73879,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/02/26/mp4/190226114427554623.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/02/26/mp4/190226114427554623.mp4","image":"http://img5.mtime.cn/mg/2019/02/26/120707.84319761_235X132X4.jpg","title":"小飞象 中国定档预告","type":0,"length":141},{"id":72651,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2018/11/15/mp4/181115105347107503.mp4","hightUrl":"https://vfx.mtime.cn/Video/2018/11/15/mp4/181115105347107503.mp4","image":"http://img5.mtime.cn/mg/2018/11/15/101521.24149254_235X132X4.jpg","title":"小飞象 中文剧场版预告","type":0,"length":144},{"id":70878,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2018/06/13/mp4/180613153340831472.mp4","hightUrl":"https://vfx.mtime.cn/Video/2018/06/13/mp4/180613153340831472.mp4","image":"http://img5.mtime.cn/mg/2018/06/13/153406.72907158_235X132X4.jpg","title":"小飞象 中文先导预告","type":0,"length":82},{"id":73046,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2018/12/19/mp4/181219090909006409.mp4","hightUrl":"https://vfx.mtime.cn/Video/2018/12/19/mp4/181219090909006409.mp4","image":"http://img5.mtime.cn/mg/2018/12/19/090900.20689322_235X132X4.jpg","title":"小飞象 日本版预告片","type":0,"length":122},{"id":73703,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/02/06/mp4/190206202527440661.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/02/06/mp4/190206202527440661.mp4","image":"http://img5.mtime.cn/mg/2019/02/06/204135.19787482_235X132X4.jpg","title":"小飞象 中文预告2","type":0,"length":107},{"id":73938,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/03/04/mp4/190304141420885518.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/03/04/mp4/190304141420885518.mp4","image":"http://img5.mtime.cn/mg/2019/03/04/141402.69164396_235X132X4.jpg","title":"小飞象 中字电视预告之baby mine","type":0,"length":46},{"id":73928,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/03/03/mp4/190303114933093479.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/03/03/mp4/190303114933093479.mp4","image":"http://img5.mtime.cn/mg/2019/03/03/114851.54759086_235X132X4.jpg","title":"小飞象 制作特辑之\"飞向新高度\"","type":2,"length":108},{"id":74039,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/03/13/mp4/190313140237298864.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/03/13/mp4/190313140237298864.mp4","image":"http://img5.mtime.cn/mg/2019/03/13/140637.70821025_235X132X4.jpg","title":"洛杉矶首映","type":4,"length":261},{"id":73969,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/03/06/mp4/190306223339428517.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/03/06/mp4/190306223339428517.mp4","image":"http://img5.mtime.cn/mg/2019/03/06/223335.63395735_235X132X4.jpg","title":"小飞象 日文片尾曲MV","type":5,"length":60},{"id":74096,"sourceType":1,"url":"https://vfx.mtime.cn/Video/2019/03/20/mp4/190320084307536634.mp4","hightUrl":"https://vfx.mtime.cn/Video/2019/03/20/mp4/190320084307536634.mp4","image":"http://img5.mtime.cn/mg/2019/03/20/083841.82006343_235X132X4.jpg","title":"郑云龙 中国首映礼 《亲爱的》","type":5,"length":54}]
     */

    private int totalPageCount;
    private int totalCount;
    private List<VideoListBean> videoList;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public static class VideoListBean {
        /**
         * id : 73879
         * sourceType : 1
         * url : https://vfx.mtime.cn/Video/2019/02/26/mp4/190226114427554623.mp4
         * hightUrl : https://vfx.mtime.cn/Video/2019/02/26/mp4/190226114427554623.mp4
         * image : http://img5.mtime.cn/mg/2019/02/26/120707.84319761_235X132X4.jpg
         * title : 小飞象 中国定档预告
         * type : 0
         * length : 141
         */

        private int id;
        private int sourceType;
        private String url;
        private String hightUrl;
        private String image;
        private String title;
        private int type;
        private int length;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSourceType() {
            return sourceType;
        }

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
