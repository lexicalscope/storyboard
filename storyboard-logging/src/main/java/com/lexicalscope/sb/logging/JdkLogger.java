package com.lexicalscope.sb.logging;

import java.util.logging.Level;

public class JdkLogger implements SbLogger {
   private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("com.lexicalscope.sb");
   @Override public void debug(final String message, final Object... args) {
      log(Level.FINE, message, args);
   }

   @Override public void warn(final String message, final Object... args) {
      log(Level.WARNING, message, args);
   }

   @Override public void info(final String message, final Object... args) {
      log(Level.INFO, message, args);
   }

   private void log(final Level level, final String message, final Object... args) {
      logger.log(level, String.format(message, args));
   }
}
