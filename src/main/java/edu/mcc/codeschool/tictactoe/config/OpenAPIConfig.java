/*
 * Copyright(c)2001-2020 First National Bank of Omaha 1620 Dodge Street Omaha, NE 68197, USA All
 * rights reserved.
 *
 * <p>This software is the confidential and proprietary information of First National Bank
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with First
 * National Bank
 */
package edu.mcc.codeschool.tictactoe.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Evan Stohlmann",
            email= "esstohlmann@mccneb.edu",
            url= "https://www.mccneb.edu/Community-Business/Workforce-Innovation-Division/Workforce-Development/Programs-and-Academies/Code-School"
        ),
        description = "Open API Spec Documentation for Tic Tac Toe Application",
        title = "Tic-Tac-Toe",
        version = "1.0"
    )
)
public class OpenAPIConfig {

}
