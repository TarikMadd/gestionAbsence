package com.ensa.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;

import javax.activation.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import com.ensa.models.Personne;

@Configuration
@EnableBatchProcessing
public class PersonneBatchConfiguration {

    @Value("classPath:/etuduaint.csv")
    private Resource csvResource;

    // Employee is entity class which we have taken for the use case
    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Personne> itemReader,
                   ItemProcessor<Personne, Personne> itemProcessor,
                   ItemWriter<Personne> itemWriter
    ) {

        Step step = stepBuilderFactory.get("step")
                .<Personne, Personne>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("Incrementer")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    //@Value("${input}") Resource resource
    // Pass the resource
    @Bean
    public FlatFileItemReader<Personne> itemReader() {

        FlatFileItemReader<Personne> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(csvResource);
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1); // for first line skip
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<Personne> lineMapper() {

        DefaultLineMapper<Personne> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"nom","prenom","cin","dateNaissance","email","sexe","adresse","avatar_image"});

        BeanWrapperFieldSetMapper<Personne> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Personne.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}
