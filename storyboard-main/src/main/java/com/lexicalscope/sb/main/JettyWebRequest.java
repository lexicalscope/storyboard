package com.lexicalscope.sb.main;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

import com.lexicalscope.sb.http.WebRequest;

public class JettyWebRequest implements WebRequest {
   private final String target;
   private final Request baseRequest;
   private final HttpServletRequest request;

   private final HashMap<String, Cookie> cookieMap;

   public JettyWebRequest(final String target, final Request baseRequest, final HttpServletRequest request) {
      this.target = target;
      this.baseRequest = baseRequest;
      this.request = request;

      cookieMap = new HashMap<String, Cookie>();
      for(final Cookie cookie : request.getCookies()){
          cookieMap.put(cookie.getName(), cookie);
      }
   }

   @Override public String method() {
      return request.getMethod();
   }

   @Override public String path() {
      return target;
   }

   @Override public String header(final String name) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public Iterator<String> headers(final String name) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public Iterator<String> headerNames() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public boolean hasHeader(final String name) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override public String getCookie(final String string) {
      return cookieMap.get(string).getValue();
   }

   @Override public String contentType() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public String content() {
      // TODO Auto-generated method stub
      return null;
   }

}
