package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.application.UserService;
import com.bnpparibas.bddf.projet.media.exposition.dto.UserDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.UserLightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

        @RequestMapping(method= RequestMethod.GET, path={"/users"})
        public List<UserLightDTO> listAllUsers(){
            return UserAdapter.adaptToUserLightDTOList(this.userService.listAll());
        }

        @RequestMapping(method = RequestMethod.GET, path = {"/users/{userId}"})
        public UserDTO detailUser(@PathVariable("userId") Long userId ){
            return UserAdapter.adaptToUserDTO(this.userService.obtain(userId));
        }

        @RequestMapping(method = RequestMethod.POST, path = {"/users"})
        @ResponseStatus(HttpStatus.CREATED)
        public void createUser(@Valid @RequestBody UserDTO userDTO) {
            this.userService.create(UserAdapter.transformToUser(userDTO));
        }

        @RequestMapping(method = RequestMethod.PUT, path = {"/users/{userId}"})
        public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserDTO userDTO) {
            this.userService.update(userId, UserAdapter.transformToUser(userDTO));
        }

        @RequestMapping(method = RequestMethod.DELETE, path = {"/users/{userId}"})
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removeUser(@PathVariable("userId") Long userId) {
            this.userService.remove(userId);
        }

}
