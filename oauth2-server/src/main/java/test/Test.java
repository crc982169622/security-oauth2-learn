package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: chenrencun
 * @Date: 2019/11/25 15:39
 * @Description: 描述
 */
public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("secret"));
    }
}
