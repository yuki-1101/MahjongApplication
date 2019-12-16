package servlet;

import java.io.IOException;
import java.util.List;

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

		//セッションスコープから選択された牌のリストを取得する
		String tileName = request.getParameter("tileName");
		String reset = request.getParameter("reset");
		String change = request.getParameter("change");

		HttpSession session = request.getSession();
		SelectedTileCheck stc = new SelectedTileCheck();
		List<String>  selectedTileList = (List<String>) session.getAttribute("selectedTileList");

		if(reset == null) {

					stc.setTehai(tileName, change, selectedTileList);
					selectedTileList = stc.getTehai();
					if(selectedTileList != null) {
						session.setAttribute("selectedTileList", selectedTileList);
					} else {
						session.setAttribute("tsumo", tileName);
					}

		} else {
			session.removeAttribute("selectedTileList");
			session.removeAttribute("tsumo");
		}

		/*if(reset == null) { //リセット処理するか否かの条件式

			if(change != null) {
				int i = Integer.parseInt(change);
				stp.setTehai(tileName);
				selectedTileList.set(i, stp.getTehai());
				session.setAttribute("selectedTileList", selectedTileList);

			} else {

				if(stc.instanceCheck(selectedTileList)) {  //インスタンスの状態の確認(要素数が13以下で値がnullかのチェック)
					stp.setTehai(tileName);
					selectedTileList.add(stp.getTehai());

				} else if(selectedTileList == null){
					Set<String> words = new TreeSet<String>();
					stp.setTehai(tileName);
					selectedTileList.add(stp.getTehai());
					session.setAttribute("selectedTileList", selectedTileList);

				} else {
					session.setAttribute("tsumo", tileName);

				}
			}
		} else {
			session.removeAttribute("selectedTileList");
			session.removeAttribute("tsumo");

		}*\

		/*フォワード*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
