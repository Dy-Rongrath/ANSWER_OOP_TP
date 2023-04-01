public class Course {
    private String name;
    private String code;
    private int credit;

    public Course(String name, String code, int credit) {
        this.name = name;
        this.code = code;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }
}
