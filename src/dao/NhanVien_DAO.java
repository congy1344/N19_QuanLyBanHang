/*
 *@(#)NhanVien_DAO.java	1.0		Apr 28, 2024
 *
 *Copyright (c) 2024 IUH. All rights reserved
 */
package dao;
/*
 *@description: 
 *@author : Khai Tien
 *@date : Apr 28, 2024
 *@version: 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	
	public boolean themNhanVien(NhanVien nhanvien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			String sql="INSERT INTO NhanVien ( MaNV, TenNV, DiaChi, SoDienThoai ) values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanvien.getMaNV());
			pstm.setString(2, nhanvien.getTenNV());
			pstm.setString(3, nhanvien.getDiaChi());
			pstm.setString(4, nhanvien.getSdt());
			n = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	 public NhanVien getNhanVienTheoMa(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		NhanVien nv = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien"+ "WHERE NhanVien.MaNV = '%s'", ma);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String tenNV = rs.getString("TenNV");
				String diachi = rs.getString("DiaChi");
				String sdt = rs.getString("SDT");
				nv = new NhanVien(maNV, tenNV, diachi, sdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 return nv;
	 }

	 public NhanVien getNhanVienTheoSDT(String sdt) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		NhanVien nv = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien"+ "WHERE NhanVien.SDT = '%s'", sdt);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String tenNV = rs.getString("TenNV");
				String diachi = rs.getString("DiaChi");
				String sodienthoai = rs.getString("SDT");
				nv = new NhanVien(maNV, tenNV, diachi, sodienthoai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nv;
	}
}
