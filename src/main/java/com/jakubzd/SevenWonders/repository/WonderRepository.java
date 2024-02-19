package com.jakubzd.SevenWonders.repository;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Wonder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WonderRepository extends JpaRepository<Wonder, Long> {

    List<Wonder> findByExpansion(Expansion expansion);
}
