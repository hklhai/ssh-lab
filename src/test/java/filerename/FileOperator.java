package filerename;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ocean lin on 2019/12/5.
 *
 * @author Ocean lin
 */
public class FileOperator {

    private final static String filepath = "E:\\鲁班";
    private final static String ugly = "【巨菜站 www.jucaizhan.com】";
    private final static String normal = "";

    public static void main(String[] args) throws IOException {
        RenameFile(filepath, ugly, normal);
    }

    public static boolean RenameFile(String filepath, String rStr, String newStr) throws IOException {
        try {
            File fileDir = new File(filepath);
            for (File file : fileDir.listFiles()) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String newName = fileName.replace(rStr, newStr);
                    File newFile = new File(filepath, newName);
                    file.renameTo(newFile);
                    System.out.println(filepath + "\\" + fileName + ">>" + filepath + "\\" + newName + "-----" + newFile.exists());
                }
                if (file.isDirectory()) {
                    RenameFile(file.getAbsolutePath(), rStr, newStr);
                }
            }
        } catch (Exception e) {
            System.out.println("错误信息: " + e.getMessage() + "   请确认文件夹是否处在！");
        }
        return true;
    }

}
