package com.tianyin.common.controller;

import java.io.File;

import com.lollipop.candy.common.utils.UuidUtils;

/**
 * BaseController
 * @author tianyin
 *
 */
public class BaseController {

    public static void main(String[] args) {
        File file = new File("E://003");
        String toRootFilePath = "D://008//";
        if(file.isDirectory()) {
            updateFileName(file, toRootFilePath);
        }
    }

    private static void updateFileName(File file, String toRootFilePath) {
        File[] files = file.listFiles();
        for(int i = 0; i < files.length; i++) {
            File childFile =files[i];
            if(childFile.isDirectory()) {
                String toChildRootFilePath = toRootFilePath + "//" + UuidUtils.getUUID();
                updateFileName(childFile, toChildRootFilePath);
            }else {
                String fromName = childFile.getName();
                int index;
                index = fromName.indexOf(".");
                String fileName = "";
                String suffix = "";
                String newFileName = "";
                if(index < 0) {
                    fileName = fromName;
                    newFileName = UuidUtils.getUUID();
                }else {
                    fileName = fromName.substring(0, index);
                    suffix = fromName.substring(index + 1);
                    newFileName = UuidUtils.getUUID() + "." + suffix;
                }
                File tofile = new File(toRootFilePath + "//" + newFileName);
                if (!tofile.getParentFile().exists()) {
                    tofile.getParentFile().mkdirs();
                }
                childFile.renameTo(tofile);
                if(index < 0) {
                    System.out.println(fileName + "   =======>>>>>>>   " + newFileName);
                }else {
                    System.out.println(fileName + "." + suffix + "   =======>>>>>>>   " + newFileName);
                }
            }
        }
    }
}
