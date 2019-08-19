package br.com.danilosales.credito.analise.engine.service;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilosales.credito.analise.engine.model.AnaliseProposta;
import br.com.danilosales.credito.analise.engine.model.Proposta;
import br.com.danilosales.credito.analise.engine.model.ResultadoAnalise;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class AnaliseDeCreditoService {

	
	@Autowired
	private Instances instances;
	
	@Autowired
	private NaiveBayes naiveBayes;
	
	public ResultadoAnalise analisarProposta(Proposta proposta) {
		
		Instance instance = new DenseInstance(instances.numAttributes()); 
		instance.setDataset(instances);
		instance.setValue(0, proposta.getRenda().doubleValue());
		instance.setValue(1, proposta.getIdade());
		instance.setValue(2, proposta.getEstadoCivil().getCodigo());
		instance.setValue(3, proposta.getQtdDependentes());
		
		
		try {
			double[] probabilidades = naiveBayes.distributionForInstance(instance);
			double maiorProbabiblidade = Arrays.stream(probabilidades).max().getAsDouble();
			
			AnaliseProposta analiseProposta = AnaliseProposta.values()[IntStream.range(0, probabilidades.length)
			                                .filter(i -> maiorProbabiblidade == probabilidades[i])
			                                .findFirst().getAsInt()];
			
			ResultadoAnalise resultadoDTO = new ResultadoAnalise();
			resultadoDTO.setObservacao(analiseProposta.getObservacao());
			resultadoDTO.setStatus(analiseProposta.getStatus());
			
			return resultadoDTO;
			
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao analisar a proposta", e);
		}
		
	}
	
}
