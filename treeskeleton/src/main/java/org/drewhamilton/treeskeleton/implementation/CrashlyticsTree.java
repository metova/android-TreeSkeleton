package org.drewhamilton.treeskeleton.implementation;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.drewhamilton.treeskeleton.TreeSkeleton;

public class CrashlyticsTree extends TreeSkeleton {

    /**
     * The default minimum log level is Log.INFO.
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
    protected void logToService(int priority, String tag, String message, Throwable throwable) {
        Crashlytics.log(priority, tag, message);

        if (throwable != null) {
            Crashlytics.logException(throwable);
        }
    }

    @Override
    protected boolean shouldAlsoUseDefaultLogMethod() {
        // Crashlytics handles logging itself
        return false;
    }
    //endregion
}
