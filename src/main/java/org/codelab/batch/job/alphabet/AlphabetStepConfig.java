package org.codelab.batch.job.alphabet;

import org.codelab.batch.common.Const;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlphabetStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean(name=Const.STEP_ALPHABET)
    public Step step() {
		return stepBuilderFactory.get(Const.STEP_ALPHABET)
				.<String,String>chunk(1)
				.reader(new AlphabetReader())
				.processor(new UpperCaseProcessor())
				.writer(new AlphabetWriter())
				.build();
	}
}