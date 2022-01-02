package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성이 고려되지 않은 repo.
 * ConcurrentHashMap, AtomicLong 사용 고려해야 한다.
 */
public class MemberRepository {
	private static long sequence = 0L;
	private static final MemberRepository instance = new MemberRepository();
	private Map<Long, Member> store = new HashMap<>();

	public static MemberRepository getInstance() {
		return instance;
	}

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
	}
}
