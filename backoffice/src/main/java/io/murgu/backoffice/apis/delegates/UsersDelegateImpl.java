package io.murgu.backoffice.apis.delegates;

import io.murgu.backoffice.apis.UsersApiDelegate;
import io.murgu.backoffice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersDelegateImpl implements UsersApiDelegate {

    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setUserName("created-user");
        user.setRole("administrator");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
