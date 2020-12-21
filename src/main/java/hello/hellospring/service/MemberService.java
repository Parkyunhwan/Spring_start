package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원은 안됨

        /*
            1. 두 가지 버전 옵션널 리턴을 받아서 사용하기
            2. 바로 리턴의 메서드를 사용하는 방법
        */// 값이 있다면 == ifPresent
        //Optional<Member> byName = memberRepository.findByName(member.getName());
        //byname.ifPrsent ~~
        validateDuplicateMember(member); // 중복회원 검증 ctrl + t 활용
        memberRepository.save(member);
        return member.getId();
    }

    /**
     *
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}