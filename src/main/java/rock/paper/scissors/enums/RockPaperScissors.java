package rock.paper.scissors.enums;

import rock.paper.scissors.constant.Constant;

/**
 * ジャンケンの手を表す enum
 */
public enum RockPaperScissors {
	// @formatter:off
	  Rock(      0,      "rock",     "グー",   "/img/RPS_Rock.png")
	, Scissors( 1,     "scissors", "チョキ", "/img/RPS_Scissors.png")
	, Paper(     2,     "paper",    "パー",   "/img/RPS_Paper.png");
	// @formatter:on

	private final int number;
	private final String hand;
	private final String name;
	private final String url;

	RockPaperScissors(int number, String hand, String name, String url) {
		this.number = number; //   勝敗計算用の番号 (0～2)
		this.hand = hand; //           パラメータとの識別用文字列
		this.name = name; //         表示用の日本語名
		this.url = url; //                  画像のパス
	}

	public int getNumber() {
		return number;
	}

	public String getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * パラメータの値からRockPaperScissors(enum)を返す
	 * @param hand
	 * @return RockPaperScissors(enum)
	 */
	public static RockPaperScissors fromStringToHand(String hand) {
		for (RockPaperScissors rps : RockPaperScissors.values()) {
			if (rps.getHand().equals(hand)) {
				return rps;
			}
		}
		throw new IllegalArgumentException(Constant.ERR_MESSAGE);
	}

	/**
	 * 数値からRockPaperScissors(enum)を返す
	 * @param hand
	 * @return RockPaperScissors(enum)
	 */
	public static RockPaperScissors fromNumberToHand(int hand) {
		for (RockPaperScissors rps : RockPaperScissors.values()) {
			if (rps.getNumber() == hand) {
				return rps;
			}
		}
		throw new IllegalArgumentException(Constant.ERR_MESSAGE);
	}
}
