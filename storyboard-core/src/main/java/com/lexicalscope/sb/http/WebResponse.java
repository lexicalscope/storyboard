package com.lexicalscope.sb.http;


public interface WebResponse {
   void status(int status, String reason);
   void header(String name, String value);
   void content(int status, Template template);
}
