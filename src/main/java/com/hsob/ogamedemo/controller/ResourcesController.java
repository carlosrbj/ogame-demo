package com.hsob.ogamedemo.controller;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import com.hsob.ogamedemo.dto.resource.response.ResourceResponse;
import com.hsob.ogamedemo.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @GetMapping("/get-resources-by-user")
    public ResponseEntity<List<ResourceResponse>> getresourcesByUserByUser(@RequestHeader String userId){
        return ResponseEntity.ok(resourcesService.getResourcesByUserId(userId));
    }
}
