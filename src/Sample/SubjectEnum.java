package Sample;

public enum SubjectEnum {
    DE("de"),
    EN("en");

    private String title;

    SubjectEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
