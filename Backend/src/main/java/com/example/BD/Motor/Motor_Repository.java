package com.example.BD.Motor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Motor_Repository extends JpaRepository<Motor, Integer> {

    @Override
    List<Motor> findAll();

    @Query(value = "SELECT * FROM MOTOR ORDER BY ID_MOTOR ASC", nativeQuery = true)
    List<Motor> sortById();

    @Query(value = "SELECT * FROM MOTOR ORDER BY ID_MOTOR DESC", nativeQuery = true)
    List<Motor> sortDById();

    @Query(value = "SELECT * FROM MOTOR ORDER BY TIP_MOTOR ASC", nativeQuery = true)
    List<Motor> sortByTipMotor();

    @Query(value = "SELECT * FROM MOTOR ORDER BY TIP_MOTOR DESC", nativeQuery = true)
    List<Motor> sortDByTipMotor();

    @Query(value = "SELECT * FROM MOTOR ORDER BY CAPACITATE_CILINDRICA ASC", nativeQuery = true)
    List<Motor> sortByCapacitateCilindrica();

    @Query(value = "SELECT * FROM MOTOR ORDER BY CAPACITATE_CILINDRICA DESC", nativeQuery = true)
    List<Motor> sortDByCapacitateCilindrica();

    @Query(value = "SELECT * FROM MOTOR ORDER BY PUTERE ASC", nativeQuery = true)
    List<Motor> sortByPutere();

    @Query(value = "SELECT * FROM MOTOR ORDER BY PUTERE DESC", nativeQuery = true)
    List<Motor> sortDByPutere();

    @Query(value = "SELECT * FROM MOTOR ORDER BY PRET_MOTOR ASC", nativeQuery = true)
    List<Motor> sortByPretMotor();

    @Query(value = "SELECT * FROM MOTOR ORDER BY PRET_MOTOR DESC", nativeQuery = true)
    List<Motor> sortDByPretMotor();
}
