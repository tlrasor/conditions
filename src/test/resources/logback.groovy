//
// Built on Wed Dec 17 06:14:13 CET 2014 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.DEBUG

appender("stdout", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d %5p (%F:%L) - %m%n"
    }
}
appender("rf", RollingFileAppender) {
    file = "conditions.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%p %d %5p (%F:%L) - %m%n"
    }
    rollingPolicy(FixedWindowRollingPolicy) {
        maxIndex = 1
        fileNamePattern = "out.%i.log"
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "25MB"
    }
}
root(DEBUG, ["stdout", "rf"])