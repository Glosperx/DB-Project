package com.example.BD.Kart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Kart_Repository extends JpaRepository<Kart, Integer> {

    @Override
    List<Kart> findAll();

    // Sort by Nume_Model (ascendent/descendent)
    @Query(value = "SELECT * FROM KART ORDER BY Nume_Model ASC", nativeQuery = true)
    List<Kart> sortByNumeModelAsc();

    @Query(value = "SELECT * FROM KART ORDER BY Nume_Model DESC", nativeQuery = true)
    List<Kart> sortByNumeModelDesc();

    // Sort by Pret_Baza (ascendent/descendent)
    @Query(value = "SELECT * FROM KART ORDER BY Pret_Baza ASC", nativeQuery = true)
    List<Kart> sortByPretBazaAsc();

    @Query(value = "SELECT * FROM KART ORDER BY Pret_Baza DESC", nativeQuery = true)
    List<Kart> sortByPretBazaDesc();

    // Sort by Greutate (ascendent/descendent)
    @Query(value = "SELECT * FROM KART ORDER BY Greutate ASC", nativeQuery = true)
    List<Kart> sortByGreutateAsc();

    @Query(value = "SELECT * FROM KART ORDER BY Greutate DESC", nativeQuery = true)
    List<Kart> sortByGreutateDesc();
}
