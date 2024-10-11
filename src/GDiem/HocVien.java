package GDiem;

public class HocVien {

    private int maHV;
    private String hoTen;
    private String lop;
    private double diem;

    public HocVien() {
    }

    public HocVien(int maHV, String hoTen, String lop, double diem) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diem = diem;
    }

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String ketQua(){
        if(this.diem >= 20) return "Đỗ";
        return "Trượt";
    }

}
