
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("action") == null){
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;

        }else if(request.getParameter("action").equals("logout")){
            String loggedOut = "You have successfully logged out";
            request.setAttribute("message", loggedOut);

            session.invalidate();

            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
                return;

         }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        if(request.getParameter("action").equals("register")){
        
            if(request.getParameter("username")== null || request.getParameter("username").equals("") ){
                String error = "Please enter username";
                request.setAttribute("message", error);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

                return;
            }else{
                String username = request.getParameter("username");
                session.setAttribute("username", username);
            }
            
        } 
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

  
}
