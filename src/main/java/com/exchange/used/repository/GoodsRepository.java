package com.exchange.used.repository;

import com.exchange.used.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, String> {

}
