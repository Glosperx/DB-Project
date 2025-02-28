package com.example.BD.Roti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Roti_Repository extends JpaRepository<Roti, Integer> {

    @Override
    List<Roti> findAll();

    @Query(value = "SELECT * FROM ROTI ORDER BY ID_ROTI ASC", nativeQuery = true)
    List<Roti> sortById();

    @Query(value = "SELECT * FROM ROTI ORDER BY ID_ROTI DESC", nativeQuery = true)
    List<Roti> sortDById();

    @Query(value = "SELECT * FROM ROTI ORDER BY DIMENSIUNE_ROTI ASC", nativeQuery = true)
    List<Roti> sortByDimensiuneRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY DIMENSIUNE_ROTI DESC", nativeQuery = true)
    List<Roti> sortDByDimensiuneRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY CULOARE_ROTI ASC", nativeQuery = true)
    List<Roti> sortByCuloareRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY CULOARE_ROTI DESC", nativeQuery = true)
    List<Roti> sortDByCuloareRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY DENUMIRE_ROTI ASC", nativeQuery = true)
    List<Roti> sortByDenumireRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY DENUMIRE_ROTI DESC", nativeQuery = true)
    List<Roti> sortDByDenumireRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY PRET_ROTI ASC", nativeQuery = true)
    List<Roti> sortByPretRoti();

    @Query(value = "SELECT * FROM ROTI ORDER BY PRET_ROTI DESC", nativeQuery = true)
    List<Roti> sortDByPretRoti();
}
