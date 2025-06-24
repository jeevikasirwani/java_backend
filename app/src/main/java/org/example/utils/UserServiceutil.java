package org.example.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceutil {
    

    public static String hashPass(String plainPass){
        return BCrypt.hashpw(plainPass, BCrypt.gensalt());
    }


    public static boolean checkPassword(String plainPass,String hashPass){
        return BCrypt.checkpw(plainPass, hashPass);
    }
}
