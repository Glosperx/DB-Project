package com.example.BD.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Client_Repository extends JpaRepository<Client, Integer> {

    @Override
    List<Client> findAll();

    @Query(value = "SELECT * FROM CLIENT ORDER BY ID_CLIENT ASC", nativeQuery = true)
    List<Client> sortById();

    @Query(value = "SELECT * FROM CLIENT ORDER BY ID_CLIENT DESC", nativeQuery = true)
    List<Client> sortDById();

    @Query(value = "SELECT * FROM CLIENT ORDER BY NUME ASC", nativeQuery = true)
    List<Client> sortByNume();

    @Query(value = "SELECT * FROM CLIENT ORDER BY NUME DESC", nativeQuery = true)
    List<Client> sortDByNume();

    @Query(value = "SELECT * FROM CLIENT ORDER BY PRENUME ASC", nativeQuery = true)
    List<Client> sortByPrenume();

    @Query(value = "SELECT * FROM CLIENT ORDER BY PRENUME DESC", nativeQuery = true)
    List<Client> sortDByPrenume();

    @Query(value = "SELECT * FROM CLIENT ORDER BY EMAIL ASC", nativeQuery = true)
    List<Client> sortByEmail();

    @Query(value = "SELECT * FROM CLIENT ORDER BY EMAIL DESC", nativeQuery = true)
    List<Client> sortDByEmail();
}
