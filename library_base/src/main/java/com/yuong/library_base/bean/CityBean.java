package com.yuong.library_base.bean;

import java.util.List;

public class CityBean {

    private List<PBean> p;

    public List<PBean> getP() {
        return p;
    }

    public void setP(List<PBean> p) {
        this.p = p;
    }

    public static class PBean {
        /**
         * count : 320
         * id : 292
         * n : 上海
         * pinyinFull : Shanghai
         * pinyinShort : sh
         */

        private int count;
        private int id;
        private String n;
        private String pinyinFull;
        private String pinyinShort;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public String getPinyinFull() {
            return pinyinFull;
        }

        public void setPinyinFull(String pinyinFull) {
            this.pinyinFull = pinyinFull;
        }

        public String getPinyinShort() {
            return pinyinShort;
        }

        public void setPinyinShort(String pinyinShort) {
            this.pinyinShort = pinyinShort;
        }
    }
}
