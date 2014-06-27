package com.lexicalscope.sb.today;

import com.lexicalscope.sb.logging.SbLogger;


public class ReadOutputLogger implements SbLogger {
   @Override public void debug(final String message, final Object... args) {
      log(args);
   }

   @Override public void warn(final String message, final Object... args) {
      log(args);
   }

   @Override public void info(final String message, final Object... args) {
      log(args);
   }

   private void log(final Object... args) {
      for (final Object object : args) {
         if (object != null) {
            object.toString();
         }
      }
   }
}
