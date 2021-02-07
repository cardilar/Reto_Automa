package com.choucair.formacion;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

 

import utilidades.FeatureOverright;

 

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

 

public class RunnerTags {
    
    @Before
    public void test() {
        
        try { 
            System.out.println("Inicio Test");
            FeatureOverright.overrideFeatureFiles("src/test/resources/features"); 
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
            
        
    }
    
    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = "src/test/resources/features/",
    tags = {"@CasoExitoso2"},
    glue = "com.choucair.formacion")
    
    public class testRunner {
        
    }
    
    @Test
    public void subRunner() throws Exception {
        
        System.out.println("Medio");        
        JUnitCore.runClasses(testRunner.class);
        
    }
    
    @After
    public void fin() {
        
        System.out.println("fin");
        
    }

 

}
