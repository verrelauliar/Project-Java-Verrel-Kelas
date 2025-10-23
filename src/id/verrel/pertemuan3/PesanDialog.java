/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.verrel.pertemuan3;

import javax.swing.JOptionPane;

/**
 *
 * @author Verrel
 */
public class PesanDialog {
    
    public static void pesan(String pesan){
        JOptionPane.showMessageDialog(null, pesan);
    }
    
    public static void pesanError(String pesan){
        JOptionPane.showMessageDialog(null, pesan, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean konfirmasi(String pesan){
        int hasil = JOptionPane.showConfirmDialog(null, pesan, "Konfirmasi", JOptionPane.YES_NO_OPTION);
        return hasil == JOptionPane.YES_OPTION;
    }
    
    public static String input(String pesan){
        return JOptionPane.showInputDialog(null, pesan);
    }
    
    public int tampilkanPilihan(String pesan, String judul, Object[] opsi){
        return JOptionPane.showOptionDialog(null, pesan, judul, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[0]);
    }
}
