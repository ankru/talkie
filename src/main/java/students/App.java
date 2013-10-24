package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Anna Khasanova
 */
public class App {

	private static final String	EXIT_WORD	= Messages.getString("App.EXIT_WORD");

	public static void main(final String[] args) {
		final ReplyGenerator replyGenerator = new DefaultReplyGenerator();
		System.out.println(Messages.getString("App.ask_request"));
		try {
			talk(replyGenerator);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		System.out.println(Messages.getString("App.bye"));
	}

	private static void talk(final ReplyGenerator replyGenerator) throws IOException {
		final BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println(Messages.getString("App.can_I_..."));
			final String question = new String(bufferRead.readLine().trim().getBytes("cp1251"));
			if (question.isEmpty()) {
				continue;
			}
			if (isExitCommand(question)) {
				break;
			} else {
				printQuestion(question);
				printAnswer(replyGenerator);
			}
			System.out.println(Messages.getString("App.lets_continue"));
		}
	}

	private static boolean isExitCommand(final String input) {
		return EXIT_WORD.equalsIgnoreCase(input);
	}

	private static void printQuestion(final String question) {
		String questionOut = Messages.getString("App.can_u") + question;
		if (!questionOut.endsWith("?")) {
			questionOut += "?";
		}
		System.out.println(questionOut);
	}

	private static void printAnswer(final ReplyGenerator replyGenerator) {
		System.out.println(replyGenerator.generate());
	}
}
