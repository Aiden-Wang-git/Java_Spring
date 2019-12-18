package com.exchange.used.repository;

import com.exchange.used.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, String> {
    Type getTypeByTypeid(String typeID);
}
