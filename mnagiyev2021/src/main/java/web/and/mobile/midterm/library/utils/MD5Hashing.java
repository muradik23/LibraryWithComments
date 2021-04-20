package web.and.mobile.midterm.library.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {

    public static String hashing(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");


        byte[] messageDigest = md.digest(pass.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
}
