package com.example.finalproject.util;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Password encryptor.
 */
public class PasswordEncryptor {
    private static final Logger logger = LogManager.getLogger(PasswordEncryptor.class);
    private static final String HASH_FUNCTION = "SHA-256";
    private static final String SALT_KEY = "5hr8Uh32Hr";

    private PasswordEncryptor() {
    }

    /**
     * Encrypt string.
     *
     * @param password the password for encrypt
     * @return the string password after encryption
     */
    public static String encrypt(String password) {
        StringBuilder hash = new StringBuilder();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] saltBytes = SALT_KEY.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_FUNCTION);
            digest.update(saltBytes);
            byte[] resultBytes = digest.digest(passwordBytes);
            for (byte next : resultBytes) {
                hash.append(next);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.WARN, "Impossible to encrypted password", e);
        }
        return hash.toString();
    }
}
