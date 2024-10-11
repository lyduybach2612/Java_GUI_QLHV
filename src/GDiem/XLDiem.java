package GDiem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XLDiem{

    public Connection getConnection() {
        String connectionString = "jdbc:sqlserver://" +
                "LAPTOP-RT1ETNCP\\LYDUYBACH;" +
                "database=DLDiem;" +
                "user=sa;" +
                "password=bach2612;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            System.out.println("connection established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public List<HocVien> getHV() {
        String query = String.format("SELECT * FROM tbHocvien");
        Connection connection = getConnection();
        List<HocVien> hvs = new ArrayList<HocVien>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HocVien hv = new HocVien();
                hv.setMaHV(Integer.parseInt(resultSet.getString(1)));
                hv.setHoTen(resultSet.getString(2));
                hv.setLop(resultSet.getString(3));
                hv.setDiem(Double.parseDouble(resultSet.getString(4)));
                hvs.add(hv);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return hvs;
    }

    public void insertHV(HocVien hv) {
        String query = "INSERT INTO tbHocvien VALUES (?, ?, ?, ?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, hv.getMaHV());
            preparedStatement.setString(2, hv.getHoTen());
            preparedStatement.setString(3, hv.getLop());
            preparedStatement.setDouble(4, hv.getDiem());
            if (preparedStatement.executeUpdate()>0) {
                System.out.println("Insert successfully");
            }
            else {
                System.out.println("Insert failed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
