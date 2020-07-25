package com.ggs.exam.tools;

import java.util.UUID;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 15:56
 */
public class ExamUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
