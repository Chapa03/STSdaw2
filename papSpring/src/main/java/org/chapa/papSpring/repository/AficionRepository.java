package org.chapa.papSpring.repository;

import org.chapa.papSpring.entities.Aficion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AficionRepository extends JpaRepository<Aficion, Long> {

}
