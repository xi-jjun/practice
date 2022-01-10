package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/springmvc/v2/members") // 이렇게 하면 밑에 method 단위의 매핑은 모두 상대경로로 하면 된다
public class SpringMemberControllerV2 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v2/members/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}

	@RequestMapping("/springmvc/v2/members/save") // 얘는 상대경로로 하면 "/save" 만 쓰면 된다.
	public ModelAndView save(HttpServletRequest request) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = memberRepository.save(new Member(username, age));

		ModelAndView mv = new ModelAndView("save-result");
		mv.addObject("member", member);

		return mv;
	}

	@RequestMapping("/springmvc/v2/members") // 얘는 안쓰면 된다. @RequestMapping
	public ModelAndView members() {
		List<Member> members = memberRepository.findAll();

		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", members);

		return mv;
	}
}
