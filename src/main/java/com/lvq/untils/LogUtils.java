package com.lvq.untils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {

    private static String LOG_PATH = System.getProperty("user.dir")+"/log/";

    public static void log(String msg){
        PrintWriter pw = null;
        try {
            File dir = new File(LOG_PATH);
            //创建目录
            if (!dir.exists()) {
                dir.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String path = LOG_PATH + sdf.format(new Date())+"_log.log";
            dir = new File(path);
            if (!dir.exists()) {
                dir.createNewFile();
            }
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));
            pw.print(msg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pw != null){
                    pw.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void error(Exception exception){
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            File dir = new File(LOG_PATH);
            //创建目录
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String path = LOG_PATH + sdf.format(date)+"_error.log";
            dir = new File(path);
            if (!dir.exists()) {
                dir.createNewFile();
            }
            sw = new StringWriter();
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));
            exception.printStackTrace(pw);
            pw.print(sw.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pw != null){
                    pw.close();
                }
                if (sw != null){
                    sw.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
