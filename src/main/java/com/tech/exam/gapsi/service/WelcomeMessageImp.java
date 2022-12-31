/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.exam.gapsi.service;

import com.tech.exam.gaspi.vo.WelcomeMessage;

/**
 *
 * @author GLM
 */
public class WelcomeMessageImp implements IWelcomeMessage{

    @Override
    public WelcomeMessage getWelcomeMessage(String candidate) {
        return new WelcomeMessage();
    }
    
    
}
