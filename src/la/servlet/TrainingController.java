package la.servlet;

import la.DAO.DAOException;
import la.DAO.TrainingDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trainingController")
public class TrainingController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        String state = request.getParameter("action");
        int training_id = Integer.parseInt(request.getParameter("training_id"));
        int trainee_id = Integer.parseInt(request.getParameter("trainee_id"));

        request.getHeader("Referer");
        RequestDispatcher rd = request.getRequestDispatcher("/trainingList.jsp");

        try {
            TrainingDAO dao = new TrainingDAO();
            switch (state) {
                case "join":
                    dao.joinTraining(training_id, trainee_id);
                    rd.forward(request, response);
                    break;
                case "cancel":
                    dao.cancelTraining(training_id, trainee_id);
                    rd.forward(request, response);
                    break;
            }
        } catch (DAOException | ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
