package org.xcolab.service.members.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.xcolab.service.members.util.PBKDF2PasswordEncryptor;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PBKDF2PasswordEncryptorTest {

    private static final String ALGORITHM = "PBKDF2WITHHMACSHA1/160/128000";

    @Test
    public void doEncrypt() throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBKDF2PasswordEncryptor encryptor = new PBKDF2PasswordEncryptor();
        final String hashed = encryptor.doEncrypt(ALGORITHM, "colab123", "");
        Assert.assertEquals(hashed, encryptor.doEncrypt(ALGORITHM, "colab123", hashed));
    }

    @Test
    public void doEncrypt__different() throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBKDF2PasswordEncryptor encryptor = new PBKDF2PasswordEncryptor();
        final String hashed = encryptor.doEncrypt(ALGORITHM, "colab123", "");
        Assert.assertNotEquals(hashed, encryptor.doEncrypt(ALGORITHM, "colab1234", hashed));
    }

    @Test
    public void doEncrypt__matchesKnown() throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBKDF2PasswordEncryptor encryptor = new PBKDF2PasswordEncryptor();
        final String hashed = "160_128000_JVfncAV0kSs=_khzSQKz4vQxlMVbqv8tQK8buLSE=";
        Assert.assertEquals(hashed, encryptor.doEncrypt(ALGORITHM, "colab123", hashed));
    }
}