package hello.hellospring.controller;

public class MemberForm {
    private Long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
