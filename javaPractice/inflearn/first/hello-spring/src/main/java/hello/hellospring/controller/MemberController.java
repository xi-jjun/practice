package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // spring이 생성될 때 이 anotation 보고 해당 객체 생성한다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // spring container에서 memberService 가져온다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; // 얘를 template에서 찾는다. view resolver가 해당 html선택. thymeleaf template engine이 얘를 rendering
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // 회원가입

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();// 회원 조회
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
