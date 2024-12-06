package com.antilob.engine.controller;

import com.antilob.engine.service.IDataService;

//@Controller
public class DataController {
    public final IDataService dataService;

    DataController(IDataService dataService) {
        this.dataService = dataService;
    }

}
