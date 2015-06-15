
package business;

/*
 * @author Lou Cram
 */

public class Inventory {
    private int StoreID, Quantity;
    private double Price;
    private String BookID, Title, StoreAddr, StoreName;
    
    public Inventory(){
        StoreID = 0;
        Quantity = 0;
        Price = 0;
        BookID = "";
        Title = "";
        StoreAddr = "";
        StoreName = "";
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getStoreAddr() {
        return StoreAddr;
    }

    public void setStoreAddr(String StoreAddr) {
        this.StoreAddr = StoreAddr;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }
}
