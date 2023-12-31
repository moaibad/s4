package com.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Penelitian;

public interface PenelitianRepository extends JpaRepository<Penelitian, String> {
	@Query(value = "SELECT penelitian FROM Penelitian penelitian JOIN RiwayatPenelitian riwayat ON penelitian.id_penelitian = riwayat.id_penelitian WHERE riwayat.id_dosen = :idDosen")
	List<Penelitian> getPenelitianByDosenId(@Param("idDosen") String idDosen);
	
	@Query("SELECT p.id_penelitian FROM Penelitian p WHERE p.judul_penelitian = :judul")
    List<String> findIdByJudulPenelitian(@Param("judul") String judul);
	
	@Query("SELECT p FROM Penelitian p WHERE p.judul_penelitian LIKE %:judul%")
	List<Penelitian> searchByJudulPenelitian(@Param("judul") String judul);
	
}
