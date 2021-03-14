package com.isaac.learning.firstproject.repository;

import com.isaac.learning.firstproject.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepository  extends JpaRepository<Alien, Integer> {

    List<Alien> findByLang(String tech);

    List<Alien> findByAidGreaterThan(int id);

    @Query("from Alien where lang=?1 order by aname")
    List<Alien> findByLangSorted(String lang);

}
