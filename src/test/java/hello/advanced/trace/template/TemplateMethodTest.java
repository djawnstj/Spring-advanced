package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        final long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직1 실행");
        // 비지니스 로직 종료
        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        final long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비지니스 로직2 실행");
        // 비지니스 로직 종료
        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @DisplayName("템플릿 메서드 패턴 적용 1")
    @Test
    public void templateMethodV1() throws Exception {
        final AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        final AbstractTemplate template2 = new SubClassLogic1();
        template2.execute();
    }

    @DisplayName("템플릿 메서드 패턴 적용 2")
    @Test
    public void templateMethodV2() throws Exception {
        final AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직 1 실행");
            }
        };
        log.info("클래스 이름 1={}", template1.getClass());
        template1.execute();

        final AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직 2 실행");
            }
        };
        log.info("클래스 이름 2 ={}", template2.getClass());
        template2.execute();
    }
}
