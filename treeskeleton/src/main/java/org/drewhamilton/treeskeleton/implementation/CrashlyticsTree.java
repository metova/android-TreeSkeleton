package org.drewhamilton.treeskeleton.implementation;

import android.util.Log;

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
        super(new CrashlyticsLoggingService(), minimumLogLevel);
    }
    //endregion
}
