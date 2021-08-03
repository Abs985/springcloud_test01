package com.northbear;

import java.time.ZonedDateTime;

/**
 * @auther northBear
 * @Description
 * @create 2021/8/3 14:16
 */
public class test {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();//使用时区，在断言after出使用 2021-08-03T14:17:41.466+08:00[Asia/Shanghai]
        System.out.println(now);
    }
}
