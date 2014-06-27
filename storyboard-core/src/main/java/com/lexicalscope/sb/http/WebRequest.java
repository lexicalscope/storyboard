package com.lexicalscope.sb.http;

import java.util.Iterator;

public interface WebRequest {
   String method();
   String path();

   String header(String name);
   Iterator<String> headers(String name);
   Iterator<String> headerNames();
   boolean hasHeader(String name);
   String getCookie(String string);

   String contentType();
   String content();
}
