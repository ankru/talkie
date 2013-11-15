package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates reply based on random selection from the initial list of replies
 * 
 * @author Anna Khasanova
 */
public class DefaultReplyGenerator implements ReplyGenerator {

	private final List<String>	answers	= new ArrayList<String>();

	public DefaultReplyGenerator() {
		answers.add(Messages.getString("DefaultReplyGenerator.answer_chaotic_good"));
		answers.add(Messages.getString("DefaultReplyGenerator.answer_neutral_good"));
		answers.add(Messages.getString("DefaultReplyGenerator.answer_true_neutral"));
		answers.add(Messages.getString("DefaultReplyGenerator.answer_lawful_good"));
		answers.add(Messages.getString("DefaultReplyGenerator.answer_lawful_evil"));
		answers.add(Messages.getString("DefaultReplyGenerator.answer_chaotic_evil"));
	}

	@Override
	public String generate() {
		final Random random = new Random();
		final int selected = random.nextInt(answers.size());
		return answers.get(selected);
	}
}
