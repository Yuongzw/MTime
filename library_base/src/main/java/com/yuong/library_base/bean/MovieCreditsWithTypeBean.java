package com.yuong.library_base.bean;

import java.util.List;

public class MovieCreditsWithTypeBean {

    private List<TypesBean> types;

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {
        /**
         * typeName : 导演
         * typeNameEn : Director
         * persons : [{"id":892951,"name":"唐季礼","nameEn":"Stanley Tong","image":"http://img31.mtime.cn/ph/2014/02/22/192821.88623670_1280X720X2.jpg"}]
         */

        private String typeName;
        private String typeNameEn;
        private List<PersonsBean> persons;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeNameEn() {
            return typeNameEn;
        }

        public void setTypeNameEn(String typeNameEn) {
            this.typeNameEn = typeNameEn;
        }

        public List<PersonsBean> getPersons() {
            return persons;
        }

        public void setPersons(List<PersonsBean> persons) {
            this.persons = persons;
        }

        public static class PersonsBean {
            /**
             * id : 892951
             * name : 唐季礼
             * nameEn : Stanley Tong
             * image : http://img31.mtime.cn/ph/2014/02/22/192821.88623670_1280X720X2.jpg
             */

            private int id;
            private String name;
            private String nameEn;
            private String image;
            private String personate;
            private String personateCn;
            private String personateEn;

            public String getPersonate() {
                return personate;
            }

            public void setPersonate(String personate) {
                this.personate = personate;
            }

            public String getPersonateCn() {
                return personateCn;
            }

            public void setPersonateCn(String personateCn) {
                this.personateCn = personateCn;
            }

            public String getPersonateEn() {
                return personateEn;
            }

            public void setPersonateEn(String personateEn) {
                this.personateEn = personateEn;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameEn() {
                return nameEn;
            }

            public void setNameEn(String nameEn) {
                this.nameEn = nameEn;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
