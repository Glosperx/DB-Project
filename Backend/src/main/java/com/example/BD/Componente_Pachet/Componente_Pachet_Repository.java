package com.example.BD.Componente_Pachet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Componente_Pachet_Repository extends JpaRepository<Componente_Pachet, Long> {

    @Override
    List<Componente_Pachet> findAll();

    // Sort by Pachet (ID_Pachet)
    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY ID_Pachet ASC", nativeQuery = true)
    List<Componente_Pachet> sortByPachetAsc();

    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY ID_Pachet DESC", nativeQuery = true)
    List<Componente_Pachet> sortByPachetDesc();

    // Sort by Element (ID_Element)
    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY ID_Element ASC", nativeQuery = true)
    List<Componente_Pachet> sortByElementAsc();

    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY ID_Element DESC", nativeQuery = true)
    List<Componente_Pachet> sortByElementDesc();

    // Sort by Inclus (ASC/DESC)
    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY Inclus ASC", nativeQuery = true)
    List<Componente_Pachet> sortByInclusAsc();

    @Query(value = "SELECT * FROM COMponente_Pachet ORDER BY Inclus DESC", nativeQuery = true)
    List<Componente_Pachet> sortByInclusDesc();
}
