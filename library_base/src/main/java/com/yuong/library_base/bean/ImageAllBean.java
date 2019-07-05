package com.yuong.library_base.bean;

import java.io.Serializable;
import java.util.List;

public class ImageAllBean implements Serializable {

    private List<ImageTypesBean> imageTypes;
    private List<ImagesBean> images;

    public List<ImageTypesBean> getImageTypes() {
        return imageTypes;
    }

    public void setImageTypes(List<ImageTypesBean> imageTypes) {
        this.imageTypes = imageTypes;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImageTypesBean implements Serializable {
        /**
         * type : -1
         * typeName : 显示所有
         */

        private int type;
        private String typeName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }

    public static class ImagesBean implements Serializable {
        /**
         * approveStatus : 1
         * id : 7317366
         * image : http://img5.mtime.cn/pi/2018/11/06/164240.32943222_1000X1000.jpg
         * imageSubtype : 101
         * imageSubtypeDes : 正式海报
         * type : 1
         */

        private int approveStatus;
        private int id;
        private String image;
        private int imageSubtype;
        private String imageSubtypeDes;
        private int type;

        public int getApproveStatus() {
            return approveStatus;
        }

        public void setApproveStatus(int approveStatus) {
            this.approveStatus = approveStatus;
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

        public int getImageSubtype() {
            return imageSubtype;
        }

        public void setImageSubtype(int imageSubtype) {
            this.imageSubtype = imageSubtype;
        }

        public String getImageSubtypeDes() {
            return imageSubtypeDes;
        }

        public void setImageSubtypeDes(String imageSubtypeDes) {
            this.imageSubtypeDes = imageSubtypeDes;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
