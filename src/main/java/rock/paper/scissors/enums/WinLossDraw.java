package rock.paper.scissors.enums;

/**
 * ジャンケンの勝敗を表すenum
 *
 * ジャンケンの結果を数値で表しており、その数値をenumで表している
 * 例: Result.javaの(userHand - computerHand + 3) % 3 の結果に対応
 */
public enum WinLossDraw {
	Win(2, "おめでとうございます！", "あなたの勝ちです。"), Loss(1, "残念！", "あなたの負けです。"), Draw(0, "残念！", "あいこです。");

	private final int number;
	private final String winLossDrawMessage1;
	private final String winLossDrawMessage2;

	private WinLossDraw(int number, String winLossDrawMessage1, String winLossDrawMessage2) {
		this.number = number;
		this.winLossDrawMessage1 = winLossDrawMessage1;
		this.winLossDrawMessage2 = winLossDrawMessage2;
	}

	public int getNumber() {
		return number;
	}

	public String getWinLossDrawMessage1() {
		return winLossDrawMessage1;
	}

	public String getWinLossDrawMessage2() {
		return winLossDrawMessage2;
	}

	/**
	 * 数値から WinLossDraw（enum）に変換
	 * @param number 勝敗を表す数値 (0:Draw、1:Loss、2:Win)
	 * @return 対応する WinLossDraw
	 */
	public static WinLossDraw fromNumber(int number) {
		for (WinLossDraw wld : values()) {
			if (wld.number == number) {
				return wld;
			}
		}
		throw new IllegalArgumentException("無効な勝敗の数値です：" + number);
	}
}
