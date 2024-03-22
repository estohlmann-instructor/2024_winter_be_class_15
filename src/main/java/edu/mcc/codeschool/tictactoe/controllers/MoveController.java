package edu.mcc.codeschool.tictactoe.controllers;

import edu.mcc.codeschool.tictactoe.models.Game;
import edu.mcc.codeschool.tictactoe.models.Move;
import edu.mcc.codeschool.tictactoe.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/moves")
@Tag(name = "Move Controller")
public class MoveController {

    private final GameService gameService;

    public MoveController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @Operation(
        description = "Make a move",
        summary = "This endpoint makes a Move in an active game",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Move JSON Body",
            content = {
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Move.class)
                )
            }
        ),
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = {
                    @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Game.class)
                    )
                }
            ),
            @ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = {@Content(schema = @Schema(example = " "))}
            ),
            @ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = {@Content(schema = @Schema(example = " "))}
            ),
        }
    )
    public ResponseEntity<Game> makeMove(@RequestBody @Valid Move request){
        return gameService.makeMove(request);
    }
}
