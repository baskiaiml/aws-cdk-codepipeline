package com.awscdk.practice.codepipeline;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class AwsCDKCodePipelineApp {
    public static void main(final String[] args) {
        App app = new App();

        new AwsCDKCodePipelineStack(app, "AwsCDKCodePipelineStack", StackProps.builder()
                .env(Environment.builder()
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .region(System.getenv("CDK_DEFAULT_REGION"))
                        .build())
                .build());

        app.synth();
    }
}

