package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test // 메시지 code와 동일한지 테스트
    void helloMessage() {
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test // 메시지 코드를 찾을 수 없을때 NoSuchMessageException 예외발생
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code",null,null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test // defaultMessage 설정 후 찾을수 없을때는 defaultMessage가 된다.
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("no_code", null, "기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지");
    }

    @Test // 인자값으로 넘겨줄때 Object 형태로 넘겨준다.
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(message).isEqualTo("안녕 Spring");
    }

    @Test // Locale 정보를 넘겨서 해당 Locale에 맞는 값을 가져온다. (default는 messages)
    void defaultLang() {
        assertThat(ms.getMessage("hello",null,null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello",null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test // Locale English에 맞는 값을 가져온다.
    void enLang() {
        assertThat(ms.getMessage("hello",null, Locale.ENGLISH)).isEqualTo("hello");
    }

}
