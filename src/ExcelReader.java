import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

public class ExcelReader{

    private int currentTime;

    Map<String, Map<String, String>> time = new HashMap<>();
    public ExcelReader(){
        currentTime = 0;
    }

    private String readFile(String fileName){
        try {
            String content = Files.readString(Path.of(fileName));
            System.out.println(content);
            return content;
        } catch (IOException e) {
            return "";
        }
    }

    public void populateStockInfo(){
        String[] dataSets = readFile("events.cvs").split("\\|");
        for (int i = 0; i < dataSets.length; i++){
            String[] currentData = dataSets[i].split(" ");
            if (time.containsKey(currentData[1])){
                time.get(currentData[1]).put(currentData[0], currentData[2]);
            }
            else{
                time.put(currentData[1], new HashMap<String, String>());
                time.get(currentData[1]).put(currentData[0], currentData[2]);
            }
        }
    }

    public String getStockInfo(String stockName, String currentTime){
        return time.get(stockName).get(currentTime);
    }

    public String getCurrentTime(){
        return String.valueOf(currentTime);
    }

    public ArrayList<String> updateTime(){
        ArrayList<String> returned = new ArrayList<>();
        currentTime++;
        for (String key : time.keySet()) {
            if (time.get(key).containsKey(String.valueOf(currentTime))){
                returned.add(key);
            }
        }
        return returned;
    }
}

