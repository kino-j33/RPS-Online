package rock.paper.scissors.model;

import rock.paper.scissors.dto.HandDto;
import rock.paper.scissors.enums.RockPaperScissors;
import rock.paper.scissors.enums.WinLossDraw;

/**
 * ジャンケンの勝敗を判定するクラス
 */
public class Result {
	/**
	 * ユーザーとコンピュータの手から勝敗を判定する
	 *
	 * @param handDto ユーザーとコンピュータの手情報を持つDTO
	 * @return WinLossDraw enumで勝敗を返す（Win / Loss / Draw）
	 */
	public static WinLossDraw judge(HandDto handDto) {
		RockPaperScissors userHand = handDto.getUserHand();
		RockPaperScissors computerHand = handDto.getComputerHand();

		// 勝敗を数値で計算
		// (user - computer + 3) % 3
		// 0:Draw、1:Loss、 2:Win
		int resultNumber = (userHand.getNumber() - computerHand.getNumber() + 3) % 3;

		// 計算結果から WinLossDraw(enum)を返す
		return WinLossDraw.fromNumber(resultNumber);
	}
}