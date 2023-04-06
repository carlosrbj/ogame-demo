package com.hsob.ogamedemo.controller;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import com.hsob.ogamedemo.dto.resourceDefinitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;
    @PostMapping("/create")
    public ResponseEntity<ResourceRequest> createNewResource(@RequestBody ResourceRequest resourceRequest, UriComponentsBuilder uriBuilder){
        var resource = resourcesService.createNewResource(resourceRequest);
        var uri = uriBuilder.path("/resources/create/{_id}").buildAndExpand(resource).toUri();
        return ResponseEntity.created(uri).body(resource);
    }
}
