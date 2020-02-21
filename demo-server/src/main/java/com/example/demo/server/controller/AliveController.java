package com.example.demo.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-03
 * Time:00:31
 * ------------------------------------
 * Desc:
 */
@RestController
@RequestMapping("/monitor/alive")
public class AliveController {
    @GetMapping(value = "/check")
    public String isAlive(){
        return "Alive!";
    }
}
