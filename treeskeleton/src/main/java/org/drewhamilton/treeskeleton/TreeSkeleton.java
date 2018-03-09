package org.drewhamilton.treeskeleton;

import android.util.Log;

import timber.log.Timber;

public abstract class TreeSkeleton extends Timber.DebugTree {

    /**
     * The default minimum log level is Log.VERBOSE.
     */
    public static final int MINIMUM_LOG_LEVEL_DEFAULT = Log.VERBOSE;

    private LoggingService loggingService;

    private int minimumLogLevel;

    //region Constructors
    /**
     * Sets the minimum log level to the default: {@link #MINIMUM_LOG_LEVEL_DEFAULT}.
     */
    public TreeSkeleton(LoggingService loggingService) {
        this(loggingService, MINIMUM_LOG_LEVEL_DEFAULT);
    }

    /**
     * @param minimumLogLevel Log calls with priority less than this level will be ignored.
     */
    public TreeSkeleton(LoggingService loggingService, int minimumLogLevel) {
        this.loggingService = loggingService;
        this.minimumLogLevel = minimumLogLevel;
    }
    //endregion

    //region Overridden
    @Override
    protected void log(int priority, String tag, String message, Throwable throwable) {
        loggingService.log(priority, tag, message, throwable);
    }

    @Override
    protected boolean isLoggable(String tag, int priority) {
        return priority >= minimumLogLevel;
    }
    //endregion
}
