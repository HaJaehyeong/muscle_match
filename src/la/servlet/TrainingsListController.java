package la.servlet;

import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import la.bean.TraineeBean;
import la.bean.TrainingBean;
import la.DAO.DAOException;
import la.DAO.TraineeDAO;
import la.DAO.TrainingDAO;

@WebServlet("/TrainingsListController")
public class TrainingsListController {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //モデルを使って全トレーニングを表示する
        try {

            request.setCharacterEncoding("UTF-8");

            //パラメータの解析
            //TODO パラメータは変更する
            String action = request.getParameter("action");
            //モデルのDAOを生成
            TrainingDAO dao = new TrainingDAO();

            //パラメータなしの場合は全レコード表示
            if(action == null || action.length() == 0){
                List<TrainingBean> list = dao.findAllTraining();
                //Listをリクエストコープに入れてJSPへフォワードする
                request.setAttribute("items", list);
                gotoPage(request, response, "/trainingList.jsp");
            }
            //三つのパラメータから検索フィルターをかけた結果を表示
            //TODO パラメータは変更する
            else if(action.equals("search")){
                //String name = request.getParameter("name");
                int muscleCategory = Integer.parseInt(request.getParameter("muscle"));
                int area = Integer.parseInt(request.getParameter("area"));
                String date = request.getParameter("date");


                //検索条件に引っかかるレコードの表示
                //List<TrainingBean> list = dao.findTrainingByfilter(muscleCategory, area, date);
                //request.setAttribute("items", list);
                //Listをリクエストスコープに入れてJSPへフォーワードする
                gotoPage(request, response, "/trainingList.jsp");

            } else{
                request.setAttribute("message", "正しく操作してください");
                //TODO errInternal作る
                gotoPage(request, response, "/errInternal.jsp");
            }

        }catch (DAOException e){
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました");
            gotoPage(request, response, "/errInternal.jsp");
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException,
            IOException{
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request, response);


    }
}
