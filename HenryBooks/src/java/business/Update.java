
package business;

/*
 * @author Lou Cram
 */

public class Update {
    private int Quantity, StoreID;
    private String Title, Author, BookID;
    
    public Update(){
        Quantity = 0;
        StoreID = 0;
        BookID = "";
        Title = "";
        Author = "";
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
}
