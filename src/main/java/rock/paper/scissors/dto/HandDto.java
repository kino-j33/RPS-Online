package rock.paper.scissors.dto;

import rock.paper.scissors.enums.RockPaperScissors;

/**
 * ユーザーとコンピュータの手を保持する
 */
public class HandDto {
	private final RockPaperScissors userHand;
	private final RockPaperScissors computerHand;

	public HandDto(RockPaperScissors userHand, RockPaperScissors computerHand) {
		this.userHand = userHand;
		this.computerHand = computerHand;
	}

	public RockPaperScissors getUserHand() {
		return userHand;
	}

	public RockPaperScissors getComputerHand() {
		return computerHand;
	}
}
