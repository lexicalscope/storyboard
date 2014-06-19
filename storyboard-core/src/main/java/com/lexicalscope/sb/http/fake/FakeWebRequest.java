package com.lexicalscope.sb.http.fake;

import java.util.Iterator;

import com.lexicalscope.sb.http.WebRequest;

public class FakeWebRequest implements WebRequest {
   private String path;
   private String method;

   @Override public String method() {
      return method;
   }

   public void method(final String method) {
      this.method = method;
   }

   @Override public String path() {
      return path;
   }

   public FakeWebRequest path(final String path) {
      this.path = path;
      return this;
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

   @Override public String contentType() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public String content() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override public String getCookie(final String string) {
      // TODO Auto-generated method stub
      return null;
   }
}
