package com.example.BD.Pachet_Echipare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Pachet_Echipare_Repository extends JpaRepository<Pachet_Echipare, Integer> {

    @Override
    List<Pachet_Echipare> findAll();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY ID_PACHET ASC", nativeQuery = true)
    List<Pachet_Echipare> sortById();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY ID_PACHET DESC", nativeQuery = true)
    List<Pachet_Echipare> sortDById();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY NUME_PACHET ASC", nativeQuery = true)
    List<Pachet_Echipare> sortByNumePachet();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY NUME_PACHET DESC", nativeQuery = true)
    List<Pachet_Echipare> sortDByNumePachet();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY PRET_PACHET ASC", nativeQuery = true)
    List<Pachet_Echipare> sortByPretPachet();

    @Query(value = "SELECT * FROM PACHET_ECHIPARE ORDER BY PRET_PACHET DESC", nativeQuery = true)
    List<Pachet_Echipare> sortDByPretPachet();
}
