import java.util.ArrayList;

public class StockDisplay implements StockSource{

    private String selectedTime;
    private String selectedCompany;
    private String selectedValue;

    public StockDisplay(){
        ExcelReader forecast = new ExcelReader();
        forecast.populateStockInfo();
    }


    public void updateMarket(){

    }

    ArrayList<Investor> investors = new ArrayList<>();

    public void addObserver(Investor i){
        investors.add(i);
    }
    public void removeObserver(Investor i){
        investors.remove(i);
    }
    public void notifyObservers(){
        if (investors != null){
            for (Investor i : investors){
                i.notify(selectedTime, selectedCompany, selectedValue);
            }
        }
    }
}
