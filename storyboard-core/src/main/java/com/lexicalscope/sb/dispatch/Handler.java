package com.lexicalscope.sb.dispatch;

import com.lexicalscope.sb.http.WebRequest;
import com.lexicalscope.sb.http.WebResponse;

public interface Handler {
   void get(WebRequest request, WebResponse response);
}
