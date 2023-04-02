package com.hsob.ogamedemo.model.resources;


import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private User user;
    private List<Resources> resourcesList;
    private LocalDateTime requisitionTime;
}
