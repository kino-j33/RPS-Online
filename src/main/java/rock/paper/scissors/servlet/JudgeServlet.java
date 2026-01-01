package rock.paper.scissors.servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import rock.paper.scissors.dto.HandDto;
import rock.paper.scissors.enums.RockPaperScissors;
import rock.paper.scissors.enums.WinLossDraw;
import rock.paper.scissors.form.HandForm;
import rock.paper.scissors.model.Result;

/**
 * ユーザーのジャンケンの手を受け取り、コンピュータの手と比較して勝敗を判定し、
 * 結果画面にフォワードするサーブレット
 */
@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {

	private static final Random random = new Random();

	/**
	 * 1.ユーザーの手を取得
	 * 2.コンピュータの手をランダム生成
	 * 3.勝敗判定
	 * 4.JSP に結果を渡して表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ユーザーが選択した手を取得し、フォームに格納
		String hand = request.getParameter("hand");
		HandForm handForm = new HandForm(hand);

		try {
			// HandDto にユーザーとコンピュータの手をセット
			HandDto handDto = new HandDto(
					RockPaperScissors.fromStringToHand(handForm.getHand()),
					RockPaperScissors.fromNumberToHand(random.nextInt(3)));

			// 勝敗判定
			WinLossDraw wld = Result.judge(handDto);

			request.setAttribute("handDto", handDto);
			request.setAttribute("wld", wld);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result.jsp");
			dispatcher.forward(request, response);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

			String errMessage = "下記から正しい手を選択してください";
			request.setAttribute("errMessage", errMessage);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/PlayInit");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
