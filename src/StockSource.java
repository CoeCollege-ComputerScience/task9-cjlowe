public interface StockSource {
    void addObserver(Investor i);
    void removeObserver(Investor i);
    void notifyObservers();
}
