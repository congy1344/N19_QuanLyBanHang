package dao;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DonViTinh;
import entity.LoaiHang;
import entity.SanPham;

public class SanPham_DAO {
	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		Connection conN = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conN.createStatement();
			String sql = "select*from SanPham";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maSP = rs.getString("MaSP");
				String tenSP = rs.getString("TenSP");
				LocalDate ngaySX = rs.getDate("NgaySX").toLocalDate();
				LocalDate hSD = rs.getDate("HSD").toLocalDate();
				float giaNhap = rs.getFloat("GiaNhap");
				float giaBan = rs.getFloat("GiaBan");
				float thue = rs.getFloat("Thue");
				String loaiHang = rs.getString("LoaiHang");
				LoaiHang lh = null;
				if (loaiHang.equalsIgnoreCase(LoaiHang.THUC_PHAM.toString())) {
					lh = LoaiHang.THUC_PHAM;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.DO_DUNG.toString())) {
					lh = LoaiHang.DO_DUNG;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.VAN_PHONG_PHAM.toString())) {
					lh = LoaiHang.VAN_PHONG_PHAM;
				} else {
					lh = LoaiHang.KHAC;
				}
				String donViTinh = rs.getString("DonViTinh");
				DonViTinh dvt = null;
				if (donViTinh.equalsIgnoreCase(DonViTinh.KG.toString())) {
					dvt = DonViTinh.KG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.GOI.toString())) {
					dvt = DonViTinh.GOI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.THUNG.toString())) {
					dvt = DonViTinh.THUNG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.CHAI.toString())) {
					dvt = DonViTinh.CHAI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.LOC.toString())) {
					dvt = DonViTinh.LOC;
				} else {
					dvt = DonViTinh.KHAC;
				}
				int soLuongTonKho = rs.getInt("SoLuongTonKho");
				SanPham sp = new SanPham(maSP, tenSP, ngaySX, hSD, giaNhap, giaBan, thue, lh, dvt, soLuongTonKho);
				dsSP.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSP;
	}
	
	public boolean themSanPham(SanPham sanPham) {
		int n = 0;
		ConnectDB.getInstance();
		Connection conN = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		String sql = "INSERT INTO SanPham ( MaSP, TenSP, NgaySX, HSD, GiaNhap, GiaBan, Thue, LoaiHang, DonViTinh, SoLuongTonKho ) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = conN.prepareStatement(sql);
			pstm.setString(1, sanPham.getMaSP());
			pstm.setString(2, sanPham.getTenSP());
			pstm.setDate(3, Date.valueOf(sanPham.getNgaySX()));
			pstm.setDate(4, Date.valueOf(sanPham.gethSD()));
			pstm.setDouble(5, sanPham.getGiaNhap());
			pstm.setDouble(6, sanPham.getGiaBan());
			pstm.setDouble(7, sanPham.getThue());
			pstm.setString(8, sanPham.getLoaiHang().toString());
			pstm.setString(9, sanPham.getDonViTinh().toString());
			pstm.setInt(10, sanPham.getSoLuongTonKho());;
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean capNhatSanPham(SanPham sanPham) {
		int n = 0;
		ConnectDB.getInstance();
		Connection conN = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		String sql = "update SanPham set TenSP=?, NgaySX=?, HSD=?, GiaNhap=?, GiaBan=?, Thue=?, LoaiHang=?, DonViTinh=?, SoLuongTonKho=? where MaSP=? ";
		try {
			pstm = conN.prepareStatement(sql);
			pstm.setString(1, sanPham.getTenSP());
			pstm.setDate(2, Date.valueOf(sanPham.getNgaySX()));
			pstm.setDate(3, Date.valueOf(sanPham.gethSD()));
			pstm.setDouble(4, sanPham.getGiaNhap());
			pstm.setDouble(5, sanPham.getGiaBan());
			pstm.setDouble(6, sanPham.getThue());
			pstm.setString(7, sanPham.getLoaiHang().toString());
			pstm.setString(8, sanPham.getDonViTinh().toString());
			pstm.setInt(9, sanPham.getSoLuongTonKho());;
			pstm.setString(10, sanPham.getMaSP());
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean xoaTheoMaSanPham(String maSP) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		String sql = "delete from SanPham where MaSP ='" + maSP + "'";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public SanPham getSanPhamTheoMa(String maSP) {
		SanPham sp = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM SanPham WHERE MaSP = '%s'", maSP);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenSP = rs.getString("TenSP");
				LocalDate ngaySX = rs.getDate("NgaySX").toLocalDate();
				LocalDate hSD = rs.getDate("HSD").toLocalDate();
				float giaNhap = rs.getFloat("GiaNhap");
				float giaBan = rs.getFloat("GiaBan");
				float thue = rs.getFloat("Thue");
				String loaiHang = rs.getString("LoaiHang");
				LoaiHang lh = null;
				if (loaiHang.equalsIgnoreCase(LoaiHang.THUC_PHAM.toString())) {
					lh = LoaiHang.THUC_PHAM;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.DO_DUNG.toString())) {
					lh = LoaiHang.DO_DUNG;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.VAN_PHONG_PHAM.toString())) {
					lh = LoaiHang.VAN_PHONG_PHAM;
				} else {
					lh = LoaiHang.KHAC;
				}
				String donViTinh = rs.getString("DonViTinh");
				DonViTinh dvt = null;
				if (donViTinh.equalsIgnoreCase(DonViTinh.KG.toString())) {
					dvt = DonViTinh.KG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.GOI.toString())) {
					dvt = DonViTinh.GOI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.THUNG.toString())) {
					dvt = DonViTinh.THUNG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.CHAI.toString())) {
					dvt = DonViTinh.CHAI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.LOC.toString())) {
					dvt = DonViTinh.LOC;
				} else {
					dvt = DonViTinh.KHAC;
				}
				int soLuongTonKho = rs.getInt("SoLuongTonKho");
				sp = new SanPham(maSP, tenSP, ngaySX, hSD, giaNhap, giaBan, thue, lh, dvt, soLuongTonKho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return sp;
	}
	public SanPham getSanPhamTheoTen(String tenSP) {
		SanPham sp = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM SanPham WHERE MaSP = '%s'", tenSP);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maSanPham = rs.getString("MaSP");
				LocalDate ngaySX = rs.getDate("NgaySX").toLocalDate();
				LocalDate hSD = rs.getDate("HSD").toLocalDate();
				float giaNhap = rs.getFloat("GiaNhap");
				float giaBan = rs.getFloat("GiaBan");
				float thue = rs.getFloat("Thue");
				String loaiHang = rs.getString("LoaiHang");
				LoaiHang lh = null;
				if (loaiHang.equalsIgnoreCase(LoaiHang.THUC_PHAM.toString())) {
					lh = LoaiHang.THUC_PHAM;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.DO_DUNG.toString())) {
					lh = LoaiHang.DO_DUNG;
				} else if (loaiHang.equalsIgnoreCase(LoaiHang.VAN_PHONG_PHAM.toString())) {
					lh = LoaiHang.VAN_PHONG_PHAM;
				} else {
					lh = LoaiHang.KHAC;
				}
				String donViTinh = rs.getString("DonViTinh");
				DonViTinh dvt = null;
				if (donViTinh.equalsIgnoreCase(DonViTinh.KG.toString())) {
					dvt = DonViTinh.KG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.GOI.toString())) {
					dvt = DonViTinh.GOI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.THUNG.toString())) {
					dvt = DonViTinh.THUNG;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.CHAI.toString())) {
					dvt = DonViTinh.CHAI;
				} else if (donViTinh.equalsIgnoreCase(DonViTinh.LOC.toString())) {
					dvt = DonViTinh.LOC;
				} else {
					dvt = DonViTinh.KHAC;
				}
				int soLuongTonKho = rs.getInt("SoLuongTonKho");
				sp = new SanPham(maSanPham, tenSP, ngaySX, hSD, giaNhap, giaBan, thue, lh, dvt, soLuongTonKho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return sp;
	}
}
