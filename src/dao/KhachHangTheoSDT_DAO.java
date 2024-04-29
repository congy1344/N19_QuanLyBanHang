package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

//import connect.ConnectDB;

import entity.KhachHang;


public class KhachHangTheoSDT_DAO{
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM KhachHang";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("Ma khach hang");
				String tenKH = rs.getString("Ten khach hang");
				String sdt = rs.getString("So dien thoai");
				KhachHang c = new KhachHang(maKH, tenKH, sdt);
				dskh.add(c);
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
		return dskh;
	}
	
	public KhachHang getKhachHangTheoSDT(String sdtkh) {
		KhachHang cc = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM KhachHang WHERE Masdt = '%s'", sdtkh);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("Ma khach hang");
				String tenKH = rs.getString("Ten khach hang");
				String sdt = rs.getString("So dien thoai");
				cc = new KhachHang(maKH, tenKH, sdt);
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
		return cc;
	}
	

	public boolean themKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			String sql = "INSERT INTO KhachHang (maKH, tenKH, sdt) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, kh.getMaKH());
			pstm.setString(2, kh.getTenKH());
			pstm.setString(3, kh.getSdt());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
}
