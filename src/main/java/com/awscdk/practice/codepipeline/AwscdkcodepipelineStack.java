package com.awscdk.practice.codepipeline;

import java.util.List;

import com.awscdk.practice.codepipeline.constants.ProjectConstants;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.pipelines.CodeBuildStep;
import software.amazon.awscdk.pipelines.CodePipeline;
import software.amazon.awscdk.pipelines.CodePipelineSource;
import software.constructs.Construct;


public class AwscdkcodepipelineStack extends Stack {
	public AwscdkcodepipelineStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public AwscdkcodepipelineStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        
       
        // The basic pipeline declaration. This sets the initial structure
        // of our pipeline
        final CodePipeline pipeline = CodePipeline.Builder.create(this, "CodePipeline")
                .pipelineName("WorkshopPipeline")
                
                .synth(CodeBuildStep.Builder.create("SynthStep")
                        .input(CodePipelineSource.gitHub(ProjectConstants.GIT_REPO_NAME,ProjectConstants.GIT_REPO_MASTER_BRANCH))
                              
                .installCommands(List.of(
                                "npm install -g aws-cdk"   // Commands to run before build
                        ))
                 .commands(List.of(
                                "mvn package"// Language-specific build commands
                        ))
                 .build())
                
                .build();
    } 
}
