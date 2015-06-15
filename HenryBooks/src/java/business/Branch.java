
package business;

/*
 * @author Lou Cram
 */

public class Branch {
    private int StoreID;
    private String StoreAddr, StoreName;
    
    public Branch(){
        StoreID = 0;
        StoreAddr = "";
        StoreName = "";
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
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
