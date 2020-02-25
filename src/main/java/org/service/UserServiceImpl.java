package org.service;


import org.annotation.MyService;

@MyService("bb")
public class UserServiceImpl implements UserService {




    @Override
    public void find() {
        System.out.println("service");

    }


}
