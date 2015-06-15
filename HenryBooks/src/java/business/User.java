
package business;

/*
 * @author crambook
 */

public class User {
    private int UserID, StoreID, Password, PwordAttempt;
    private String UserName, AdminLevel;
    
    public User(){
        UserID = 0;
        StoreID = 0;
        Password = 0;
        PwordAttempt = 0;
        UserName = "";
        AdminLevel = "";
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getAdminLevel() {
        return AdminLevel;
    }

    public void setAdminLevel(String AdminLevel) {
        this.AdminLevel = AdminLevel;
    }

    public int getPwordAttempt() {
        return PwordAttempt;
    }

    public void setPwordAttempt(int PwordAttempt) {
        this.PwordAttempt = PwordAttempt;
    }
    
    public boolean isAuthenticated(){
        boolean result = false;
        if(Password > 0){
            if (Password == PwordAttempt){
                result = true;
            }
        }
        return result;
    }
}
