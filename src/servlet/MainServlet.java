package servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SelectedTileCheck;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//jspからの値をGetする
		String tileName = request.getParameter("tileName");
		String reset = request.getParameter("reset");
		String change = request.getParameter("change");

		//セッションスコープから選択された牌のリストを取得する
		HttpSession session = request.getSession();
		SelectedTileCheck  stc = (SelectedTileCheck) session.getAttribute("stc");

		if(stc == null) {
			stc = new SelectedTileCheck();
		}

		if(reset == null) {
			stc.setTehai(tileName, change);
			Collections.sort(stc.getTehaiImageList());
			session.setAttribute("stc", stc);

		} else {
			session.removeAttribute("stc");
		}

		/*フォワード*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
