package com.yuong.library_base.bean;

public class AwardTitleBean {
    private int festivalId;
    private String img;
    private String nameCn;
    private String nameEn;
    private int nominateCount;
    private int winCount;

    public int getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getNominateCount() {
        return nominateCount;
    }

    public void setNominateCount(int nominateCount) {
        this.nominateCount = nominateCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
}
