package com.memorynotfound.dao.security;

import com.memorynotfound.model.security.User;

/**
 * Created by : Ron Rith
 * Create Date: 01/21/2018.
 */
public interface UserDAO {
    User findByUserName(String username);
}
