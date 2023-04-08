package com.hsob.ogamedemo.controller;


import com.hsob.ogamedemo.dto.resource_definitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.dto.resource_definitions.response.ResourceDefinitionsResponse;
import com.hsob.ogamedemo.service.ResourceDefinitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/resources-definitions")
public class ResourceDefinitionsController {

    @Autowired
    private ResourceDefinitionsService resourceDefinitionsService;

    @PostMapping("/create")
    public ResponseEntity<ResourceDefinitionsRequest> createNewResourceDefinitions(@RequestBody ResourceDefinitionsRequest resourceDefinitionsRequest, UriComponentsBuilder uriBuilder){
        var resource = resourceDefinitionsService.createNewResourceDefinitions(resourceDefinitionsRequest);
        var uri = uriBuilder.path("/resources/create/{_id}").buildAndExpand(resource).toUri();
        return ResponseEntity.created(uri).body(resource);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ResourceDefinitionsResponse>> getAllResourcesDefinitionsByType(@RequestHeader String type){
        return ResponseEntity.ok(resourceDefinitionsService.getAllResourcesDefinitionsByType(type));
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<ResourceDefinitionsResponse> getResourcesDefinitionsById(@RequestHeader String id){
        return ResponseEntity.ok(resourceDefinitionsService.getAllResourcesDefinitionsById(id));
    }

}
