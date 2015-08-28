package org.drewhamilton.treeskeleton.implementation;

import com.crashlytics.android.Crashlytics;

import org.drewhamilton.treeskeleton.TreeSkeleton;

import android.util.Log;

public class CrashlyticsTree extends TreeSkeleton {

    /**
     * Default minimum log level is Log.INFO.
     */
    public static final int MINIMUM_LOG_LEVEL_DEFAULT = Log.INFO;

    //region Constructors
    /**
     * Sets the minimum log level to the default: {@link #MINIMUM_LOG_LEVEL_DEFAULT}.
     */
    public CrashlyticsTree() {
        this(MINIMUM_LOG_LEVEL_DEFAULT);
    }

    /**
     * @param minimumLogLevel Log calls with priority less than this level will be ignored.
     */
    public CrashlyticsTree(int minimumLogLevel) {
        super(minimumLogLevel);
    }
    //endregion

    //region Overridden
    @Override
    protected void log(int priority, String tag, String message) {
        Crashlytics.log(priority, tag, message);
    }

    @Override
    protected void logException(Throwable throwable) {
        Crashlytics.logException(throwable);
    }

    @Override
    protected void logWarning(Throwable throwable) {
        logException(throwable);
    }

    @Override
    protected void logGenericThrowable(Throwable throwable) {
        logWarning(throwable);
    }
    //endregion
}
