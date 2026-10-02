package com.user.controller;

import com.user.dto.UserInfoDTO;
import com.user.service.V5StaticWildcardImportUserService;
import java.util.List;

/**
 * P1 - upstream path: controller -> service -> ExternalApi (for Commit Impact path display).
 * Plain class (no Spring dependency) so the sample compiles with javac only.
 */
public class UserInfoController {

    private final V5StaticWildcardImportUserService serviceUser;

    public UserInfoController(V5StaticWildcardImportUserService serviceUser) {
        this.serviceUser = serviceUser;
    }

    public List<UserInfoDTO> listUser(String id) {
        return this.serviceUser.retrieveListUserInfo(id);
    }

    public List<UserInfoDTO> checkUser(String id) {
        return serviceUser.retrieveChkUserInfo(id);
    }
}
