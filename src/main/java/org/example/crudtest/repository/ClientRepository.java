package org.example.crudtest.repository;

import org.example.crudtest.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c ORDER BY c.id ASC")
    List<Client> findAllSortedById();
}
