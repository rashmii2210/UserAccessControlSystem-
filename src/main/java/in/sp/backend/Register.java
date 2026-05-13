package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String name     = req.getParameter("name");
        String email    = req.getParameter("email");
        String password = req.getParameter("password");
        String gender   = req.getParameter("gender");
        String city     = req.getParameter("city");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:4306/wbjp_microproject", "root", "");

            String query = "INSERT INTO register (name, email, password, gender, city) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setString(5, city);

            int i = ps.executeUpdate();

            resp.setContentType("text/html");
            if (i > 0) {
                out.print("<h3>User Registered Successfully</h3>");
            } else {
                out.print("<h3>User Not Registered due to some error</h3>");
            }

            RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
            rd.include(req, resp);

        } catch (Exception e) {
            resp.setContentType("text/html");
            out.print("<h3>Exception occurred: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/Register.jsp");
            rd.include(req, resp);
        }
    }
}
