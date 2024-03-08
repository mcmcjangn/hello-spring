package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional//@Service
public class MemberService {
    private final MemberRepository memberRepository;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /*전체 회원 조회*/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //findByName 자체 반환값이 Optional이기 때문에 <optional> result = 안하고 바로 ifPresent()로 넘어갈 수 있음.
                .ifPresent(m -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
