package rock.paper.scissors.form;

/**
 * ユーザが選択し、formで送られてきた手を保持する
 */
public class HandForm {
	private String hand;

	public HandForm(String hand) {
		super();
		this.hand = hand;
	}

	public String getHand() {
		return hand;
	}
}
