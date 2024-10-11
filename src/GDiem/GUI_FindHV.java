package GDiem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;

public class GUI_FindHV extends JFrame implements ActionListener {

    private final String[] lop = {"62TH1", "62PM1", "62PM2"};
    private final String[] headers = {"Mã học viên","Họ tên","Lớp","Điểm"};
    private JTextField tf_maHV = new JTextField();;
    private JTextField tf_diem = new JTextField();
    private JTextField tf_hoTen = new JTextField();
    private JLabel lb_maHV = new JLabel("Mã Học Viên");
    private JLabel lb_hoTen = new JLabel("Họ Tên");
    private JLabel lb_diem = new JLabel("Điểm Tổng Kết");
    private JLabel lb_lop = new JLabel("Lớp");
    private JLabel lb_ketQua = new JLabel("Kết Quả");
    private JComboBox<String> cb_lop = new JComboBox<String>(lop);
    private JButton btn_them = new JButton("Thêm Học Viên");
    private DefaultTableModel model = new DefaultTableModel(headers, 0);
    private JTable tbl_HV = new JTable(model);
    private JPanel pn_ketQua = new JPanel(new GridLayout(1,1));


    public GUI_FindHV(){

        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        initializeComponent();
        this.setVisible(true);

    }


    public void initializeComponent(){

        lb_maHV.setSize(80,25);
        lb_maHV.setLocation(50,19);
        lb_maHV.setVisible(true);

        tf_maHV.setSize(250,25);
        tf_maHV.setLocation(140,20);
        tf_maHV.setVisible(true);

        lb_hoTen.setSize(80,25);
        lb_hoTen.setLocation(50,54);
        lb_hoTen.setVisible(true);

        tf_hoTen.setSize(250,25);
        tf_hoTen.setLocation(140,55);
        tf_hoTen.setVisible(true);

        lb_lop.setSize(80,25);
        lb_lop.setLocation(50,89);
        lb_lop.setVisible(true);

        cb_lop.setSize(250,25);
        cb_lop.setLocation(140,90);
        cb_lop.setVisible(true);

        lb_diem.setSize(100,25);
        lb_diem.setLocation(50,124);
        lb_diem.setVisible(true);

        tf_diem.setSize(250,25);
        tf_diem.setLocation(140,125);
        tf_diem.setVisible(true);

        btn_them.setSize(140, 25);
        btn_them.setLocation(250,160);
        btn_them.setVisible(true);
        btn_them.addActionListener(this);

        pn_ketQua.setSize(400,400);
        pn_ketQua.setLocation(150,200);
        pn_ketQua.setVisible(true);
        pn_ketQua.add(new JScrollPane(tbl_HV));

        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {

                XLDiem xlDiem = new XLDiem();
                List<HocVien> hocViens = xlDiem.getHV();
                for(HocVien hocVien:hocViens){
                    String[] dataRow = {String.valueOf(hocVien.getMaHV()), hocVien.getHoTen(), hocVien.getLop(), String.valueOf(hocVien.getDiem())};
                    model.addRow(dataRow);
                }

            }
        });

       this.add(tf_diem);
       this.add(tf_hoTen);
       this.add(tf_maHV);
       this.add(lb_diem);
       this.add(lb_hoTen);
       this.add(lb_maHV);
       this.add(lb_lop);
       this.add(lb_ketQua);
       this.add(lb_ketQua);
       this.add(cb_lop);
       this.add(btn_them);
       this.add(pn_ketQua);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        XLDiem xldiem = new XLDiem();
        HocVien hocVien = new HocVien();
        hocVien.setHoTen(this.tf_hoTen.getText());
        hocVien.setLop(Objects.requireNonNull(this.cb_lop.getSelectedItem()).toString());
        hocVien.setDiem(Double.parseDouble(this.tf_diem.getText()));
        hocVien.setMaHV(Integer.parseInt(this.tf_maHV.getText()));
        xldiem.insertHV(hocVien);
        String[] dataRow = new String[]{String.valueOf(hocVien.getMaHV()), hocVien.getHoTen(), hocVien.getLop(), String.valueOf(hocVien.getDiem())};
        model.addRow(dataRow);

    }
}
