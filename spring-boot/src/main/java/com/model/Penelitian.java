package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "penelitian")
public class Penelitian{
    @Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String id_penelitian;
    @Column
    private String judul_penelitian;
    @Column
    private String bidang_penelitian;
    @Column
    private LocalDate tgl_penelitian;
    
//    @Lob
//    private byte[] pdfFile;
    
	
	public String getId_penelitian() {
		return id_penelitian;
	}
	public void setId_penelitian(String id_penelitian) {
		this.id_penelitian = id_penelitian;
	}
	public String getJudul_penelitian() {
		return judul_penelitian;
	}
	public void setJudul_penelitian(String judul_penelitian) {
		this.judul_penelitian = judul_penelitian;
	}
	public String getBidang_penelitian() {
		return bidang_penelitian;
	}
	public void setBidang_penelitian(String bidang_penelitian) {
		this.bidang_penelitian = bidang_penelitian;
	}
	public LocalDate getTgl_penelitian() {
		return tgl_penelitian;
	}
	public void setTgl_penelitian(LocalDate tgl_penelitian) {
		this.tgl_penelitian = tgl_penelitian;
	}
	
//	public byte[] getPdfFile() {
//		return pdfFile;
//	}
//	public void setPdfFile(byte[] pdfFile) {
//		this.pdfFile = pdfFile;
//	}
    
}
