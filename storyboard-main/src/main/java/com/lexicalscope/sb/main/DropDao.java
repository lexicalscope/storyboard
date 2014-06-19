package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface DropDao {
   @SqlUpdate("DROP ALL OBJECTS")
   void dropAll();
}
