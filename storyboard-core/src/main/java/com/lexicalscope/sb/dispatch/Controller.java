package com.lexicalscope.sb.dispatch;

import java.util.Map;
import java.util.TreeMap;

import com.lexicalscope.sb.http.WebApp;
import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.WebResponse;

public class Controller implements WebApp {
   private final Map<String, Handler> handlers = new TreeMap<>();

   @Override public void handle(final WebRequest request, final WebResponse response)
   {
      final String method = request.method();
      final String resource = request.path();

      if(!handlers.containsKey(resource)) {
         response.status(404, "Not Found");
         return;
      }

      switch (method) {
         case "GET":
               handlers.get(resource).get(request, response);
            break;

         default:
            response.status(405, "Method Not Allowed");
            return;
      }
   }

   public void register(final String path, final Handler handler) {
      handlers.put(path, handler);
   }
}
