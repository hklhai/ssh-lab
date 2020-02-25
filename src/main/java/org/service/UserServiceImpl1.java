package org.service;

import org.annotation.MyService;

@MyService("AA")
public class UserServiceImpl1 implements UserService {

    @Override
    public void find() {
        System.out.println("service");
    }

}
