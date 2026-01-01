package rock.paper.scissors.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import rock.paper.scissors.constant.Constant;
import rock.paper.scissors.enums.RockPaperScissors;

/**
 * ユーザが手を選択していない場合、PlayInitにフォワードさせるフィルタ
 */
public class HandSelectionCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String hand = request.getParameter("hand");
		if (hand == null || hand.isBlank()) {
			forwardOnInvalidValue(Constant.ERR_MESSAGE, request, response);
			return;

		} else {
			try {
				RockPaperScissors.fromStringToHand(hand);
				filterChain.doFilter(servletRequest, servletResponse);
			} catch (IllegalArgumentException e) {
				forwardOnInvalidValue(e.getMessage(), request, response);
			}
		}
	}

	private void forwardOnInvalidValue(String errMessage, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errMessage", errMessage);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/PlayInit");
		dispatcher.forward(request, response);
	}
}