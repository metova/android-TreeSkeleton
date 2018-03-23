package org.drewhamilton.treeskeleton.test

data class LogRecord(val priority: Int, val tag: String, val message: String, val throwable: Throwable)
