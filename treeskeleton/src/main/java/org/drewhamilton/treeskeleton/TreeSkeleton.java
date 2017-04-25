package org.drewhamilton.treeskeleton;

import android.support.annotation.Nullable;
import android.util.Log;

import timber.log.Timber;

public abstract class TreeSkeleton extends Timber.DebugTree {

    /**
     * The default minimum log level is Log.VERBOSE.
     */
    public static final int MINIMUM_LOG_LEVEL_DEFAULT = Log.VERBOSE;

    private int mMinimumLogLevel;

    //region Constructors
    /**
     * Sets the minimum log level to the default: {@link #MINIMUM_LOG_LEVEL_DEFAULT}.
     */
    public TreeSkeleton() {
        this(MINIMUM_LOG_LEVEL_DEFAULT);
    }

    /**
     * @param minimumLogLevel Log calls with priority less than this level will be ignored.
     */
    public TreeSkeleton(int minimumLogLevel) {
        mMinimumLogLevel = minimumLogLevel;
    }
    //endregion

    //region Overridden
    @Override
    protected void log(int priority, String tag, String message, @Nullable Throwable throwable) {
        if (shouldUseDefaultLogMethod()) {
            super.log(priority, tag, message, throwable);
        }

        logToService(priority, tag, message, throwable);
    }

    @Override
    protected boolean isLoggable(String tag, int priority) {
        return priority >= mMinimumLogLevel;
    }
    //endregion

    protected void logToService(int priority, String tag, String message, @Nullable Throwable throwable) {
        // Override this to log to any custom service
    }

    //region Abstract

    /**
     * @return Whether this Tree should use the default logging method provided by Timber in addition to calling logToService()
     */
    protected abstract boolean shouldUseDefaultLogMethod();
    //endregion
}
