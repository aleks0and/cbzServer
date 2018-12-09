package io.swagger;


import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.service.Firebase;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) throws FirebaseException, UnsupportedEncodingException {

        String firebase_baseUrl = "https://hackhaton-cbz.firebaseio.com/locations";

        for( String s : args ) {
            if( s == null || s.trim().isEmpty() ) continue;
            if( s.trim().split( "=" )[0].equals( "baseUrl" ) ) {
                firebase_baseUrl = s.trim().split( "=" )[1];
            }
        }
        if( firebase_baseUrl == null || firebase_baseUrl.trim().isEmpty() ) {
            throw new IllegalArgumentException( "Program-argument 'baseUrl' not found but required" );
        }
        // create the firebase
        Firebase firebase = new Firebase( firebase_baseUrl);
        System.out.println( firebase.get().getBody());

    }
}
