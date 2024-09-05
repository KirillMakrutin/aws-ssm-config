# Structure

* [with-aws-ssm-starter](./with-aws-ssm-starter) is a modern approach using io.awspring.cloud starters and aws sdk v2
* [with-spring-ssm-starter-bootstrapped](./with-spring-ssm-starter-bootstrapped) is a legacy approach using outdated
  bootstrapped org.springframework.cloud starters and aws sdk v1, that requires set env
  AWS_JAVA_V1_DISABLE_DEPRECATION_ANNOUNCEMENT=true

# Localstack

When you run service by `docker-compose up` it will start a localstack with configured service for you. To manage
manipulate
data in AWS service it is better to set up AWS CLI and configure it with the profile '
localstack': `aws configure --profile localstack`,
answer the following questions:

```text
AWS Access Key ID [None]: local
AWS Secret Access Key [None]: local
Default region name [None]: us-east-1
Default output format [None]: json
```

and you are good.

For example, to add SSM config parameter you can run the following query:
`aws ssm put-parameter --profile "localstack" --endpoint-url "http://localhost:4566" --name "/config/ssm-config/my.parameter"  --value "some parameter value" --type "String" --overwrite`