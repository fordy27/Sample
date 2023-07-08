package com.planner.block.controller;


import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.planner.block.dto.UserDto;
import com.planner.block.form.UserForm;
import com.planner.block.service.UserService;
import com.planner.block.validators.UserValidator;


@Controller
public class HomeController {
	
	
	//initialize the logger
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//calling the service for user
	@Autowired
	private UserService userService;	
	
	//calling the validator for user
	@Autowired
    private UserValidator userValidator;
	
	
	// for assigning messages in messages_en.properties
	@Autowired
	private MessageSource messageSource;
	
	/*
	 * To display the homepage
	 * 
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) {
		
	    model.addAttribute("userForm", new UserForm());
	    model.addAttribute("errorMessage","");
	    
	    
	    return "login";
	}
	
	
	/*
	 * For saving the user
	 * 
	 * */
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(Model model, 
			@ModelAttribute("userForm") @Valid UserForm userForm ,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		logger.info("The process of adding the user is starting.");
		
		String errorMessage;
		UserDto user = new UserDto();
		Boolean userExists;
		
		// Create a new BindingResult instance to hold the errors
	    Errors newBindingResult = new BeanPropertyBindingResult(userForm, result.getObjectName());

	    // Validate the user object
	    userValidator.validate(userForm, newBindingResult);
	    
	    // Merge the new errors with any existing errors
	    result.addAllErrors(newBindingResult);
	
		//handling errors 
		if(result.hasErrors()) {
			logger.error("There is an error occured. " + result.getAllErrors());
			
			return "login";
		}
		
		//saving the user
		try {

			userExists = userService.checkIfUserExists(userForm.getUsername());		
			
			if (userForm.getPassword() == userForm.getConfirmPassword()) {
				
			}
			
			if(!userExists) {		
				//copying the data in the form to the dto
				BeanUtils.copyProperties(userForm, user);
				
				//calling the add service
				userService.addUser(user);
				
				logger.info("The process of adding the user is ended successfully.");
				
				return "success";
			}else {

				errorMessage = messageSource.getMessage("error.username.exists", null, Locale.getDefault());
	            model.addAttribute("errorMessage", errorMessage);
	            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
	            
	            logger.info("The data is not saved. User exists.");
	            
	            return "login";
			}
			
			
			
		}catch(Exception e) {
			
			//showing the error stack trace in the console
			e.printStackTrace();

			//optional when you need to debug not usingg the debugger
			//to show the error in the webpage
			//errorMessage = messageSource.getMessage("error.user.save", null, Locale.getDefault());
			//errorMessage += "The error is :["+ e.getMessage() + "].";
           // model.addAttribute("errorMessage", errorMessage);
            //redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            
            //logger.info("An error occured during the process. Error is " + e.getMessage());
            
            //return "index";
		}


		logger.info("The process of adding the user is ended successfully.");
		
		return "success";
	}
}

