package io.adiwave.apifirst.davidedemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@EnableR2dbcAuditing
@Configuration
public class DataAuditConfig {
}
