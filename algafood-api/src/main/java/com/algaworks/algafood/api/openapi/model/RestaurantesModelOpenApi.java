package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.RestauranteModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("RestaurantesModel")
@Data
public class RestaurantesModelOpenApi {

    private RestaurantesEmbeddedModelOpenApi _embedded;
    private Links _links;
    
    @ApiModel("RestaurantesEmbeddedModel")
    @Data
    public class RestaurantesEmbeddedModelOpenApi {
        
        private List<RestauranteModel> restaurantes;
        
    }
}