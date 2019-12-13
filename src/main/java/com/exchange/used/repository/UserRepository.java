package com.exchange.used.repository;

import com.exchange.used.entity.User;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String> {
 User getByUsernameAndPassword(String username,String password);
 User getByUsername(String usernme);
 User getByUserid(String id);

}
