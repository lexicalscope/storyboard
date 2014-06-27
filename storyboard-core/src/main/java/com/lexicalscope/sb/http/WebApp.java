package com.lexicalscope.sb.http;

public interface WebApp {
   void handle(WebRequest request, WebResponse response);
}
