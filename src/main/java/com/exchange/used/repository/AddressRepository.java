package com.exchange.used.repository;

import com.exchange.used.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String > {
}
