package org.drewhamilton.treeskeleton.implementation;

import com.crashlytics.android.Crashlytics;

import org.drewhamilton.treeskeleton.LoggingService;

public class CrashlyticsLoggingService implements LoggingService {

    @Override
    public void log(int priority, String tag, String message, Throwable throwable) {
        Crashlytics.log(priority, tag, message);

        if (throwable != null) {
            Crashlytics.logException(throwable);
        }
    }
}
