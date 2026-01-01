package rock.paper.scissors.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import rock.paper.scissors.enums.RockPaperScissors;

/**
 * ジャンケンの初期化を行い、プレイ画面にフォワード
 */
@WebServlet("/PlayInit")
public class PlayInit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("rockPaperScissors", RockPaperScissors.values());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/play.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
