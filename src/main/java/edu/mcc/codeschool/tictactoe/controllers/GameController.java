package edu.mcc.codeschool.tictactoe.controllers;

import edu.mcc.codeschool.tictactoe.models.Game;
import edu.mcc.codeschool.tictactoe.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
@Tag(name= "Game Controller")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> createGame(){
        return ResponseEntity.ok(gameService.createGame());
    }

    @GetMapping
    @Operation(
        description = "Get all games",
        summary = "This endpoint returns all active games in memory",
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                content = {
                    @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Game.class))
                    )
                }
            )
        }
    )
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok(gameService.getGames());
    }

    @GetMapping("/{id}")
    @Operation(
        description = "Get game by Id",
        summary = "This endpoint returns a game, if found, by its ID",
        parameters = @Parameter(
            name= "id",
            description = "The id of the game you wish to query",
            example = "123"
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
        }
    )
    public ResponseEntity<Game> getGameById(@PathVariable String id){
        return gameService.getGame(id);
    }

    @PostMapping("/clear/{id}")
    @Operation(
        description = "Clear game by Id",
        summary = "This endpoint clears a games board but leaves data about winner totals, if found, by its ID",
        parameters = @Parameter(
            name= "id",
            description = "The id of the game you wish to query",
            example = "123"
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
        }
    )
    public ResponseEntity<Game> clearGame(@PathVariable String id){
        return gameService.clearGame(id);
    }

    @PostMapping("/reset/{id}")
    public ResponseEntity<Game> resetGame(@PathVariable String id){
        return gameService.resetGame(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String id){
        return gameService.deleteGame(id);
    }

}
