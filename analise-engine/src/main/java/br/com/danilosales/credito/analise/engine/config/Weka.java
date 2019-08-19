package br.com.danilosales.credito.analise.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Configuration
public class Weka {
	
	@Bean
	@Scope("singleton")
	public Instances instances() {
		try {
			DataSource dataSource = new DataSource("analise-credito.arff");
			Instances instances = dataSource.getDataSet();
			if(instances.classIndex() == -1) {
				instances.setClassIndex(instances.numAttributes() -1);				
			}
			
			return instances;
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível carregar o arquivo arff", e);
		}
	}
	
	@Bean
	@Scope("singleton")
	public NaiveBayes naiveBayes() {
		NaiveBayes naiveBayes = new NaiveBayes();
		try {
			naiveBayes.buildClassifier(instances());
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível gerar a tabela de probabilidade");
		}
		return naiveBayes;
	}
	
}
