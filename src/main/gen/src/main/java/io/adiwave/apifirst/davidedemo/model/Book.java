package io.adiwave.apifirst.davidedemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.RepresentationModel;

import java.util.*;
import jakarta.annotation.Generated;

/**
 * This is our book main domain that will be used in our microservice
 */

@Schema(name = "book", description = "This is our book main domain that will be used in our microservice")
@JsonTypeName("book")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-27T22:28:04.882568+02:00[Europe/Berlin]")
public class Book extends RepresentationModel<Book>  {

  private String isbn;

  private String title;

  private String author;

  private Double cost;

  private Boolean isPublished;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date publishDate;

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
  */
  
  @Schema(name = "isbn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isbn")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  */
  
  @Schema(name = "author", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book cost(Double cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
  */
  
  @Schema(name = "cost", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Book isPublished(Boolean isPublished) {
    this.isPublished = isPublished;
    return this;
  }

  /**
   * Get isPublished
   * @return isPublished
  */
  
  @Schema(name = "isPublished", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isPublished")
  public Boolean getIsPublished() {
    return isPublished;
  }

  public void setIsPublished(Boolean isPublished) {
    this.isPublished = isPublished;
  }

  public Book publishDate(Date publishDate) {
    this.publishDate = publishDate;
    return this;
  }

  /**
   * Get publishDate
   * @return publishDate
  */
  @Valid 
  @Schema(name = "publishDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publishDate")
  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.isbn, book.isbn) &&
        Objects.equals(this.title, book.title) &&
        Objects.equals(this.author, book.author) &&
        Objects.equals(this.cost, book.cost) &&
        Objects.equals(this.isPublished, book.isPublished) &&
        Objects.equals(this.publishDate, book.publishDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, title, author, cost, isPublished, publishDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    isPublished: ").append(toIndentedString(isPublished)).append("\n");
    sb.append("    publishDate: ").append(toIndentedString(publishDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

