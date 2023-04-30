package com.pictu.core.utilities;

import java.util.UUID;

public class IdGeneratorString {
    public static String userIDGenerator(){
        return "USR"+ UUID.randomUUID().toString();
    }
    public static String locationIDGenerator(){
        return "LOC"+ UUID.randomUUID().toString();
    }
    public static String photoIDGenerator(){
        return "PIC"+ UUID.randomUUID().toString();
    }
}
