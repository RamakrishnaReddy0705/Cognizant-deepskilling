public class ObserverTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket("TCS");

        Observer mobileUser = new MobileApp("Ramakrishna");
        Observer webUser = new WebApp("Reddy");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        System.out.println("Updating stock price to 3500");
        stockMarket.setPrice(3500);

        System.out.println("\nRemoving WebApp observer");

        stockMarket.deregisterObserver(webUser);

        System.out.println("\nUpdating stock price to 3700");
        stockMarket.setPrice(3700);
    }
}