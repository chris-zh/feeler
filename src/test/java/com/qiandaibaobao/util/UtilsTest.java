package com.qiandaibaobao.util;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by chris.zhang on 16-6-27.
 */
public class UtilsTest {
    @Test
    public void writeFile() throws Exception {
        Utils.writeFile(new File("D:\\My Documents\\桌面\\T1xkVdXlRqXXXXXXXX.jpg"),"F:\\feeler\\userfiles\\text.jpg");
    }

}