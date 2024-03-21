package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @DisplayName("being end level2")
    @Test
    public void begin_end_level2() throws Exception {
        final TraceStatus status1 = trace.begin("hello1");
        final TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }
    
    @DisplayName("begin exception level2")
    @Test
    public void begin_exception_level2() throws Exception {
        final TraceStatus status1 = trace.begin("hello1");
        final TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

}
