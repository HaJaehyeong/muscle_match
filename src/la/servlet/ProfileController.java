package la.servlet;

import la.DAO.DAOException;
import la.DAO.TraineeDAO;
import la.DAO.TrainingDAO;
import la.bean.TraineeBean;
import la.bean.TrainingBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/profileController")
public class ProfileController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("trainee_id"));
        try {
            TraineeDAO dao = new TraineeDAO();
            TraineeBean tb = dao.findByTraineeId(id);
            request.setAttribute("Trainee", tb);

            TrainingDAO trainDao = new TrainingDAO();
            List<TrainingBean> trainingBean = trainDao.findTrainingBytrainee(id);
            request.setAttribute("Training", trainingBean);

            List<TrainingBean> joinTrainingBean = trainDao.findJoinedTrainingByTrainee(id);
            request.setAttribute("JoinTraining", joinTrainingBean);

            RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

}

