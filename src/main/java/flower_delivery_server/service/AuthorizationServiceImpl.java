package flower_delivery_server.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import flower_delivery_server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserService userService;


    private static final JacksonFactory jacksonFactory = new JacksonFactory();
    private static final String CLIENT_ID = "318585476943-cji0njqk1gsa88704e135ln8r70psdr3.apps.googleusercontent.com";

    @Override
    public GoogleIdToken checkToken(String idTokenString) throws GeneralSecurityException, IOException {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jacksonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        // (Receive idTokenString by HTTPS POST)
        GoogleIdToken idToken;
        try {
            idToken = verifier.verify(idTokenString);
        }catch (Exception e) {
            return null;
        }

        if (idToken != null) {
            return idToken;
        } else {
            System.out.println("Invalid ID token.");
            return null;
        }
    }

    //Создаем пользователя в базе, если еще не создан
    @Override
    public User createUserByToken(String token) throws GeneralSecurityException, IOException {
        //userService = new UserServiceImpl();
        if(checkToken(token)!=null){
            GoogleIdToken.Payload payload = checkToken(token).getPayload();
            User user = new User();

            user.setEmail(payload.getEmail());
            user.setLastName((String) payload.get("family_name"));
            user.setFirstName((String) payload.get("given_name"));

            if(userService.getUserByEmail(user.getEmail())!=null){
                user = userService.getUserByEmail(user.getEmail());
            } else {
                user.setRoleID(1);
                user.setUserStatus("for-confirmation");
                user = userService.save(user);
            }
            return user;
        }
        return null;
    }

}
