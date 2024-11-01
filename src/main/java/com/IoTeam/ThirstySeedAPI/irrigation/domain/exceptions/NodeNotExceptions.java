package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class NodeNotExceptions extends RuntimeException{
     public NodeNotExceptions(Long nodeId){
         super("Node not found with id: " + nodeId);
    }
}
