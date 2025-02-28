package com.example.BD.Elemente_Pachet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Elemente_Pachet_Repository extends JpaRepository<Elemente_Pachet, Integer> {

    @Override
    List<Elemente_Pachet> findAll();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY ID_ELEMENT ASC", nativeQuery = true)
    List<Elemente_Pachet> sortById();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY ID_ELEMENT DESC", nativeQuery = true)
    List<Elemente_Pachet> sortDById();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY NUME_ELEMENT ASC", nativeQuery = true)
    List<Elemente_Pachet> sortByNumeElement();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY NUME_ELEMENT DESC", nativeQuery = true)
    List<Elemente_Pachet> sortDByNumeElement();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY MATERIAL ASC", nativeQuery = true)
    List<Elemente_Pachet> sortByMaterial();

    @Query(value = "SELECT * FROM ELEMENTE_PACHET ORDER BY MATERIAL DESC", nativeQuery = true)
    List<Elemente_Pachet> sortDByMaterial();
}
