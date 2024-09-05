package org.kmakrutin.withspringssmstarterbootstrapped;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class LocalSsmBootstrapConfiguration {
    /**
     * Creates override to {@link org.springframework.cloud.aws.autoconfigure.paramstore.AwsParamStoreBootstrapConfiguration}
     * ssmClient bean to talk to localstack local ssm
     */
    @Bean
    AWSSimpleSystemsManagement ssmClient() {
        final String region = Regions.US_EAST_1.getName();
        return AWSSimpleSystemsManagementClient.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", region))
                .build();
    }
}
