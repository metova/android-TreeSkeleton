package org.drewhamilton.treeskeleton.test

import org.drewhamilton.treeskeleton.TreeSkeleton

class TestTreeSkeleton: TreeSkeleton() {

    public var shouldAlsoUseDefaultLogMethod: Boolean = false

    private val logTracker = mutableListOf<LogRecord>()
    public val logs: List<LogRecord> = logTracker

    override fun logToService(priority: Int, tag: String, message: String, throwable: Throwable) {
        logTracker.add(LogRecord(priority, tag, message, throwable))
    }

    override fun shouldAlsoUseDefaultLogMethod(): Boolean {
        return shouldAlsoUseDefaultLogMethod
    }
}
