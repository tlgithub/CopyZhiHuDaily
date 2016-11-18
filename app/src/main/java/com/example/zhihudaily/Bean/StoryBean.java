package com.example.zhihudaily.Bean;

import java.util.List;

/**
 * Created by 教科书式的机智少年 on 2016/11/7.
 */

public class StoryBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title">如何看待竹木类家具设计？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/7feed5904_is.jpg">
     <span class="author">张蕾，</span><span class="bio">作最有“用”的设计</span>
     </div>

     <div class="content">
     <p>竹子是一种成本低廉的可再生原材料，只需阳光和水分即可快速生长，一直广泛的运用在家具、灯具、工艺品、生活用品等等。这几年成为了世界的宠儿有很多竹建筑。</p>
     <p>1：台湾的 yii（易）的确将东方工艺变为西方家具上做了很多有趣的尝试。</p>
     <p>2：大家还可以关注菲律宾的设计师：Kenneth Cobonpue，</p>
     <p><img src="http://p4.zhimg.com/23/f8/23f8be64b088eca4df913d79d97a7179_m.jpg" alt="" /></p>
     <p>这张就是 Brad Pitt 为女儿的婴儿床，由 Kenneth Cobonpue 设计。</p>
     <p>3：GreenChamp Bike 是由 GreenChamp 团队设计的一款儿童平衡车，专为 5 岁以下的儿童设计，用来帮助孩子培养平衡能力。这款童车主打环保理念，车架和主要零部件用竹子做成，将环保概念发挥到最大。</p>
     <p><img src="http://p1.zhimg.com/1f/91/1f9145d32bec27fb554c092a56f35f4e_m.jpg" alt="" /></p>
     <p>4：竹林，是英国创意工作室 Poetic Lab2014 年最新系列作品<img style="line-height: 1.5;" src="http://p1.zhimg.com/4b/ea/4bea403a07010c485164170a56547dbe_m.jpg" alt="" /></p>
     <p>设计师最大限度的保留了竹子这种材料本身的美感。在作品的优雅造型和柔美姿态中，竹林那&ldquo;日光月影，浮动其间&rdquo;的韵味被再现。</p>
     <p>5：&ldquo;宁可食无肉,不可居无竹&rdquo;，竹在中国艺术领域是有着独特符号的，也代表一种气节。<img style="line-height: 1.5;" src="http://p2.zhimg.com/b6/8c/b68cd2c4ac57ce75ff7ba256d318201c_m.jpg" alt="" /><img style="line-height: 1.5;" src="http://p1.zhimg.com/22/03/22038290986cb5894b3882e031df09a0_m.jpg" alt="" /></p>
     <p><img src="http://p2.zhimg.com/a0/c3/a0c3d6b75e5fc2664b2350ddc4bf4da5_m.jpg" alt="" /></p>
     <p>除了家具产品，设计师还在建筑上把竹子的特性用到了极致。</p>
     <p>6：这个用竹子形成的大舞台由 11 个绿色竹蓬构成，两个环间形成一个空隙。平面构思由树的年轮而来，竹蓬不同的形式仿照了自然的生长图案。一棵树可以从简单的分支规则衍生出无数的形式，同样，这些棚状结构也采取了单一的几何构造，成抛物线的拱状，理论上这样可以产生出无穷的结构。<br /><img style="line-height: 1.5;" src="http://p2.zhimg.com/8e/01/8e0152ea9ac48572fab8f97a45af1c71_m.jpg" alt="" /></p>
     <p>7：在 2010 年上海世博会上，&ldquo;竹元素&rdquo;已经成了低碳建筑的&ldquo;明星&rdquo;。城市的建筑正陷入&ldquo;钢铁侠&rdquo;式的千篇一律之时，建筑师利用竹焕发出不一样的色彩和表情，成为了钢筋水泥的森林，玻璃幕墙的秀场，功能至上的设计<br /><img style="line-height: 1.5;" src="http://p3.zhimg.com/3e/d2/3ed2694658dcb4f314e3870c6a64edad_m.jpg" alt="" />话扯得有点远，也当做自己对热爱自然的设计师的一种致敬。</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/22298538">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : Andy / CC BY-ND
     * title : 商场和很多人家里，竹制家具越来越多（多图）
     * image : http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg
     * share_url : http://daily.zhihu.com/story/3930883
     * js : []
     * ga_prefix : 052315
     * images : ["http://p3.zhimg.com/f7/60/f76015d0bc2cdd5e553d037665eb07c5.jpg"]
     * type : 0
     * id : 3930883
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

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

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}

