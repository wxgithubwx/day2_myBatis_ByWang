package wx.pojo;

public class Clazz {
    int id;
    int cno;

    public Clazz() {
    }

    public Clazz(int id, int cno) {
        this.id = id;
        this.cno = cno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", cno=" + cno +
                '}';
    }
}
