package com.exchange.used.repository;

import com.exchange.used.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ListRepository extends JpaRepository<List, String> {


}
