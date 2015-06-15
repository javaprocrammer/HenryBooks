

package servlets;

import business.Store;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
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

public class LogonServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String msg = "", URL = "/Logon.jsp", sql = "";
        int empid = 0, pwordattempt = 0;
        User u;
        
        try {
            empid = Integer.parseInt(request.getParameter("empid"));
            pwordattempt = Integer.parseInt(request.getParameter("password"));

            //db connection data elements
            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is252";
            String dbUser = "root";
            String dbPwd = "advjava";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();

            sql = "SELECT * FROM users "
                    + " WHERE UserID = '" + empid + "'";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                u = new User();
                u.setUserID(r.getInt("UserID"));
                u.setPassword(r.getInt("UserPassword"));
                u.setPwordAttempt(pwordattempt);
                if(!u.isAuthenticated()){
                    msg += "Unable to Authenticate.<br>";
                } else {
                    u.setUserName(r.getString("UserName"));
                    u.setStoreID(r.getInt("StoreID"));
                    u.setAdminLevel(r.getString("AdminLevel"));
                    msg += "Authenticated!<br>";
                    URL = "/StoreSelection.jsp";
                }
                request.getSession().setAttribute("user", u);
            } else {
                msg += "No data returned for user: " + empid + "<br>";
            }
        } catch (SQLException e) {
            msg += "SQL Error: " + e.getMessage() + "" + sql + "<br>";
        } catch (Exception e) {
            msg += "General Error: " + e.getMessage() + "<br>";
        }
        request.setAttribute("msg", msg);
               
        ArrayList<Store> stores = new ArrayList<Store>();
        try{
            String dbURL = "jdbc:mysql://localhost:3306/henrybooks_is252";
            String dbUser = "root";
            String dbPwd = "advjava";
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
            Statement s = conn.createStatement();

            sql = "SELECT * FROM stores ORDER BY StoreName";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                Store st = new Store();
                st.setStoreID(r.getInt("StoreID"));
                st.setStoreName(r.getString("StoreName"));
                st.setStoreAddr(r.getString("StoreAddr"));
                st.setStoreEmp(r.getInt("StoreEmp"));
                stores.add(st);
            }
            if (stores.size() > 0){
                URL = "/StoreSelection.jsp";
                request.getSession().setAttribute("stores", stores);
            } else{
                msg = "No stores recovered from the stores table. <br>";
            }
        } catch (SQLException e){
            msg = "SQL Error: "  + e.getMessage() + "<br>";
        } catch (Exception e){
            msg = "General Error: " + e.getMessage() + "<br>";
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
