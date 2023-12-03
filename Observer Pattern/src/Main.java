import java.util.ArrayList;

class Stock{
    String symbol;
    float price;
    ArrayList<Investor> investors;
    public Stock(String symbol, float price){
        this.symbol = symbol;
        this.price = price;
        investors = new ArrayList<>();
    }
    public void registeredInvestor(Investor investor){
        investors.add(investor);
    }
    public void unregisteredInvestor(Investor investor){
        investors.remove(investor);
    }
    public void updatePrice(float price){
        this.price = price;
    }
    public String getSymbol(){
        return symbol;
    }
    public float getPrice() {
        return price;
    }
    public String getInvestors() {
        String result = "";
        for(Investor investor:investors){
            String word = "";
            word = "[" + investor.getName() + "]";
            result += word;
        }
        return result;
    }
}

class Investor{
    String name;
    ArrayList<Stock> stocks;
    public Investor(String name){
        this.name = name;
        stocks = new ArrayList<>();
    }
    public void registeredStock(Stock stock){
        stocks.add(stock);
    }
    public void unregisteredStock(Stock stock){
        stocks.remove(stock);
    }
    public String getName(){
        return name;
    }
    public String getStocks(){
        String result = "";
        for(Stock stock:stocks){
            String word = "";
            word = "[" + stock.getSymbol() + ", " + stock.getPrice() + "]";
            result += word;
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        Stock kaspi = new Stock("Kaspi", 200.0f);
        Stock halyk_bank = new Stock("Halyk Bank", 176.6f);
        Stock jusan = new Stock("Jusan", 400.6f);

        System.out.println();
        Investor nurbol = new Investor("Nurbol Alimkulov");
        Investor timur = new Investor("Timur Panomarenko");
        Investor neo = new Investor("Neo Anderson");
        nurbol.registeredStock(kaspi);
        kaspi.registeredInvestor(nurbol);
        System.out.println("Nurbol's stocks: " + nurbol.getStocks());
        System.out.println("Kaspi's investors: " + kaspi.getInvestors());

        System.out.println();
        System.out.println("Adding price for Kaspi");
        kaspi.updatePrice(500.0f);
        System.out.println("Nurbol's stocks: " + nurbol.getStocks());
        System.out.println("Kaspi's investors: " + kaspi.getInvestors());

        System.out.println();
        timur.registeredStock(halyk_bank);
        halyk_bank.registeredInvestor(timur);
        timur.registeredStock(jusan);
        jusan.registeredInvestor(timur);
        System.out.println("Timur's stocks: " + timur.getStocks());
        System.out.println("Kaspi's investors: " + kaspi.getInvestors());
        System.out.println("Jusan's investors: " + jusan.getInvestors());
        System.out.println("Halyk bank's investors: " + halyk_bank.getInvestors());

        System.out.println();
        System.out.println("Removing Jusan stock: ");
        timur.unregisteredStock(jusan);
        jusan.unregisteredInvestor(timur);
        System.out.println("Timur's stocks: " + timur.getStocks());
        System.out.println("Kaspi's investors: " + kaspi.getInvestors());
        System.out.println("Jusan's investors: " + jusan.getInvestors());
        System.out.println("Halyk bank's investors: " + halyk_bank.getInvestors());
    }
}