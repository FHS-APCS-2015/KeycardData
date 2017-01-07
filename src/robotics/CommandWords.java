package robotics;

public class CommandWords {
	public String first, second, third, rest;

	public CommandWords(String first, String second, String third, String rest) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.rest = rest;
	}
	
	public CommandWords(String command) {
		String[] words = command.split(" ");

		if (words.length == 0)
			return;

		first = words[0];
		second = (words.length >= 2) ? words[1] : null;
		third = (words.length >= 3) ? words[2] : null;
		rest = (words.length >= 2) ? command.substring(
				command.indexOf(" ") + 1).trim() : "";
	}
	
	
}
