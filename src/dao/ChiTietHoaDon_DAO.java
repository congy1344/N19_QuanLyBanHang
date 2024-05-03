package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.SanPham;
import dao.SanPham_DAO;

public class ChiTietHoaDon_DAO {

    public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        int n = 0;
        Connection connection = ConnectDB.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ChiTietHoaDon (MaSP, MaHD, SLSP) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chiTietHoaDon.getSanPham().getMaSP());
            preparedStatement.setString(2, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(3, chiTietHoaDon.getSoLuongSP());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public List<ChiTietHoaDon> layChiTietHoaDonTheoMaHoaDon(String maHoaDon) {
        List<ChiTietHoaDon> danhSachChiTietHoaDon = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maHoaDon);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sanPhamId = resultSet.getString("MaSP");
                int soLuongSP = resultSet.getInt("SLSP");
                // Lấy thông tin của sản phẩm từ cơ sở dữ liệu
                SanPham sanPham = null;
				try {
					sanPham = SanPham_DAO.getSanPhamTheoMa(sanPhamId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                // Tạo đối tượng ChiTietHoaDon
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, maHoaDon, soLuongSP);
                danhSachChiTietHoaDon.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return danhSachChiTietHoaDon;
    }
}
