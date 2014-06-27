package com.lexicalscope.sb.main;

import static com.lexicalscope.sb.main.TestServerSuite.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTestServer {
   @BeforeClass public static void setupServer() throws Exception {
      setupTest();
   }

   @After public void cleanup() {
      dropAll();
   }

   @AfterClass public static void cleanupServer() throws Exception {
      tearDownTest();
   }
}
