package com.pictu.iam.core.utilities;

import java.util.UUID;

public class IdGeneratorString {
    public static String customerIDGenerator(){
        return "CUST"+ UUID.randomUUID().toString();
    }
    public static String locationIDGenerator(){
        return "LOC"+ UUID.randomUUID().toString();
    }
    public static String photoIDGenerator(){
        return "PIC"+ UUID.randomUUID().toString();
    }
}
