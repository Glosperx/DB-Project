package com.example.BD.Comanda;

import com.example.BD.Motor.Motor;
import com.example.BD.Pachet_Echipare.Pachet_Echipare;
import com.example.BD.Culoare.Culoare;
import com.example.BD.Roti.Roti;
import com.example.BD.Client.Client;
import com.example.BD.Comenzi_Pachet.Comenzi_Pachet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

@Repository
public interface Comanda_Repository extends JpaRepository<Comanda, Long> {

    @Query("SELECT (m.pretMotor + p.pretPachet + c.pretCuloare + r.pretRoti) * (1 - cp.reducere / 100) " +
            "FROM Comanda co " +
            "JOIN Motor m ON co.motor.ID_Motor = m.ID_Motor " +
            "JOIN Pachet_Echipare p ON co.pachet.ID_Pachet = p.ID_Pachet " +
            "JOIN Culoare c ON co.culoare.ID_CULOARE = c.ID_CULOARE " +
            "JOIN Roti r ON co.roti.ID_ROTI = r.ID_ROTI " +
            "JOIN Comenzi_Pachet cp ON co.ID_Comanda = cp.comanda.ID_Comanda " +
            "WHERE co.ID_Comanda = :comandaId " +
            "AND co.metodaPlata = '1'")
    Double calculPretTotal(@Param("comandaId") Long comandaId);




    @Query("SELECT c FROM Comanda c")
    List<Comanda> findAllComenzi();

    @Query(value = "SELECT * FROM COMANDA ORDER BY Metoda_Plata ASC", nativeQuery = true)
    List<Comanda> sortByMetodaPlataAsc();

    @Query(value = "SELECT * FROM COMANDA ORDER BY Metoda_Plata DESC", nativeQuery = true)
    List<Comanda> sortByMetodaPlataDesc();

    @Query(value = "SELECT * FROM COMANDA ORDER BY Oras_Livrare ASC", nativeQuery = true)
    List<Comanda> sortByOrasLivrareAsc();

    @Query(value = "SELECT * FROM COMANDA ORDER BY Oras_Livrare DESC", nativeQuery = true)
    List<Comanda> sortByOrasLivrareDesc();

    @Query(value = "SELECT * FROM COMANDA ORDER BY ID_Client ASC", nativeQuery = true)
    List<Comanda> sortByIdClientAsc();

    @Query(value = "SELECT * FROM COMANDA ORDER BY ID_Client DESC", nativeQuery = true)
    List<Comanda> sortByIdClientDesc();

    @Modifying
    @Transactional
    @Query("UPDATE Comanda c SET c.metodaPlata = :metodaPlata, c.orasLivrare = :orasLivrare WHERE c.ID_Comanda = :idComanda")
    void updateComanda(Long idComanda, char metodaPlata, String orasLivrare);

    @Modifying
    @Transactional
    @Query("DELETE FROM Comanda c WHERE c.ID_Comanda = :idComanda")
    void deleteByIdComanda(Long idComanda);
}
