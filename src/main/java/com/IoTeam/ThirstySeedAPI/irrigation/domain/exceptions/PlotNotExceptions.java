package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class PlotNotExceptions extends RuntimeException{
     public PlotNotExceptions(Long plotId){
         super("Plot not found with id: " + plotId);
    }
}
