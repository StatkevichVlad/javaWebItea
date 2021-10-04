package homeworkLesson06;

public class TextGenerator {
	private StringBuilder text;

	public String generateBigText() {
		text = new StringBuilder();
		for (int i = 0; i <= 1000000; i++) {
			text.append(i + "-");
		}
		return text.toString();
	}
	
}

