package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    public void begin_end() throws Exception {
        final HelloTraceV1 trace = new HelloTraceV1();
        final TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    public void begin_exception() throws Exception {
        final HelloTraceV1 trace = new HelloTraceV1();
        final TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}
