package hello.servlet.web.springmvc.v3;

import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // ModelAndView 로 반환해도 되고, 문자열로 반환해도 인식한다.
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

//	@RequestMapping(value = "/new-form", method = RequestMethod.GET) // GET, POST.. 뭐든지 들어와도 받아드린다. → 안좋다
	@GetMapping("/new-form") // 더 짧아졌다
	public String newForm() {
		return "new-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@RequestParam("username") String username, // @RequestParam 으로 직접 받는다.
			@RequestParam("age") int age,
			Model model) {

		Member member = memberRepository.save(new Member(username, age));

		model.addAttribute("member", member);

		return "save-result";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String members(Model model) {
		List<Member> members = memberRepository.findAll();

		model.addAttribute("members", members);

		return "members";
	}
}
