package services;

public  class ATMValue {
	private int total = 0;
	private int fifties = 0;
	private int twenties = 0;
	private int tens = 0;
	private int fives = 0;
	private String message = null;

	public ATMValue(){
	}

	public int getBalance() {
		return total;
	}

	public void setTotal(int _total) {
		total = _total;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int _fifties) {
		fifties = _fifties;
	}

	public int getTwenties() {
		return twenties;
	}

	public void setTwenties(int _twenties) {
		twenties = _twenties;
	}

	public int getTens() {
		return tens;
	}

	public void setTens(int _tens) {
		tens = _tens;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int _fives) {
		fives = _fives;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String _message) {
		message = _message;
	}
}
