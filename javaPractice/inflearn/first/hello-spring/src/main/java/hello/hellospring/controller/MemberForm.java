package hello.hellospring.controller;

public class MemberForm {
    private String name; // createMemberForm.html의 name tag의 이름값과 같은 변수명

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
