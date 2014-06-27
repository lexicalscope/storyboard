package com.lexicalscope.sb.main;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.lexicalscope.sb.data.User;
import com.lexicalscope.sb.data.UserId;
import com.lexicalscope.sb.database.UserData;

public interface UserDao extends UserData {
   @SqlUpdate("create table user (id identity primary key, name varchar(100))")
   void createUserTable();

   @SqlUpdate("insert into user (name) values (:name)")
   @GetGeneratedKeys
   long insert(@BindBean User user);

   @Override
   @SqlQuery("select * from user where id = :id")
   User findUserById(@BindBean UserId id);
}
