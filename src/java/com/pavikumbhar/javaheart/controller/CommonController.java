/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.controller;

import com.pavikumbhar.javaheart.common.controller.MasterController;
import com.pavikumbhar.javaheart.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pavikumbhar
 */
public class CommonController {
    
}

@RestController
@RequestMapping("/user/")
 class UserController extends MasterController<User, Long>{
    
}
