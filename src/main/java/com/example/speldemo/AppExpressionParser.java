package com.example.speldemo;

import com.example.speldemo.model.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1  = parser.parseExpression("'Hello World'");
        String message = (String) exp1.getValue();
        System.out.println(message);

        Expression exp2  = parser.parseExpression("'Hello World'.length()");
        System.out.println(exp2.getValue());

        exp2  = parser.parseExpression("'Hello World'.length()*10");
        System.out.println(exp2.getValue());

        exp2  = parser.parseExpression("'Hello World'.length() > 10");
        System.out.println(exp2.getValue());

        exp2  = parser.parseExpression("'Hello World'.length() > 10 and 'Hello World'.length() < 20");
        System.out.println(exp2.getValue());

        StandardEvaluationContext ec1 = new StandardEvaluationContext();
        ec1.setVariable("greeting", "Hello USA");
        ec1.setVariable("MDP", "Medicaid Drug Program");

        String msg = (String) parser.parseExpression("#greeting.substring(6)").getValue(ec1);
        System.out.println(msg);
        System.out.println(parser.parseExpression("#MDP").getValue(ec1));
        System.out.println(parser.parseExpression("#MDP.length()").getValue(ec1));

        //Set up User bean
        //Use parser to set values in user object
        User user = new User();
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);
        //parser.parseExpression("country").setValue(userContext, parser.parseExpression("#greeting.substring(6)").getValue(ec1));
        parser.parseExpression("country").setValue(userContext, "UK");
        parser.parseExpression("language").setValue(userContext, "es");
        parser.parseExpression("timeZone").setValue(userContext, "Great Britain/London");
        parser.parseExpression("age").setValue(userContext, 50);
        parser.parseExpression("name").setValue(userContext, "Fred");
        System.out.println(user);


        //systemProperties predefined object
        StandardEvaluationContext propsContext = new StandardEvaluationContext();
        propsContext.setVariable("systemProperties", System.getProperties());
        Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
        parser.parseExpression("country").setValue(userContext, expCountry.getValue(propsContext));
        Expression expLanguage= parser.parseExpression("#systemProperties['user.language']");
        parser.parseExpression("language").setValue(userContext, expLanguage.getValue(propsContext));
        Expression expTimeZone= parser.parseExpression("#systemProperties['user.timezone']");
        parser.parseExpression("timeZone").setValue(userContext, expTimeZone.getValue(propsContext));

        System.out.println(user);





    }
}
