package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    
    @DisplayName("템플릿 콜백 패턴 - 익명 내부 클래스")
    @Test
    public void callbackV1() throws Exception {
        final TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비지니스 로직 1 샐행"));
        template.execute(() -> log.info("비지니스 로직 2 샐행"));
    }

}
