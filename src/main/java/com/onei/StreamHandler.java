package com.onei;


import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import io.micronaut.aws.alexa.builders.StandardSkillBuilderProvider;


public class StreamHandler extends SkillStreamHandler {

    public StreamHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        Skill skillBuilder = new StandardSkillBuilderProvider().getSkillBuilder().addRequestHandler(new LaunchRequestHandler()).build();
        return skillBuilder;
    }

}