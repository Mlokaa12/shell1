//لحفظ الكلاس المسؤول عن الأوامر.
import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {

    private File currentDirectory;

    // Constructor: تعيين الدليل الحالي عند بدء البرنامج
    public ShellCommandHandler() {
        this.currentDirectory = new File(System.getProperty("user.dir"));
    }

    // طباعة المسار الكامل للدليل الحالي
    public void printWorkingDirectory() {
        System.out.println("المسار الحالي: " + currentDirectory.getAbsolutePath());
    }

    // عرض محتويات الدليل الحالي
    public void listDirectory() {
        File[] files = currentDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("فشل في قراءة محتويات المجلد.");
        }
    }

    // تغيير الدليل إلى دليل آخر
    public void changeDirectory(String name) {
        File newDirectory = new File(currentDirectory, name);
        if (newDirectory.exists() && newDirectory.isDirectory()) {
            currentDirectory = newDirectory;
            System.out.println("تم تغيير الدليل إلى: " + currentDirectory.getAbsolutePath());
        } else {
            System.out.println("الدليل لا exists أو ليس مجلدًا.");
        }
    }

    // إنشاء دليل جديد
    public void makeDirectory(String name) {
        File newDirectory = new File(currentDirectory, name);
        if (newDirectory.mkdir()) {
            System.out.println("تم إنشاء الدليل بنجاح: " + newDirectory.getAbsolutePath());
        } else {
            System.out.println("فشل في إنشاء الدليل.");
        }
    }

    // إنشاء ملف جديد
    public void createFile(String name) {
        File newFile = new File(currentDirectory, name);
        try {
            if (newFile.createNewFile()) {
                System.out.println("تم إنشاء الملف بنجاح: " + newFile.getAbsolutePath());
            } else {
                System.out.println("الملف موجود بالفعل.");
            }
        } catch (IOException e) {
            System.out.println("حدث خطأ أثناء إنشاء الملف.");
            e.printStackTrace();
        }
    }

    // عرض المساعدة حول الأوامر
    public void printHelp() {
        System.out.println("الأوامر المتاحة:");
        System.out.println("pwd - عرض المسار الحالي");
        System.out.println("ls - عرض محتويات المجلد");
        System.out.println("cd <اسم المجلد> - تغيير الدليل");
        System.out.println("mkdir <اسم المجلد> - إنشاء مجلد");
        System.out.println("create <اسم الملف> - إنشاء ملف");
        System.out.println("exit - للخروج");
    }

    // الحصول على الدليل الحالي
    public File getCurrentDirectory() {
        return currentDirectory;
    }
}

