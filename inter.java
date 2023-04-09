package com.example.java__project;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface inter {

    void searchf() throws FileNotFoundException;
    void calculate();
    void  save(ActionEvent event) throws IOException;


}
