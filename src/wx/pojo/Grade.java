package wx.pojo;

public class Grade {
    int id;
    int grade;
    String name;
    Clazz clazz;
    public Grade() {
    }

    public Grade(int id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
