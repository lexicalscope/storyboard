package com.lexicalscope.sb.logging;

public interface SbLogger {
   void warn(String message, Object... args);
   void info(String message, Object... args);
   void debug(String message, Object... args);
}
