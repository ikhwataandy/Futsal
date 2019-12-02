/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author asus
 */
public class Session {
    private static String userId,nama,StatusLogin;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        Session.userId = userId;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String password) {
        Session.nama = nama;
    }

    public static String getStatusLogin() {
        return StatusLogin;
    }

    public static void setStatusLogin(String StatusLogin) {
        Session.StatusLogin = StatusLogin;
    }
    
    
}
