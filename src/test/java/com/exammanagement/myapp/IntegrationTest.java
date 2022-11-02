package com.exammanagement.myapp;

import com.exammanagement.myapp.ExamManagementApp;
import com.exammanagement.myapp.config.AsyncSyncConfiguration;
import com.exammanagement.myapp.config.EmbeddedElasticsearch;
import com.exammanagement.myapp.config.EmbeddedKafka;
import com.exammanagement.myapp.config.EmbeddedMongo;
import com.exammanagement.myapp.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { ExamManagementApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedMongo
@EmbeddedElasticsearch
@EmbeddedKafka
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
