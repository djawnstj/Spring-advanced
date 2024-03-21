package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    public void begin_end() throws Exception {
        final HelloTraceV2 trace = new HelloTraceV2();
        final TraceStatus status1 = trace.begin("hello1");
        final TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    public void begin_exception() throws Exception {
        final HelloTraceV2 trace = new HelloTraceV2();
        final TraceStatus status1 = trace.begin("hello");
        final TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

}
