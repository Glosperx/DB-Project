package com.example.BD.Culoare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Culoare_Repository extends JpaRepository<Culoare, Integer> {

    @Override
    List<Culoare> findAll();

    @Query(value = "SELECT * FROM CULOARE ORDER BY ID_CULOARE ASC", nativeQuery = true)
    List<Culoare> sortById();

    @Query(value = "SELECT * FROM CULOARE ORDER BY ID_CULOARE DESC", nativeQuery = true)
    List<Culoare> sortDById();

    @Query(value = "SELECT * FROM CULOARE ORDER BY NUME_CULOARE ASC", nativeQuery = true)
    List<Culoare> sortByNumeCuloare();

    @Query(value = "SELECT * FROM CULOARE ORDER BY NUME_CULOARE DESC", nativeQuery = true)
    List<Culoare> sortDByNumeCuloare();

    @Query(value = "SELECT * FROM CULOARE ORDER BY PRET_CULOARE ASC", nativeQuery = true)
    List<Culoare> sortByPretCuloare();

    @Query(value = "SELECT * FROM CULOARE ORDER BY PRET_CULOARE DESC", nativeQuery = true)
    List<Culoare> sortDByPretCuloare();

    @Query(value = "SELECT * FROM CULOARE WHERE TIP_FINISAJ = ?1", nativeQuery = true)
    List<Culoare> findByTipFinisaj(String tipFinisaj);
}
