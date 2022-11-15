package test.du_phong;

public class HocSinh {
    private String id;
    private String name;
    private int hocKy;
    private String course;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public HocSinh(String id, String name, int hocKy, String course) {
        this.id = id;
        this.name = name;
        this.hocKy = hocKy;
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-15d%-15s", id, name, hocKy, course);
    }

}
