
public class Player {
	private char sign;	//X or O or other char which player uses to tick
	public Player(char sign) {
		this.sign=sign;
	}
	void setSign(char sign) {
		this.sign=sign;
	}
	char getSign() {
		return this.sign;
	}
}
