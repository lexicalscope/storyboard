package com.lexicalscope.sb.http;

import java.util.Iterator;

public interface WebResponse {
   void status(int status, String reason);
   void header(String name, String value);
   void headers(String name, Iterator<String> values);
   void content(int status, Template template);
}
