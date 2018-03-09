package org.drewhamilton.treeskeleton;


public interface LoggingService {

    void log(int priority, String tag, String message, Throwable throwable);
}
