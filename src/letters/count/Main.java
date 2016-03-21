package letters.count;

public class Main {

	public static void main(String[] args) {
		LetterFrequency letter = new LetterFrequency();
		letter.calcLetterFrequency("d:/ruslan/english.txt");
		letter.printLetters();
	}

}
