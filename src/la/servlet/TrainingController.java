package la.servlet;

import la.DAO.DAOException;
import la.DAO.TrainingDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/trainingController")
public class TrainingController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        String state = request.getParameter("action");
        int training_id = Integer.parseInt(request.getParameter("training_id"));
        int trainee_id = Integer.parseInt(request.getParameter("trainee_id"));

        try {
            TrainingDAO dao = new TrainingDAO();
            switch (state) {
                case "join":
                    dao.joinTraining(training_id, trainee_id);
                    break;
                case "cancel":
                    dao.cancelTraining(training_id, trainee_id);
                    break;
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

}
