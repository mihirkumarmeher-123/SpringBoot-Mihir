package com.myprojects.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class JwtConfig {

    private static final String KEYCLOAK_PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9ar9EhQbP75c2O9Hom7fgMJz80zI4tYz7iVHw0GH53TMRG7Ktdtn4PppnRo+OiCTV4nqPdd7ErwRV1dE0H9CkgHu6yZ7R23DnnUvG0LpgnLzCdokmyEKAv8ZmaybmjPxFdjYXzZyzjevP3nQEqASwtYBFPX5Fqi4+cKaXCfWTnMhWxSHw0CCOcGOMcRetqgVMwLw7uQp0nQ13d+tIpk+X2LABysnSfdRo+pW9VywYDhnFXaKwzHb0A3bLLyO3ZePhzwWH2lSJtKSbtvNGT6zBuFeykk0jLHGXFcsaOg3LWB9y58zYXipC5pl7+AkTaO4l7R4dntqorxZM2mQH/s0zQIDAQAB";

    @Bean
    public JwtDecoder jwtDecoder() {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(KEYCLOAK_PUBLIC_KEY);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(spec);

            return NimbusJwtDecoder.withPublicKey(publicKey).build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create JwtDecoder", e);
        }
    }
}
