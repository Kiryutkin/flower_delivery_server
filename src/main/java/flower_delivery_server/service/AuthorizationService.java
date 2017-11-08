package flower_delivery_server.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import flower_delivery_server.entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface AuthorizationService {
    GoogleIdToken checkToken(String token) throws GeneralSecurityException, IOException;
    User createUserByToken(String token) throws GeneralSecurityException, IOException;
}
