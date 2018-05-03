import java.io.Serializable;

public class Food implements Serializable{
    private int id;
    
    private String name;

    private String desc;
    
    private String imgPath;
    
    public Food(int id, String name, String desc, String imgPath) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imgPath = imgPath;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}