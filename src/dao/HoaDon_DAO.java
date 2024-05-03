package dao;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.PTThanhToan;

public class HoaDon_DAO {
	public static ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connection conN = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conN.createStatement();
			String sql = "select*from HoaDon";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String maHD = rs.getString("MaHD");
				LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
				String ptThanhToan = rs.getString("PhuongThucTT");
				PTThanhToan pttt = null;
				if (ptThanhToan.equalsIgnoreCase("Tiền mặt")) {
					pttt = PTThanhToan.TIEN_MAT;
				} else{
					pttt = PTThanhToan.ONLINE;
				}
				double tienKhachDua = rs.getDouble("TienKhachDua");
				
				HoaDon hd = new HoaDon(maNV, maHD, ngayLap, pttt, tienKhachDua);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public boolean themHoaDon(HoaDon hoaDon) {
		int n = 0;
		ConnectDB.getInstance();
		Connection conN = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		String sql = "INSERT INTO HoaDon ( MaNV, MaHD, NgayLap, PhuongThucTT, TienKhachDua) VALUES (?,?,?,?,?)";
		try {
			pstm = conN.prepareStatement(sql);
			pstm.setString(1, hoaDon.getMaNhanVien());
			pstm.setString(2, hoaDon.getMaHD());
			pstm.setDate(3, Date.valueOf(hoaDon.getNgayLapHoaDon()));
			pstm.setString(4, hoaDon.getPtThanhToan().toString());
			pstm.setDouble(5, hoaDon.getTienKhachDua());
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
	
	public HoaDon getHoaDonTheoMa(String maHD) {
	    HoaDon hd = null;
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(2, maHD);
	        rs = stmt.executeQuery();
	        if (rs.next()) {
	            String maNV = rs.getString("MaNV");
	            LocalDate ngayLap = rs.getDate("NgayLap").toLocalDate();
	            String ptThanhToan = rs.getString("PhuongThucTT");
	            PTThanhToan pttt = null;
	            if (ptThanhToan.equalsIgnoreCase("Tiền mặt")) {
	                pttt = PTThanhToan.TIEN_MAT;
	            } else {
	                pttt = PTThanhToan.ONLINE;
	            }
	            double tienKhachDua = rs.getDouble("TienKhachDua");
	            
	            hd = new HoaDon(maNV, maHD, ngayLap, pttt, tienKhachDua);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return hd;
	}

	public List<HoaDon> getDanhSachHoaDonTheoNgay(LocalDate ngayLap) {
	    List<HoaDon> danhSachHoaDon = new ArrayList<>();
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String sql = "SELECT * FROM HoaDon WHERE NgayLap = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setDate(3, java.sql.Date.valueOf(ngayLap));
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            String maHD = rs.getString("MaHD");
	            String maNV = rs.getString("MaNV");
	            String ptThanhToan = rs.getString("PhuongThucTT");
	            PTThanhToan pttt = ptThanhToan.equalsIgnoreCase("Tiền mặt") ? PTThanhToan.TIEN_MAT : PTThanhToan.ONLINE;
	            double tienKhachDua = rs.getDouble("TienKhachDua");
	            
	            HoaDon hd = new HoaDon(maNV, maHD, ngayLap, pttt, tienKhachDua);
	            danhSachHoaDon.add(hd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return danhSachHoaDon;
	}
}