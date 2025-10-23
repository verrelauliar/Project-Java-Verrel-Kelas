/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Verrel
 */
public class Gaji {
    private String ktp;
    private String pesan;
    private Object[][] listGaji;
    private final Koneksi koneksi = new Koneksi();
    
    public String getKtp() {
        return ktp;
    }
    
    public void setKtp(String ktp) {
        this.ktp = ktp;
    }
    
    public String getPesan() {
        return pesan;
    }
 
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
    
     public Object[][] getListGaji() {
         return listGaji;
    }
     
    public void setListGaji(Object[][] listGaji) {
        this.listGaji = listGaji;
    }
    
    public boolean simpan(){
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) !=null){
            int jumlahSimpan = 0;
            String SQLStatemen;
            PreparedStatement preparedStatement;
            
            try{
                SQLStatemen = "delete from tbgaji where ktp=?"; 
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, ktp);
                preparedStatement.executeUpdate();
            } catch (SQLException ex){}
            
            for (Object[] recGaji : listGaji) {
                try {
                    SQLStatemen = "INSERT INTO tbgaji(ktp, kodepekerjaan, gajibersih, gajikotor, tunjangan) VALUES (?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(SQLStatemen);
                    preparedStatement.setString(1, ktp);
                    preparedStatement.setString(2, recGaji[0].toString());
                    preparedStatement.setDouble(3, Double.parseDouble(recGaji[1].toString()));
                    preparedStatement.setDouble(4, Double.parseDouble(recGaji[2].toString()));
                    preparedStatement.setDouble(5, Double.parseDouble(recGaji[3].toString()));
                    jumlahSimpan += preparedStatement.executeUpdate();
                } catch (SQLException | NullPointerException | NumberFormatException ex) {
                    pesan = "Gagal menyimpan gaji: " + ex.getMessage();
                    adaKesalahan = true;
                }
            }
            
            if (jumlahSimpan>0) {
                adaKesalahan = false;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesanKesalahan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean baca(String ktp) {
    boolean adaKesalahan = false;
    Connection connection;

    this.ktp = ktp;
    listGaji = null;

    if ((connection = koneksi.getConnection()) != null) {
        String SQLStatemen = "SELECT kodepekerjaan, gajibersih, gajikotor, tunjangan FROM tbgaji WHERE ktp=?";
        try (PreparedStatement ps = connection.prepareStatement(SQLStatemen)) {
            ps.setString(1, ktp);
            try (ResultSet rs = ps.executeQuery()) {
                java.util.List<Object[]> data = new java.util.ArrayList<>();

                while (rs.next()) {
                    String kode = rs.getString("kodepekerjaan");
                    if (kode != null && !kode.isEmpty()) {
                        data.add(new Object[]{
                            kode,
                            rs.getObject("gajibersih"),
                            rs.getObject("gajikotor"),
                            rs.getObject("tunjangan")
                        });
                    }
                }

                if (!data.isEmpty()) {
                    listGaji = data.toArray(new Object[0][0]);
                } else {
                    listGaji = new Object[0][0];
                    adaKesalahan = true;
                    pesan = "Data gaji tidak ditemukan untuk KTP: " + ktp;
                }
            }
        } catch (SQLException ex) {
            adaKesalahan = true;
            pesan = "Tidak dapat membaca data gaji karyawan\n" + ex.getMessage();
        } finally {
            try { connection.close(); } catch (SQLException ignored) {}
        }
    } else {
        adaKesalahan = true;
        pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
    }

    return !adaKesalahan;
}

    
    public boolean cetakLaporan(int ruang){
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) !=null){
            String SQLStatement;
            Statement statement;
            ResultSet resultSet = null;
            try {
                SQLStatement = " SELECT tbkaryawan.`ktp` AS tbkaryawan_ktp, "  + " tbkaryawan.`nama` AS tbkaryawan_nama, "  + " tbkaryawan.`ruang` AS tbkaryawan_ruang, " 
                        + " tbpekerjaan.`kodepekerjaan` AS tbpekerjaan_kodepekerjaan, " + " tbpekerjaan.`namapekerjaan` AS tbpekerjaan_namapekerjaan, " 
                        + " tbpekerjaan.`jumlahtugas` AS tbpekerjaan_jumlahtugas, " + " tbgaji.`ktp` AS tbgaji_ktp, " 
                        + " tbgaji.`kodepekerjaan` AS tbgaji_kodepekerjaan, " + " tbgaji.`gajibersih` AS tbgaji_gajibersih, "
                        + " tbgaji.`gajikotor` AS tbgaji_gajikotor, " + " tbgaji.`tunjangan` AS tbgaji_tunjangan, " 
                        + " round((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3, 2) AS tbgaji_gajipokok, " 
                        + "(if((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3>=5000000,'A', " 
                        + " if((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3>=4000000,'B', "
                        + " if((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3>=3000000,'C', "
                        + " if((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3>=2000000,'D','E'))))) AS tbgaji_gajihuruf, "
                        + " (if((tbgaji.`gajibersih`+tbgaji.`gajikotor`+tbgaji.`tunjangan`)/3>=1000000,'UMR','Tidak UMR')) AS tbgaji_status "
                        + " FROM " + " `tbkaryawan` tbkaryawan INNER JOIN `tbgaji` tbgaji ON tbkaryawan.`ktp` = tbgaji.`ktp` "
                        + " INNER JOIN `tbpekerjaan` tbpekerjaan ON tbgaji.`kodepekerjaan` = tbpekerjaan.`kodepekerjaan` ";
                if (ruang!=0){
                    SQLStatement = SQLStatement + "where tbkaryawan.`ruang`="+ruang;
                }
                SQLStatement = SQLStatement + "ORDER BY " + " tbkaryawan.`ruang` ASC, " + " tbkaryawan.`nama` ASC, " + " tbkaryawan.`ktp` ASC";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SQLStatement);
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data\n"+ex;
            }
            
            if (resultSet != null){
                try {
                    JasperDesign disain = JRXmlLoader.load("src/reports/GajiReport.jrxml");
                    JasperReport gajiLaporan = JasperCompileManager.compileReport(disain);
                    JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(resultSet);
                    String Laporan;
                    JasperPrint cetak = JasperFillManager.fillReport(gajiLaporan,new HashMap(),resultSetDataSource);
                    JasperViewer.viewReport(cetak,false);
                } catch (JRException ex) {
                    adaKesalahan = true;
                    pesan = "Tidak dapat mencetak laporan\n"+ex;
                }
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesanKesalahan();
        }
        
        return !adaKesalahan;
    }
}