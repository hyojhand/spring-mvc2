package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id; // DB에 저장해서 관리할 id

    @NotEmpty
    private String loginId; // 로그인 ID
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;

}
