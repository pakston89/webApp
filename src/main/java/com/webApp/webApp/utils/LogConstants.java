package com.webApp.webApp.utils;

import com.webApp.webApp.controller.ExpenseController;
import com.webApp.webApp.controller.ExpenseTypeController;
import com.webApp.webApp.controller.UserController;
import com.webApp.webApp.exception.RestControllerExceptionHandler;
import com.webApp.webApp.security.Cipher.AES256;
import org.apache.juli.logging.LogFactory;

public class LogConstants {

    public static final org.apache.juli.logging.Log UserControllerLOG = LogFactory.getLog(UserController.class);
    public static final org.apache.juli.logging.Log ExpenseControllerLOG = LogFactory.getLog(ExpenseController.class);
    public static final org.apache.juli.logging.Log ExpenseTypesControllerLOG = LogFactory.getLog(ExpenseTypeController.class);
    public static final org.apache.juli.logging.Log RestControllerExceptionHandlerLOG = LogFactory.getLog(RestControllerExceptionHandler.class);
    public static final org.apache.juli.logging.Log AES256LOG = LogFactory.getLog(AES256.class);

}
