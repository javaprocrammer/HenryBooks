
package servlets;

import business.Update;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author Lou Cram
 */
public class InventoryChangedServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "", URL = "/InventoryUpdate.jsp", sql = "";
        int amount =0;
        
        try{
            User u = (User) request.getSession().getAttribute("user");
            Update update = (Update) request.getSession().getAttribute("update");
            Update d = update;
            amount = Integer.parseInt(request.getParameter("amount"));
            if (amount < 0){
                msg += "Inventory Quantity cannot be negative.<br>";
            } else {
                    d.setQuantity(amount);
            }
            
            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is252";
            String dbUser = "root";
            String dbPwd = "advjava";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();

            sql = "UPDATE bookinv SET "
                  + " OnHand = '" + amount + "'" 
                  + " WHERE storeID = '" + u.getStoreID() +"'"
                  + " AND bookID = '" + update.getBookID() + "'";
 
            int rc = s.executeUpdate(sql);
            if (rc == 0) {
                msg += "Error: No records updated. <br>";
            } else if (rc == 1) {
                msg += "Member updated. <br>";
                update = d;
            } else {
                msg += "Warning: " + rc + " records updated!";
            }
        } catch (NumberFormatException e) {
            msg += "Inventory Quantity cannot be empty. Enter a positive"
                    + " whole number<br>";
        } catch(SQLException e) {
            msg += "SQL Error: " + e.getMessage() + "" + sql + "<br>";
        } catch (Exception e) {
            msg += "General Error: " + e.getMessage() + "<br>";
        }
        
        URL = "/InventoryUpdate.jsp";
        
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
