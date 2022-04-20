package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null이면 로그인 실패
     */
    public Member login(String loginId, String password) {
        /** 로그인 확인하는 코드 */
//        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
//        Member member = findMemberOptional.get(); // Optional에서 get하면 안에 있는게 꺼내져 나온다.
//        if (member.getPassword().equals(password)) {
//            return member;
//        } else {
//            return null;
//        }

        /** 람다식으로 간단하게 */
//        Optional<Member> byLoginId = memberRepository.findByLoginId(loginId);
//        byLoginId.filter(m -> m.getPassword().equals(password))
//                .orElse(null);

        /** 위의 코드 인라인으로 합치기 */
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
