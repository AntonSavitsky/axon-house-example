package com.exadel.axonexample.axonhouseapp.repository;

import com.exadel.axonexample.axonhouseapp.query.HouseEntry;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author albert
 */
public interface HouseRepository extends JpaRepository<HouseEntry, String> {
    HouseEntry findOneByHouseId(String houseId);
}
