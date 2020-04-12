import java.io.*;

public class Copy {

    public void copyText(String sourcePath, String destinationPath) {
        File file = new File(sourcePath);
        if (file.exists()) {
            System.out.println("File's length : " + file.length());
            readText(file, destinationPath);
        }
    }

    public void readText(File file, String destinationPath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            String content = "";
            while ((line = reader.readLine()) != null) {
                content += line+"\n";
            }
            reader.close();
            writeToDes(destinationPath, content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeToDes(String destinationFile, String content) {

        File desFile = new File(destinationFile);
        if (!desFile.exists()) {
            try {
                desFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
//            FileWriter writer = new FileWriter(desFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desFile));
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
