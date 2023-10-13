/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.adiwave.apifirst.davidedemo.api;

import io.adiwave.apifirst.davidedemo.model.Book;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-07T11:27:16.747167500+02:00[Europe/Berlin]")
@Validated
@Tag(name = "books", description = "the books API")
public interface BooksApi {

    /**
     * POST /books : Create a book
     * Creates a new instance of a &#x60;book&#x60;.
     *
     * @param book A new &#x60;book&#x60; to be created. (required)
     * @return Successful response. (status code 201)
     */
    @Operation(
        operationId = "createbook",
        summary = "Create a book",
        description = "Creates a new instance of a `book`.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Successful response.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/books",
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> createbook(
        @Parameter(name = "Book", description = "A new `book` to be created.", required = true) @Valid @RequestBody Mono<Book> book,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(book).then(Mono.empty());

    }


    /**
     * DELETE /books/{bookId} : Delete a book
     * Deletes an existing &#x60;book&#x60;.
     *
     * @param bookId A unique identifier for a &#x60;book&#x60;. (required)
     * @return Successful response. (status code 204)
     */
    @Operation(
        operationId = "deletebook",
        summary = "Delete a book",
        description = "Deletes an existing `book`.",
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful response.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/books/{bookId}"
    )
    default Mono<ResponseEntity<Void>> deletebook(
        @Parameter(name = "bookId", description = "A unique identifier for a `book`.", required = true, in = ParameterIn.PATH) @PathVariable("bookId") String bookId,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }


    /**
     * GET /books/{bookId} : Get a book
     * Gets the details of a single instance of a &#x60;book&#x60;.
     *
     * @param bookId A unique identifier for a &#x60;book&#x60;. (required)
     * @return Successful response - returns a single &#x60;book&#x60;. (status code 200)
     *         or Book with the id specified not found (status code 404)
     */
    @Operation(
        operationId = "getbook",
        summary = "Get a book",
        description = "Gets the details of a single instance of a `book`.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response - returns a single `book`.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))
            }),
            @ApiResponse(responseCode = "404", description = "Book with the id specified not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/books/{bookId}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Book>> getbook(
        @Parameter(name = "bookId", description = "A unique identifier for a `book`.", required = true, in = ParameterIn.PATH) @PathVariable("bookId") String bookId,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"isbn\" : \"12345\", \"title\" : \"My title\", \"author\" : \"My Authors\", \"cost\" : 45.5, \"isPublished\" : true, \"publishDate\" : \"2013-10-02T10:15:10.513Z\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /books : List All books
     * Gets a list of all &#x60;book&#x60; entities.
     *
     * @return Successful response - returns an array of &#x60;book&#x60; entities. (status code 200)
     */
    @Operation(
        operationId = "getbooks",
        summary = "List All books",
        description = "Gets a list of all `book` entities.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response - returns an array of `book` entities.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Book.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/books",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<Book>>> getbooks(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"isbn\" : \"12345\", \"title\" : \"My title\", \"author\" : \"My Authors\", \"cost\" : 45.5, \"isPublished\" : true, \"publishDate\" : \"2013-10-02T10:15:10.513Z\" }, { \"isbn\" : \"12345\", \"title\" : \"My title\", \"author\" : \"My Authors\", \"cost\" : 45.5, \"isPublished\" : true, \"publishDate\" : \"2013-10-02T10:15:10.513Z\" } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * PUT /books/{bookId} : Update a book
     * Updates an existing &#x60;book&#x60;.
     *
     * @param bookId A unique identifier for a &#x60;book&#x60;. (required)
     * @param book Updated &#x60;book&#x60; information. (required)
     * @return Successful response. (status code 202)
     */
    @Operation(
        operationId = "updatebook",
        summary = "Update a book",
        description = "Updates an existing `book`.",
        responses = {
            @ApiResponse(responseCode = "202", description = "Successful response.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/books/{bookId}",
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> updatebook(
        @Parameter(name = "bookId", description = "A unique identifier for a `book`.", required = true, in = ParameterIn.PATH) @PathVariable("bookId") String bookId,
        @Parameter(name = "Book", description = "Updated `book` information.", required = true) @Valid @RequestBody Mono<Book> book,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(book).then(Mono.empty());

    }

}