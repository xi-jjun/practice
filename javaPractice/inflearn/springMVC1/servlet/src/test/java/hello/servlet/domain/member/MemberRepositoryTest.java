package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		// given
		Member member = new Member("kim", 26);

		// when
		Member savedMember = memberRepository.save(member);

		// then
		Member findMember = memberRepository.findById(savedMember.getId());
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	void findAll() {
		// given
		Member member1 = new Member("kim", 26);
		Member member2 = new Member("Lee", 25);

		Member saved1 = memberRepository.save(member1);
		Member saved2 = memberRepository.save(member2);

		// when
		List<Member> findMembers = memberRepository.findAll();

		// then
		assertThat(findMembers.size()).isEqualTo(2);
		assertThat(findMembers).contains(member1, member2);
	}
}
