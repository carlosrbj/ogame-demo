package com.hsob.ogamedemo.controller;


import com.hsob.ogamedemo.dto.resource.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.service.ResourceDefinitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/resources-definitions")
public class ResourceDefinitionsController {

    @Autowired
    private ResourceDefinitionsService resourceDefinitionsService;

    @PostMapping("/create")
    public ResponseEntity<ResourceDefinitionsRequest> createNewResource(@RequestBody ResourceDefinitionsRequest resourceDefinitionsRequest, UriComponentsBuilder uriBuilder){
        var resource = resourceDefinitionsService.createNewResourceDefinitions(resourceDefinitionsRequest);
        var uri = uriBuilder.path("/resources/create/{_id}").buildAndExpand(resource).toUri();
        return ResponseEntity.created(uri).body(resource);
    }
}
