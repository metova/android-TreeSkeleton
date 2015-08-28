package org.drewhamilton.treeskeleton;

import android.support.annotation.Nullable;
import android.util.Log;

import timber.log.Timber;

public abstract class TreeSkeleton extends Timber.Tree {

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
        if (isLoggable(tag, priority)) {
            log(priority, tag, message);

            if (throwable != null) {
                switch (priority) {
                    case Log.ERROR:
                        logException(throwable);
                        break;
                    case Log.WARN:
                        logWarning(throwable);
                        break;
                    default:
                        logGenericThrowable(throwable);
                        break;
                }
            }
        }
    }
    //endregion

    //region Abstract
    /**
     * Log a message to any service.
     *
     * @param priority The priority/type of this log message.
     * @param tag Used to identify the source of a log message. It usually identifies
     *        the class or activity where the log call occurs.
     * @param message The message to log.
     */
    protected abstract void log(int priority, String tag, String message);

    /**
     * Log a throwable with Log.ERROR priority to any service.
     * @param throwable The throwable to log.
     */
    protected abstract void logException(Throwable throwable);

    /**
     * Log a throwable with Log.WARN priority to any service.
     * @param throwable The throwable to log.
     */
    protected abstract void logWarning(Throwable throwable);

    /**
     * Log a throwable with a priority other than Log.WARN or Log.ERROR to any service.
     * @param throwable The throwable to log.
     */
    protected abstract void logGenericThrowable(Throwable throwable);
    //endregion

    /**
     * Determines whether a log for the specified tag is loggable at the specified priority. Uses {@link #mMinimumLogLevel}
     * and Log.isLoggable(String, int).
     *
     * @param tag The tag to check.
     * @param priority The priority to check.
     * @return True if this is allowed to be logged.
     */
    protected boolean isLoggable(String tag, int priority) {
        return priority >= mMinimumLogLevel && Log.isLoggable(tag, priority);
    }
}
