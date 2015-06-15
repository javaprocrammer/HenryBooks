
package servlets;

import business.Branch;
import business.Inventory;
import business.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author Lou Cram
 */

public class InventoryDisplayServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msg = "", URL = "/StoreSelection.jsp", sql = "";
        User u = (User) request.getSession().getAttribute("user");
        String storeid = request.getParameter("storeid");
        try{
            Inventory i;            
                       
            sql = "SELECT bookinv.storeID, bookinv.bookID, booklist.title, " +
                  " booklist.price, bookinv.OnHand \n" +
                  " FROM bookinv, booklist \n" +
                  " WHERE (bookinv.bookID = booklist.bookID) " +
                  " AND (bookinv.storeID = '" + storeid + "')" +
                  " ORDER BY bookID";
                                
            ArrayList<Inventory> inv = new ArrayList<Inventory>();
            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is252";
            String dbUser = "root";
            String dbPwd = "advjava";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();
            
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                i = new Inventory();
                i.setStoreID(r.getInt("storeID"));
                i.setBookID(r.getString("bookID"));
                i.setTitle(r.getString("title"));
                i.setPrice(r.getDouble("price"));
                i.setQuantity(r.getInt("OnHand"));
                inv.add(i);                
            }
            if (inv.size() > 0){
                URL = "/ViewInventory.jsp";
                request.getSession().setAttribute("inv", inv);
            } else{
                msg = "No inventory to display. <br>";
            }
        } catch (SQLException e) {
            msg += "SQL Error: " + e.getMessage() + "" + sql + "<br>";
        } catch(Exception e){
            msg += "Error: " + e.getMessage();
        }
        
        try {
            Branch b;
            //db connection data elements
            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is252";
            String dbUser = "root";
            String dbPwd = "advjava";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();

            sql = "SELECT * FROM stores "
                    + " WHERE StoreID = '" + u.getStoreID() + "'";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                b = new Branch();
                b.setStoreName(r.getString("StoreName"));
                b.setStoreAddr(r.getString("StoreAddr"));
                request.getSession().setAttribute("branch", b);
            } 
        } catch (SQLException e) {
            msg += "SQL Error: " + e.getMessage() + "" + sql + "<br>";
        } catch (Exception e) {
            msg += "General Error: " + e.getMessage() + "<br>";
        }
        
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
