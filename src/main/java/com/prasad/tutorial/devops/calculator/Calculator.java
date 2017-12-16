package com.prasad.tutorial.devops.calculator;

import org.springframework.stereotype.Service;


/**
 *	Calculator Service
 */
@Service
public class Calculator {

    public int sum(int a, int b) {
        return a+b;
    }
}
