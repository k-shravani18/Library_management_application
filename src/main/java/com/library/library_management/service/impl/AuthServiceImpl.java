package com.library.library_management.service.impl;

import com.library.library_management.model.User;
import com.library.library_management.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

        private IUserRepository userRepository;

        public boolean isValidBasicAuth(String authHeader){
            if(StringUtils.hasText(authHeader)&& authHeader.toLowerCase().startsWith("basic")){
                String base64Credentials = authHeader.substring("Basic ".length()).trim();

                byte[] decodeCredentials = Base64Utils.decodeFromString(authHeader);
                String credentials = new String(decodeCredentials, StandardCharsets.UTF_8);

                final String[] val = credentials.split(":", 2);
                if(val.length == 2 ){
                    String username = val[0];
                    String password = val[1];
                    User user = userRepository.findByUnameAndPass(username, password);
                    if(user != null){
                        return true;
                    }
                }
            }
            return false;
        }
}
