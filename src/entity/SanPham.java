package entity;

import java.time.LocalDate;
import java.util.Objects;

public class SanPham {

	private String maSP;
	private String tenSP;
	private LocalDate ngaySX;
	private LocalDate hSD;
	private double giaNhap;
	private double giaBan;
	private double thue;
	private LoaiHang loaiHang;
	private DonViTinh donViTinh;
	private int soLuongTonKho;
	

	public SanPham(String maSP, String tenSP, LocalDate ngaySX, LocalDate hSD, double giaNhap, double giaBan,
			double thue, LoaiHang loaiHang, DonViTinh donViTinh, int soLuongTonKho) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngaySX = ngaySX;
		this.hSD = hSD;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.thue = thue;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;
		this.soLuongTonKho = soLuongTonKho;
	}


	public String getMaSP() {
		return maSP;
	}


	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}


	public String getTenSP() {
		return tenSP;
	}


	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}


	public LocalDate getNgaySX() {
		return ngaySX;
	}


	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}


	public LocalDate gethSD() {
		return hSD;
	}


	public void sethSD(LocalDate hSD) {
		this.hSD = hSD;
	}


	public double getGiaNhap() {
		return giaNhap;
	}


	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}


	public double getGiaBan() {
		return giaBan;
	}


	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}


	public double getThue() {
		return thue;
	}


	public void setThue(double thue) {
		this.thue = thue;
	}


	public LoaiHang getLoaiHang() {
		return loaiHang;
	}


	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}


	public DonViTinh getDonViTinh() {
		return donViTinh;
	}


	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}


	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}


	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}


	public double dinhGiaBan() {
		// TODO - implement SanPham.dinhGiaBan
		throw new UnsupportedOperationException();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}


	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", ngaySX=" + ngaySX + ", hSD=" + hSD + ", giaNhap="
				+ giaNhap + ", giaBan=" + giaBan + ", thue=" + thue + ", loaiHang=" + loaiHang + ", donViTinh="
				+ donViTinh + ", soLuongTonKho=" + soLuongTonKho + "]";
	}
}