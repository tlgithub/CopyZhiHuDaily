package com.example.zhihudaily.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 教科书式的机智少年 on 2016/11/10.
 */

public class OtherContentBean {

    /**
     * stories : [{"images":["http://pic2.zhimg.com/878b8960b617bfb4721a103e24a0509d.jpg"],"type":0,"id":7785695,"title":"Necromanov：分裂红海：辐射4的喧嚣和争议"},{"images":["http://pic1.zhimg.com/9e9a4e7c539784f5488093cb6b0eeb50_t.jpg"],"type":0,"id":7225331,"title":"MGS V幻痛：沙盘化的心血和代价"},{"images":["http://pic2.zhimg.com/761acb25a50564c8bafce6d1d4ec5b05_t.jpg"],"type":0,"id":7173926,"title":"幸存者偏差\u2014\u2014死在中国游戏圈的一百万种方式"},{"images":["http://pic3.zhimg.com/956663ab7cf64103a5a08d567db3f1c6_t.jpg"],"type":0,"id":7121745,"title":"前《永恒之塔》技术总监谈如何使用Unity实现次世代效果"},{"images":["http://pic1.zhimg.com/e7cd0ddfd60855f00d45f29d9d0782c0_t.jpg"],"type":0,"id":7114453,"title":"深度：第一份《LOVE LIVE!》全面分析报告"},{"type":0,"id":7112210,"title":"和男/女朋友一起玩 Minecraft 是怎样的体验？"},{"images":["http://pic3.zhimg.com/d13bd513bde7372d146f4ed6790aa6be_t.jpg"],"type":0,"id":7050232,"title":"为女儿推荐游戏是一种怎样的体验"},{"images":["http://pic4.zhimg.com/19593389111853d69c6ad0dc6e925667_t.jpg"],"type":0,"id":7038710,"title":"10年前的CJ，我们都在看些什么？"},{"images":["http://pic3.zhimg.com/9b9fa0556dffba9982dca5a5915c061e_t.jpg"],"type":0,"id":7015462,"title":"95后大学生都在玩什么游戏（图）？"},{"images":["http://pic3.zhimg.com/6f4719fca836a2816191c30d5d7675da_t.jpg"],"type":0,"id":7014522,"title":"身为一个土豪（大R）玩家是一种怎样的体验？"},{"images":["http://pic1.zhimg.com/4c5498268b53287aad36e13e180dbcb4_t.jpg"],"type":0,"id":7014069,"title":"\u201c仙六陨落\u201d：游戏如果没有游戏性，为何不去看动画？"},{"images":["http://pic4.zhimg.com/450b234d6afb0688d93138c04080b7d7_t.jpg"],"type":0,"id":7012937,"title":"把原创游戏设计变得有趣(之一)"},{"images":["http://pic1.zhimg.com/6d54559b14df2d601354c12e7e3d4f6c_t.jpg"],"type":0,"id":4893358,"title":"十三大发行商下半年产品IP储备大起底"},{"images":["http://pic1.zhimg.com/f5528e37f0b97e07c5bb36145ffd9ac0_t.jpg"],"type":0,"id":4864466,"title":"专访《大圣归来》出品人路伟：CP如何靠精品内容逆袭渠道？"},{"images":["http://pic4.zhimg.com/b7463eb15e4b8179add9fd3778f7305f_t.jpg"],"type":0,"id":4860434,"title":"【败局】如何将一家市值一百亿的游戏公司做垮"},{"type":0,"id":4856808,"title":"反恐精英游戏史：Counter-Strike History 1999-2015"},{"images":["http://pic4.zhimg.com/ed17bcfd735977314cf70be104f78d63_t.jpg"],"type":0,"id":4837591,"title":"从\u201c小朋友\u201d到\u201c大英雄\u201d：单打独斗二十年"},{"images":["http://pic3.zhimg.com/9382872f7b2e5d898ffa11eb915ed992_t.jpg"],"type":0,"id":4833369,"title":"家有开发者：那些不曾与你说过的话"},{"type":0,"id":4824545,"title":"我想做个好人，即便是在 GTA 中"}]
     * description : 如果你喜欢游戏，就从这里开始
     * background : http://p2.zhimg.com/55/e0/55e06f8fe322fd87b3261b204bae4786.jpg
     * color : 59647
     * name : 开始游戏
     * image : http://p3.zhimg.com/64/5c/645cde143c9a371005f3f749366cffad.jpg
     * editors : [{"url":"http://www.zhihu.com/people/necromanov","bio":"战略航空军旗舰的元帅","id":3,"avatar":"http://pic4.zhimg.com/3553d57db_m.jpg","name":"Necromanov"},{"url":"http://www.zhihu.com/people/FireWolf","bio":"原《电脑游戏攻略》编辑，现创业\u201c有趣点\u201d：youqudian.com","id":76,"avatar":"http://pic2.zhimg.com/71d001b31_m.jpg","name":"火狼"},{"url":"http://www.zhihu.com/people/commando","bio":"知名游戏人，触乐网创始人","id":2,"avatar":"http://pic2.zhimg.com/2cacc4d6d_m.jpg","name":"祝佳音"},{"url":"http://www.zhihu.com/people/meng-de-er","bio":"传统游戏遗老，SEGA 的守墓人","id":5,"avatar":"http://pic3.zhimg.com/8a0f51296_m.jpg","name":"孟德尔"}]
     * image_source :
     */

    private String description;
    private String background;
    private int color;
    private String name;
    private String image;
    private String image_source;
    /**
     * images : ["http://pic2.zhimg.com/878b8960b617bfb4721a103e24a0509d.jpg"]
     * type : 0
     * id : 7785695
     * title : Necromanov：分裂红海：辐射4的喧嚣和争议
     */

    private List<StoriesBean> stories;
    /**
     * url : http://www.zhihu.com/people/necromanov
     * bio : 战略航空军旗舰的元帅
     * id : 3
     * avatar : http://pic4.zhimg.com/3553d57db_m.jpg
     * name : Necromanov
     */

    private List<EditorsBean> editors;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<EditorsBean> getEditors() {
        return editors;
    }

    public void setEditors(List<EditorsBean> editors) {
        this.editors = editors;
    }

    public static class StoriesBean implements Serializable{
        private int type;
        private int id;
        private String title;
        private List<String> images = new ArrayList<String>();

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class EditorsBean implements Serializable{
        private String url;
        private String bio;
        private int id;
        private String avatar;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
