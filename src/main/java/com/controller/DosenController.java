package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.DosenService;
import com.model.Dosen;

@RestController
@CrossOrigin
public class DosenController {
	@Autowired
	DosenService dosenService;
	
	@GetMapping("/dosen")
	public List<Dosen> getAllDosen(){
		return dosenService.getAllDosen();
	}
	
	@PostMapping("/dosen/insert")
	public ResponseEntity<String> addDosen(@RequestBody Dosen dosenRequest){
		String nama_lengkap = dosenRequest.getNama_lengkap();
		dosenService.addDosen(dosenRequest);
		return ResponseEntity.ok("Dosen dengan nama " + nama_lengkap + " berhasil ditambahkan");
	}
	
	@DeleteMapping("/dosen/delete")
	public ResponseEntity<String> deleteDosen(@RequestParam String id_dosen){
		String nama_lengkap = dosenService.getDosenById(id_dosen).getNama_lengkap();
		dosenService.deleteDosen(id_dosen);
		return ResponseEntity.ok("Dosen dengan nama " + nama_lengkap + " berhasil dihapus");
	}
}